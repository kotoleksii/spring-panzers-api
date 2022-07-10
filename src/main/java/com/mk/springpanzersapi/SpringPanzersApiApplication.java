package com.mk.springpanzersapi;

import com.mk.springpanzersapi.entities.auth.UserModel;
import com.mk.springpanzersapi.repository.AmmunitionRepository;
import com.mk.springpanzersapi.repository.CharacteristicsPlayerRepository;
import com.mk.springpanzersapi.repository.auth.SecretCodeRepository;
import com.mk.springpanzersapi.repository.auth.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SpringPanzersApiApplication implements CommandLineRunner {

    @Autowired
    private UserRepository playerRepository;

    @Autowired
    private SecretCodeRepository secretCodeRepository;

    @Autowired
    private CharacteristicsPlayerRepository characteristicsPlayerRepository;

    @Autowired
    private AmmunitionRepository ammunitionRepository;


    public static void main(String[] args) {
        SpringApplication.run(SpringPanzersApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //Clean up database tables
        characteristicsPlayerRepository.deleteAllInBatch();
        playerRepository.deleteAllInBatch();
        secretCodeRepository.deleteAllInBatch();

        Iterable<UserModel> persistedUser =
                playerRepository.saveAll(initializeUsers());

        //Create a Player instance
//        UserModel player = new UserModel(
//                "akkot",
//                "akkot08@gmail.com",
//                "12345678",
//                "dfgdfgdfgdg345nwWFfs",
//                "https://avatar.png");
//        playerRepository.save(player);

//
//        //Create a CharacteristicsPlayer instance
//        CharacteristicsPlayer characteristicsPlayer = new CharacteristicsPlayer(
//                "12", "10", "100000",
//                "11", "12", "2", "100"
//        );
//
//        //Set child reference(characteristicsPlayer) in parent entity(player)
//        player.setCharacteristicsPlayer(characteristicsPlayer);
//
//        //Set parent reference(player) in child entity(characteristicsPlayer)
//        characteristicsPlayer.setPlayer(player);
//
//        //Save Parent Reference (which will save the child as well)
//        playerRepository.save(player);
//
//        //Create a Ammunition instance
//        Ammunition ammunition = new Ammunition(
//                "bullet",
//                "500",
//                "20",
//                "http://aadadad.com/1.png",
//                "http://aadadad.com/2.png",
//                "http://aadadad.com/3.png");
//
//        ammunitionRepository.save(ammunition);
    }

    public static List<UserModel> initializeUsers() {
        List<UserModel> userEntities = new ArrayList<>() {{
            add(new UserModel(
                    "user",
                    "user@gmail.com",
                    "user12345678",
                    "userdfgdfgdfgdg345nwWFfs",
                    "https://useravatar.png")
            );
            add(new UserModel(
                    "user1",
                    "user1@gmail.com",
                    "user112345678",
                    "user1dfgdfgdfgdg345nwWFfs",
                    "https://user1avatar.png")
            );
            add(new UserModel(
                    "user2",
                    "user2@gmail.com",
                    "user212345678",
                    "user2dfgdfgdfgdg345nwWFfs",
                    "https://user2avatar.png")
            );
        }};
        return userEntities;
    }
}
