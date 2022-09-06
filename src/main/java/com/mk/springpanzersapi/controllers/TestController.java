package com.mk.springpanzersapi.controllers;

import com.mk.springpanzersapi.entities.CharacteristicsPlayer;
import com.mk.springpanzersapi.entities.auth.UserModel;
import com.mk.springpanzersapi.repository.CharacteristicsPlayerRepository;
import com.mk.springpanzersapi.repository.auth.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(value = "http://localhost:4200/", allowCredentials = "true")
@RestController
@RequestMapping("/api/test")
public class TestController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    CharacteristicsPlayerRepository characteristicsPlayerRepository;

    @GetMapping("/users")
    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserModel> getUserById(@PathVariable("id") long id) {
        Optional<UserModel> userData = userRepository.findById(id);

        if (userData.isPresent()) {
            return new ResponseEntity<>(userData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/users/nickname/{nickname}")
    public ResponseEntity<UserModel> getUserByNickname(@PathVariable("nickname") String nickname) {
        Optional<UserModel> userData = userRepository.findByNickname(nickname);

        if (userData.isPresent()) {
            return new ResponseEntity<>(userData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/characteristics")
    public List<CharacteristicsPlayer> getAllCharacteristics() {
        return characteristicsPlayerRepository.findAll();
    }

    @GetMapping("/users/maxrateid")
    public int getUserByMaxRate() {
        return characteristicsPlayerRepository.findPlayerIdByMaxRate();
    }

    @PostMapping("/users")
    public ResponseEntity<UserModel> createUser(@RequestBody UserModel user) {
        try {
            //TODO: Add Default Player Characteristics
            UserModel _user = userRepository
                    .save(new UserModel(
                            user.getNickname(),
                            user.getEmail(),
                            user.getPassword(),
                            user.getToken(),
                            user.getAvatarUrl()
                    ));
            return new ResponseEntity<>(_user, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<UserModel> updateUser(@PathVariable("id") long id, @RequestBody UserModel user) {
        Optional<UserModel> userData = userRepository.findById(id);

        if (userData.isPresent()) {
            UserModel _user = userData.get();
            _user.setNickname(user.getNickname());
            _user.setEmail(user.getEmail());
            _user.setPassword(user.getPassword());
            _user.setToken(user.getToken());
            _user.setAvatarUrl(user.getAvatarUrl());
            return new ResponseEntity<>(userRepository.save(_user), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") long id) {
        try {
            userRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/users")
    public ResponseEntity<HttpStatus> deleteAllUsers() {
        try {
            userRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public String userAccess() {
        return "User Content.";
    }

    @GetMapping("/mod")
    @PreAuthorize("hasRole('MODERATOR')")
    public String moderatorAccess() {
        return "Moderator Board.";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin Board.";
    }
}
