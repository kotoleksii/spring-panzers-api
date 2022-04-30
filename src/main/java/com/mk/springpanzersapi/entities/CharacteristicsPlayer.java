package com.mk.springpanzersapi.entities;

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
    private String rate;

    @Column(name = "money")
    private String money;

    @Column(name = "fights")
    private String fights;

    @Column(name = "wins")
    private String wins;

    @Column(name = "defeats")
    private String defeats;

    @Column(name = "kills")
    private String kills;

    @OneToOne
    @MapsId
    @JoinColumn(name = "player_id")
    private Player player;

    public CharacteristicsPlayer() {
    }

    public CharacteristicsPlayer(String rank, String rate, String money,
                            String fights, String wins, String defeats,
                        String kills) {
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

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getFights() {
        return fights;
    }

    public void setFights(String fights) {
        this.fights = fights;
    }

    public String getWins() {
        return wins;
    }

    public void setWins(String wins) {
        this.wins = wins;
    }

    public String getDefeats() {
        return defeats;
    }

    public void setDefeats(String defeats) {
        this.defeats = defeats;
    }

    public String getKills() {
        return kills;
    }

    public void setKills(String kills) {
        this.kills = kills;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
