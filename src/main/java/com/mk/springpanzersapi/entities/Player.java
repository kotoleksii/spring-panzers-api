package com.mk.springpanzersapi.entities;

import javax.persistence.*;

@Entity
@Table(name = "players")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "email")
    private String email;

    @Column(name = "token")
    private String token;

    @Column(name = "avatar_url")
    private String avatarUrl;

    @Column(name = "status")
    private int status;

    @OneToOne(mappedBy = "player", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private CharacteristicsPlayer characteristicsPlayer;

    public Player() {
    }

    public Player(String nickname, String email, String token,
              String avatarUrl, int status) {
        this.nickname = nickname;
        this.email = email;
        this.token = token;
        this.avatarUrl = avatarUrl;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public CharacteristicsPlayer getCharacteristicsPlayer() {
        return characteristicsPlayer;
    }

    public void setCharacteristicsPlayer(CharacteristicsPlayer characteristicsPlayer) {
        this.characteristicsPlayer = characteristicsPlayer;
    }
}
