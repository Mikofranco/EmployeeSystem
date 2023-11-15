package org.example.data.repo;

import org.example.data.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepo extends JpaRepository<Admin,Long> {
    Optional<Admin> findByEmailAndPassword(String email, String password);
    Optional<Admin> findByEmail(String email);
}
