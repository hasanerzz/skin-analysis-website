package com.serralyse.website.repository;

import com.serralyse.website.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    @Override
    Optional<User> findById(UUID uuid);
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
}
