package io.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.example.entity.Employee;
import io.example.repository.EmployeeRepository;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;

    // Create Employee (POST)
    @PostMapping
    public Employee addEmployee(@RequestBody Employee emp) {
        return repository.save(emp);
    }

    // Get All Employees (GET)
    @GetMapping
    public List<Employee> getEmployees() {
        return repository.findAll();
    }

    // Get Employee by ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update Employee (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee emp) {
        return repository.findById(id).map(existing -> {
            existing.setName(emp.getName());
            existing.setDepartment(emp.getDepartment());
            existing.setSalary(emp.getSalary());
            return ResponseEntity.ok(repository.save(existing));
        }).orElse(ResponseEntity.notFound().build());
    }

    // Delete Employee (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
