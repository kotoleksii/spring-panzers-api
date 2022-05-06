package com.mk.springpanzersapi.repository;

import com.mk.springpanzersapi.entities.ERole;
import com.mk.springpanzersapi.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
