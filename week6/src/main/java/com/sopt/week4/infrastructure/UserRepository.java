package com.sopt.week4.infrastructure;

import com.sopt.week4.domain.User;
import org.springframework.data.repository.Repository;


import java.util.Optional;

public interface UserRepository extends Repository<User, Long> {

    // CREATE
    void save(User user);

    // READ
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);

    Optional<User> findById(Long userId);
}
