package com.arcade.employeemanager.repo;

import com.arcade.employeemanager.model.EmployeeModel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<EmployeeModel, Long> {

}