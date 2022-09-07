package com.mk.springpanzersapi.repository;

import com.mk.springpanzersapi.entities.CharacteristicsPlayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface CharacteristicsPlayerRepository
        extends JpaRepository<CharacteristicsPlayer, Long> {
    @Query(value = "SELECT player_id FROM characteristics_player WHERE rate = (SELECT MAX(rate) FROM characteristics_player) ORDER BY player_id ASC LIMIT 1", nativeQuery = true)
    long findPlayerIdByMaxRate();
}
