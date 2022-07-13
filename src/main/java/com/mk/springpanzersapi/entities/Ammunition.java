package com.mk.springpanzersapi.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "ammunition")
public class Ammunition implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "model")
    private String model;

    @Column(name = "damage")
    private String damage;

    @Column(name = "quantity")
    private String quantity;

    @Column(name = "bullet_url")
    private String bulletUrl;

    @Column(name = "shoot_url")
    private String shootUrl;

    @Column(name = "boom_url")
    private String boomUrl;

    public Ammunition(String model, String damage, String quantity,
                  String bulletUrl, String shootUrl, String boomUrl) {
        this.model = model;
        this.damage = damage;
        this.quantity = quantity;
        this.bulletUrl = bulletUrl;
        this.shootUrl = shootUrl;
        this.boomUrl = boomUrl;
    }
}
