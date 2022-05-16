package com.mk.springpanzersapi.controllers.auth;

import com.mk.springpanzersapi.controllers.auth.classes.SecretCode;
import com.mk.springpanzersapi.entities.CharacteristicsPlayer;
import com.mk.springpanzersapi.entities.auth.SecretCodeModel;
import com.mk.springpanzersapi.entities.auth.UserModel;
import com.mk.springpanzersapi.payload.request.auth.LoginRequest;
import com.mk.springpanzersapi.payload.request.auth.SecretCodeRequest;
import com.mk.springpanzersapi.payload.request.auth.SignupRequest;
import com.mk.springpanzersapi.payload.response.JwtResponse;
import com.mk.springpanzersapi.payload.response.MessageResponse;
import com.mk.springpanzersapi.repository.RoleRepository;
import com.mk.springpanzersapi.repository.auth.SecretCodeRepository;
import com.mk.springpanzersapi.repository.auth.UserRepository;
import com.mk.springpanzersapi.security.jwt.JwtUtils;
import com.mk.springpanzersapi.security.services.auth.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.TimerTask;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    SecretCodeRepository secretCodeRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getNickname(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userRepository.existsByNickname(signUpRequest.getNickname())) {
            return ResponseEntity
                    .ok(new MessageResponse("Nickname is already taken!", "nickname", false));
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .ok(new MessageResponse("Email is already in use!", "email", false));
        }

        UserModel user = new UserModel(
                signUpRequest.getNickname(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()),
                signUpRequest.getToken(),
                signUpRequest.getAvatarUrl());

        //Starting characteristics of the new player
        CharacteristicsPlayer characteristicsNewPlayer = new CharacteristicsPlayer(
                "Soldier", 200, 0,
                0, 0, 0, 0
        );

        if (signUpRequest.getToken().equals("")) {
            String code = SecretCode.sendCode(user);
            secretCodeRepository.save(new SecretCodeModel(code, user.getEmail()));

            //delete secret code after 60 sec
            deleteSecretCodeByUserAfterSetTime(user, 60);

            //Set startup characteristics for new user
            user.setCharacteristicsPlayer(characteristicsNewPlayer);
            characteristicsNewPlayer.setUser(user);
            userRepository.save(user);

            return ResponseEntity
                    .ok(new MessageResponse("Redirect to secret code!", "", true));
        }

//region SetRoles
//        Set<String> strRoles = signUpRequest.getRole();
//        Set<Role> roles = new HashSet<>();
//
//        if (strRoles == null) {
//            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
//                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//            roles.add(userRole);
//        } else {
//            strRoles.forEach(role -> {
//                switch (role) {
//                    case "admin":
//                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
//                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//                        roles.add(adminRole);
//
//                        break;
//                    case "mod":
//                        Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
//                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//                        roles.add(modRole);
//
//                        break;
//                    default:
//                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
//                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//                        roles.add(userRole);
//                }
//            });
//        }
//
//        user.setRoles(roles);
//endregion

        //Set startup characteristics for new user
        user.setCharacteristicsPlayer(characteristicsNewPlayer);
        characteristicsNewPlayer.setUser(user);

        userRepository.save(user);
        return ResponseEntity.ok(new MessageResponse("User registered successfully!", "", true));
    }

    @PostMapping("/code")
    public ResponseEntity<?> checkCode(@Valid @RequestBody SecretCodeRequest codeRequest) {
        if (secretCodeRepository.existsByEmail(codeRequest.getEmail())) {
            SecretCodeModel codeModel = secretCodeRepository.findByEmail(codeRequest.getEmail());

            if (codeRequest.getCode().equals(codeModel.getCode())) {
                //TODO: delete codeByEmail or entry???
//                codeModel.setCode("");
//                secretCodeRepository.save(codeModel);

                secretCodeRepository.delete(codeModel);

                return ResponseEntity
                        .ok(new MessageResponse("Its all right", "", true));
            }
        }
        return ResponseEntity.ok(new MessageResponse("Invalid Code", "code", false));
    }

    /**
     * time parameter in seconds
     */
    private void deleteSecretCodeByUserAfterSetTime(UserModel user, int time) {
        SecretCodeModel code = secretCodeRepository.findByEmail(user.getEmail());
        new java.util.Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                secretCodeRepository.delete(code);
            }
        }, 1000 * time);
    }
}
