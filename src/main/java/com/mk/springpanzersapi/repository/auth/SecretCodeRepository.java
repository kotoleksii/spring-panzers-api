package com.mk.springpanzersapi.repository.auth;

import com.mk.springpanzersapi.entities.auth.SecretCodeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SecretCodeRepository extends JpaRepository<SecretCodeModel, Long> {
    SecretCodeModel findByEmail(String email);
    Boolean existsByEmail(String email);
}
