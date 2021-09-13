package com.demo.springjwtrefreshtoken.repo;

import com.demo.springjwtrefreshtoken.modal.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
