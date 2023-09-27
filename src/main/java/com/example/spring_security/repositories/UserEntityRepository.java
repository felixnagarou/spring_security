package com.example.spring_security.repositories;

import com.example.spring_security.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserEntityRepository extends JpaRepository<UserEntity, UUID> {

        Optional<UserEntity> findByEmail(String email);
        Boolean existsByEmail(String email);



}
