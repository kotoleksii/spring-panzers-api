package com.mk.springpanzersapi;

import com.mk.springpanzersapi.entities.Ammunition;
import com.mk.springpanzersapi.entities.CharacteristicsPlayer;
import com.mk.springpanzersapi.entities.Player;
import com.mk.springpanzersapi.repository.AmmunitionRepository;
import com.mk.springpanzersapi.repository.CharacteristicsPlayerRepository;
import com.mk.springpanzersapi.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringPanzersApiApplication implements CommandLineRunner {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private CharacteristicsPlayerRepository characteristicsPlayerRepository;

    @Autowired
    private AmmunitionRepository ammunitionRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringPanzersApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        //Clean up database tables
//        characteristicsPlayerRepository.deleteAllInBatch();
//        playerRepository.deleteAllInBatch();
//        ammunitionRepository.deleteAllInBatch();
//
//        //Create a Player instance
//        Player player = new Player(
//                "player", "player@mail.com",
//                "dadadadwdwdadadad",
//                "https://dadadaddad.com/app.png",
//                0);
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
//         //Set parent reference(player) in child entity(characteristicsPlayer)
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
}
