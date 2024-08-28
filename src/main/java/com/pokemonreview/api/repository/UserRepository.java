package com.pokemonreview.api.repository;

import com.pokemonreview.api.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    List<UserEntity> findAll();
    UserEntity findById(int id);
    Optional<UserEntity> findByEmail(String username);
    Boolean existsByEmail(String username);
    UserEntity save(UserEntity theUser);
}
