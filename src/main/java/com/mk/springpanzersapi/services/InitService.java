package com.mk.springpanzersapi.services;

import com.mk.springpanzersapi.entities.Ammunition;
import com.mk.springpanzersapi.entities.CharacteristicsPlayer;
import com.mk.springpanzersapi.entities.auth.UserModel;

import java.util.ArrayList;
import java.util.List;

public class InitService {
    public static List<UserModel> getUsersData() {
        List<UserModel> userEntities = new ArrayList<>() {{
            add(new UserModel("user", "user@gmail.com",
                    "user12345678", "userdfgdfgdfgdg345nwWFfs",
                    "https://useravatar.png")
            );
            add(new UserModel("user1", "user1@gmail.com",
                    "user112345678", "user1dfgdfgdfgdg345nwWFfs",
                    "https://user1avatar.png")
            );
            add(new UserModel(
                    "user2", "user2@gmail.com",
                    "user212345678", "user2dfgdfgdfgdg345nwWFfs",
                    "https://user2avatar.png")
            );
        }};
        return userEntities;
    }

    public static CharacteristicsPlayer getDefaultCharacteristicsPlayers() {
        CharacteristicsPlayer characteristicsPlayer = new CharacteristicsPlayer(
                "Soldier", 200, 0,
                0, 0, 0, 0
        );
        return characteristicsPlayer;
    }

    public static Ammunition getAmmunitionData() {
        Ammunition ammunition = new Ammunition(
                "bullet", "500",
                "20", "http://aadadad.com/1.png",
                "http://aadadad.com/2.png",
                "http://aadadad.com/3.png"
        );
        return ammunition;
    }
}
