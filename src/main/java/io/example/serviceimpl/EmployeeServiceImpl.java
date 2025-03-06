package io.example.serviceimpl;

import io.example.dto.EmployeeDTO;
import io.example.entity.Employee;
import io.example.repository.EmployeeRepository;
import io.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository; // Inject repository

    @Override
    public Employee addEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setName(employeeDTO.getName());
        employee.setSalary(employeeDTO.getSalary());
        employee.setDepartment(employeeDTO.getDepartment());

        return employeeRepository.save(employee); // Save to database
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll(); // Fetch from database
    }
}
