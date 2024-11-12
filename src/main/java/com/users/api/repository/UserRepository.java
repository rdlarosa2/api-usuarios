package com.users.api.repository;

import com.users.api.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    List<UserEntity> findAll();
    UserEntity findById(int id);
    Optional<UserEntity> findByEmail(String username);
    List<UserEntity> findByName(String username);
    Boolean existsByEmail(String username);
    UserEntity save(UserEntity theUser);
}
