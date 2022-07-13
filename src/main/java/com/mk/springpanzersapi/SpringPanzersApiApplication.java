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

        //Create All Instances
        initGameData();
    }

    public void initGameData() {
        //Create a Player instance
        List<UserModel> users = InitService.getUsersData();

        UserModel user1 = users.get(0);
        UserModel user2 = users.get(1);
        UserModel user3 = users.get(2);

        //Create a CharacteristicsPlayer instance
        CharacteristicsPlayer characteristicsPlayer =
                InitService.getDefaultCharacteristicsPlayers();

        //Set child reference(characteristicsPlayer) in parent entity(player)
        user1.setCharacteristicsPlayer(characteristicsPlayer);
        //Set parent reference(player) in child entity(characteristicsPlayer)
        characteristicsPlayer.setUser(user1);
        //Save Parent Reference (which will save the child as well)
        playerRepository.save(user1);

        user2.setCharacteristicsPlayer(characteristicsPlayer);
        characteristicsPlayer.setUser(user2);
        playerRepository.save(user2);

        user3.setCharacteristicsPlayer(characteristicsPlayer);
        characteristicsPlayer.setUser(user3);
        playerRepository.save(user3);

        //Create an Ammunition instance
        Ammunition ammunition = InitService.getAmmunitionData();
        ammunitionRepository.save(ammunition);
    }
}
