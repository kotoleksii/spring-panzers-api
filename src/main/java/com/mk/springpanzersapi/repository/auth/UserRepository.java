package com.mk.springpanzersapi.repository.auth;

import com.mk.springpanzersapi.entities.CharacteristicsPlayer;
import com.mk.springpanzersapi.entities.auth.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;

@Repository
@CrossOrigin(value = "http://localhost:4200/")
public interface UserRepository extends JpaRepository<UserModel, Long> {
    Optional<UserModel> findByNickname(String nickname);

    Boolean existsByNickname(String nickname);

    Boolean existsByEmail(String email);

    Boolean existsByToken(String token);

    @Query("SELECT COUNT(u) FROM UserModel u WHERE u.status=true")
    int countByStatusTrue();

    @Query(value = "SELECT count(*) FROM users", nativeQuery = true)
    int countUsers();
}

