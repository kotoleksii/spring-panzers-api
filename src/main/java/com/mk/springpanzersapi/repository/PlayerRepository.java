package com.mk.springpanzersapi.repository;

import com.mk.springpanzersapi.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
}
