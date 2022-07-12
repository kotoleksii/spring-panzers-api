package com.mk.springpanzersapi;

import com.mk.springpanzersapi.entities.Ammunition;
import com.mk.springpanzersapi.entities.CharacteristicsPlayer;
import com.mk.springpanzersapi.entities.auth.UserModel;
import com.mk.springpanzersapi.repository.AmmunitionRepository;
import com.mk.springpanzersapi.repository.CharacteristicsPlayerRepository;
import com.mk.springpanzersapi.repository.auth.SecretCodeRepository;
import com.mk.springpanzersapi.repository.auth.UserRepository;
import com.mk.springpanzersapi.services.InitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
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
        ammunitionRepository.deleteAllInBatch();
        secretCodeRepository.deleteAllInBatch();

        initGameData();
    }

    public void initGameData() {
        //Create a Player instance
        List<UserModel> users = InitService.getUsersData();

        //Create a CharacteristicsPlayer instance
        CharacteristicsPlayer characteristicsPlayer =
                InitService.getDefaultCharacteristicsPlayers();

        //Set child reference(characteristicsPlayer) in parent entity(player)
        users.get(0).setCharacteristicsPlayer(characteristicsPlayer);
        //Set parent reference(player) in child entity(characteristicsPlayer)
        characteristicsPlayer.setUser(users.get(0));
        //Save Parent Reference (which will save the child as well)
        playerRepository.save(users.get(0));

        users.get(1).setCharacteristicsPlayer(characteristicsPlayer);
        characteristicsPlayer.setUser(users.get(1));
        playerRepository.save(users.get(1));

        users.get(2).setCharacteristicsPlayer(characteristicsPlayer);
        characteristicsPlayer.setUser(users.get(2));
        playerRepository.save(users.get(2));

        //Create an Ammunition instance
        Ammunition ammunition = InitService.getAmmunitionData();

        ammunitionRepository.save(ammunition);
    }
}
