package com.hellokoding.account.repository;

import com.hellokoding.account.model.User;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    User findById(Long id);
    User findByUsername(String username);
}
