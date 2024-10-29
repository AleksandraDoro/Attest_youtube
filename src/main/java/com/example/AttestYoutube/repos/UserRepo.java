package com.example.AttestYoutube.repos;

import com.example.AttestYoutube.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
