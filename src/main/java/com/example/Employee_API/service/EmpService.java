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

}
