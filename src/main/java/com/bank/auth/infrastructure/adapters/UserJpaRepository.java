package com.bank.auth.infrastructure.adapters;

import com.bank.auth.domain.model.User;
import com.bank.auth.domain.ports.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserJpaRepository extends JpaRepository<User, UUID>, UserRepository {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
}