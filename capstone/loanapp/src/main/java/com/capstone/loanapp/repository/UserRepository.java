package com.capstone.loanapp.repository;

import com.capstone.loanapp.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users,Long> {

    Optional<Users> findByEmail(String username);
}
