package org.example.data.repo;

import org.example.data.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Employee, Long> {
}
