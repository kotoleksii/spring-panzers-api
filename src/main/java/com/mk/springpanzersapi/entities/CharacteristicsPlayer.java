package com.mk.springpanzersapi.entities;

import com.mk.springpanzersapi.entities.auth.UserModel;

import javax.persistence.*;

@Entity
@Table(name = "characteristics_player")
public class CharacteristicsPlayer {
    @Id
    @Column(name = "player_id")
    private Long id;

    @Column(name = "rank")
    private String rank;

    @Column(name = "rate")
    private int rate;

    @Column(name = "money")
    private int money;

    @Column(name = "fights")
    private int fights;

    @Column(name = "wins")
    private int wins;

    @Column(name = "defeats")
    private int defeats;

    @Column(name = "kills")
    private int kills;

    @OneToOne
    @MapsId
    @JoinColumn(name = "player_id")
    private UserModel user;

    public CharacteristicsPlayer() {
    }

    public CharacteristicsPlayer(String rank, int rate, int money, int fights,
                                 int wins, int defeats, int kills) {
        this.rank = rank;
        this.rate = rate;
        this.money = money;
        this.fights = fights;
        this.wins = wins;
        this.defeats = defeats;
        this.kills = kills;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getFights() {
        return fights;
    }

    public void setFights(int fights) {
        this.fights = fights;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getDefeats() {
        return defeats;
    }

    public void setDefeats(int defeats) {
        this.defeats = defeats;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }
}

