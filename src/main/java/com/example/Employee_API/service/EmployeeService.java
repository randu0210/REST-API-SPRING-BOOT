package com.example.Employee_API.service;

import com.example.Employee_API.entity.Employee;
import com.example.Employee_API.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeService {
    @Autowired
    private EmployeeRepository employee;

    public Employee getEmployeeById(int id){
        return employee.findById(id).orElse(null);
    }
}
