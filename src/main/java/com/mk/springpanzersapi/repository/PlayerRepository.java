package com.mk.springpanzersapi.repository;

import com.mk.springpanzersapi.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository
        extends JpaRepository<Player, Long> {
}
