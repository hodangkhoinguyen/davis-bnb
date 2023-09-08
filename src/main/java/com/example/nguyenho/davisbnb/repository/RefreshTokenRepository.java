package com.example.nguyenho.davisbnb.repository;

import com.example.nguyenho.davisbnb.model.RefreshToken;
import com.example.nguyenho.davisbnb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByToken(String token);

    @Modifying
    int deleteByUser(User user);
    @Modifying
    int deleteByToken(String token);
}
