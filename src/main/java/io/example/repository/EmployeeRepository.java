package io.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import io.example.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
