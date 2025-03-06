package io.example.service;

import io.example.dto.EmployeeDTO;
import io.example.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee(EmployeeDTO employeeDTO);

    List<Employee> getAllEmployees();
}
