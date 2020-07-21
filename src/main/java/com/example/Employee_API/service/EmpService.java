package com.example.Employee_API.service;

import com.example.Employee_API.entity.Employee;
import com.example.Employee_API.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpService {

    @Autowired
    private EmpRepository empRepository;


    public List<Employee> getEmployee(){return empRepository.findAll();}
    public Employee getEmployeeById(int id){
        return empRepository.findById(id).orElse(null);
    }
    public String deleteEmployee(int id_employee){
        empRepository.deleteById(id_employee);
        return "employee remove";
    }
    public Employee updateEmployee(Employee employee){
        Employee existingEmployee = empRepository.findById(employee.getId_employee()).orElse(null);
        existingEmployee.setId_employee(employee.getId_employee());
        existingEmployee.setName(employee.getName());
        existingEmployee.setUsername(employee.getUsername());
        existingEmployee.setPassword(employee.getPassword());
        existingEmployee.setTtl(employee.getTtl());
        existingEmployee.setSalary(employee.getSalary());
        return empRepository.save(existingEmployee);
    }

}
