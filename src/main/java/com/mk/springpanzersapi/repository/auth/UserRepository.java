package com.mk.springpanzersapi.repository.auth;

import com.mk.springpanzersapi.entities.auth.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    Optional<UserModel> findByNickname(String nickname);
    Boolean existsByNickname(String nickname);
    Boolean existsByEmail(String email);
    Boolean existsByToken(String token);

    List<UserModel> findAll();
}

