package com.example.Employee_API.controller;

import com.example.Employee_API.dto.EmpRequest;
import com.example.Employee_API.entity.Employee;
import com.example.Employee_API.repository.EmpRepository;
import com.example.Employee_API.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class EmpController {
    @Autowired
    private EmpService empService;
    @Autowired
    private EmpRepository empRepository;

    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody EmpRequest empRequest){
            return empRepository.save(empRequest.getEmployee());
    }
    @GetMapping("/getEmployee")
    public List<Employee> findAllEmployee(){return empService.getEmployee();}
}
