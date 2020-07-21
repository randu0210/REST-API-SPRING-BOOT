package com.example.Employee_API.controller;

import com.example.Employee_API.dto.EmpRequest;
import com.example.Employee_API.dto.loginRequest;
import com.example.Employee_API.dto.loginResponse;
import com.example.Employee_API.entity.Employee;
import com.example.Employee_API.repository.EmpRepository;
import com.example.Employee_API.service.EmpService;
import com.example.Employee_API.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class EmpController {
    @Autowired
    private EmpService empService;
    @Autowired
    private EmpRepository empRepository;
    @Autowired
    private JWTUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody EmpRequest empRequest){
            return empRepository.save(empRequest.getEmployee());
    }
    @GetMapping("/getEmployee")
    public List<Employee> findAllEmployee(){return empService.getEmployee();}
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
