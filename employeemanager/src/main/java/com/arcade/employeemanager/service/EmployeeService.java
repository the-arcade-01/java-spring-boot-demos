package com.arcade.employeemanager.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.arcade.employeemanager.model.EmployeeModel;
import com.arcade.employeemanager.repo.EmployeeRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private final EmployeeRepo repository;

    @Autowired
    public EmployeeService(EmployeeRepo repository) {
        this.repository = repository;
    }

    public EmployeeModel addEmployee(EmployeeModel employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return repository.save(employee);
    }

    public List<EmployeeModel> findAllEmployees() {
        return repository.findAll();
    }

    public Optional<Object> updateEmployee(EmployeeModel updateEmployee, Long id) {
        return repository.findById(id).map((employee) -> {
            employee.setName(updateEmployee.getName());
            employee.setEmail(updateEmployee.getEmail());
            employee.setPhone(updateEmployee.getPhone());
            employee.setJobTitle(updateEmployee.getJobTitle());
            employee.setImageUrl(updateEmployee.getImageUrl());
            return repository.save(employee);
        });
    }

    public Optional<EmployeeModel> findEmployee(Long id) {
        return repository.findById(id);
    }

    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }
}
