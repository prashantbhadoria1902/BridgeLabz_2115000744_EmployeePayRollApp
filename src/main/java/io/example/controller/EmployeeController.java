package io.example.controller;

import io.example.dto.EmployeeDTO;
import io.example.entity.Employee;
import io.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository; // Inject repository

    // Create an Employee
    @PostMapping("/add")
    public String addEmployee(@RequestBody EmployeeDTO employeeDTO) {
        if (employeeDTO.getName() == null || employeeDTO.getName().isEmpty()) {
            return "Invalid employee name";
        }

        Employee employee = new Employee();
        employee.setName(employeeDTO.getName());
        employee.setSalary(employeeDTO.getSalary());
        employee.setDepartment(employeeDTO.getDepartment());

        employeeRepository.save(employee); // Save to database
        return "Employee added successfully!";
    }

    // Get all Employees from the database
    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll(); // Fetch from DB
    }
}
