package com.example.PetProject3.services;

import com.example.PetProject3.models.Employee;
import com.example.PetProject3.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(int id) {
        return employeeRepository.findById(id);
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(int id, Employee updateEmployee) {
        return employeeRepository.findById(id)
                .map(employee -> employee.withUpdatedData(updateEmployee))
                .orElseThrow(() -> new IllegalArgumentException("Employee not found with: " + id));
    }

    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }



    }

