package io.example.repository;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import io.example.entity.Employee;

@Repository
@EnableJpaRepositories("io.example.repository")
@EntityScan("io.example.entity")
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
