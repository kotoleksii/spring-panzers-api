package com.mk.springpanzersapi.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mk.springpanzersapi.entities.auth.UserModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
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

    @OneToOne(optional = false)
    @MapsId
    @JsonBackReference
    @JoinColumn(name = "player_id")
    private UserModel user;

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
}

