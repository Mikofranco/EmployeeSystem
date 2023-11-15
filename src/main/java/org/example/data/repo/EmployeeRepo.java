package org.example.data.repo;

import org.example.data.model.Admin;
import org.example.data.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    Optional<Employee> findByEmailAndPassword(String email, String password);
    Optional<Employee> findByEmail(String email);

}
