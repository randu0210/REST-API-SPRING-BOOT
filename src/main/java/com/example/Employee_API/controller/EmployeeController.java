package com.example.Employee_API.controller;

import com.example.Employee_API.dto.DTORequest;
import com.example.Employee_API.dto.DTOResponse;
import com.example.Employee_API.dto.loginRequest;
import com.example.Employee_API.dto.loginResponse;
import com.example.Employee_API.entity.Employee;
import com.example.Employee_API.repository.EmployeeRepository;
import com.example.Employee_API.service.EmployeeService;
import com.example.Employee_API.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class EmployeeController {
    @Autowired
    private EmployeeRepository employee;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private JWTUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/addEmployee")
    private Employee saveSales(@RequestBody DTORequest request) {
        return employee.save(request.getEmployee());
    }
    @PostMapping("/addEmployeeById/{id}")
    private Employee saveSalesById(@RequestBody DTORequest request, @PathVariable int id) {
        return employee.save(employeeService.getEmployeeById(id));
    }
    @GetMapping("/getDataEmployee")
    private List<Employee> getDataEmployee(){ return employee.getDataEmployee(); }

    @GetMapping("/getDataEmployeeByName/{username}")
    private List<Employee> getDataEmployeeByName(@PathVariable String username){ return employee.getDataEmployeeByName(username); }

    @GetMapping("/getEmployee")
    private List<DTOResponse> getEmployee(){ return employee.getAllDataEmployee(); }

    @GetMapping("/getEmployeeById/{id}")
    public Employee findEmployeeById(@PathVariable int id){ return employeeService.getEmployeeById(id); }

    @PostMapping("/auth")
    public loginResponse authenticate(@RequestBody loginRequest loginRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
            );
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            loginResponse failedResponse = new loginResponse();
            failedResponse.setMessage("Username and Password is not Exist!!");
            failedResponse.setStatus(403);
            failedResponse.setError("Invalid");
            return failedResponse;
        }

        return jwtUtil.generateToken(loginRequest.getUsername());

    }
}
