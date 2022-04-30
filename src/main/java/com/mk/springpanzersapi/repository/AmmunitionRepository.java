package com.mk.springpanzersapi.repository;

import com.mk.springpanzersapi.entities.Ammunition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmmunitionRepository
        extends JpaRepository<Ammunition, Long> {
}
