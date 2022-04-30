package com.mk.springpanzersapi.repository;

import com.mk.springpanzersapi.entities.CharacteristicsPlayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacteristicsPlayerRepository
        extends JpaRepository<CharacteristicsPlayer, Long> {
}
