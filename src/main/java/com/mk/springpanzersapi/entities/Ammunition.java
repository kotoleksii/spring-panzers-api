package com.mk.springpanzersapi.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
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

    public Ammunition() {
    }

    public Ammunition(String model, String damage, String quantity,
                  String bulletUrl, String shootUrl, String boomUrl) {
        this.model = model;
        this.damage = damage;
        this.quantity = quantity;
        this.bulletUrl = bulletUrl;
        this.shootUrl = shootUrl;
        this.boomUrl = boomUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDamage() {
        return damage;
    }

    public void setDamage(String damage) {
        this.damage = damage;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getBulletUrl() {
        return bulletUrl;
    }

    public void setBulletUrl(String bulletUrl) {
        this.bulletUrl = bulletUrl;
    }

    public String getShootUrl() {
        return shootUrl;
    }

    public void setShootUrl(String shootUrl) {
        this.shootUrl = shootUrl;
    }

    public String getBoomUrl() {
        return boomUrl;
    }

    public void setBoomUrl(String boomUrl) {
        this.boomUrl = boomUrl;
    }
}
