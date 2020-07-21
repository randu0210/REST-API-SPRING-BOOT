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

    @GetMapping("/getDataEmployeeByName/{username}")
    private List<Employee> getDataEmployeeByName(@PathVariable String username){ return empRepository.getDataEmployeeByName(username); }

    @GetMapping("/getEmployeeByPosition/{position}")
    private List<Employee> getEmployeeByPosition(@PathVariable String position){return empRepository.getDataEmployeeByPosition(position);}

    @DeleteMapping("/delete/{id_employee}")
    public String deleteEmployeeById(@PathVariable int id_employee){
        return empService.deleteEmployee(id_employee);
    }

    @GetMapping("/getEmployee")
    public List<Employee> findAllEmployee(){return empService.getEmployee();}

    @GetMapping("/getEmployeeById/{id}")
    public Employee findEmployeeById(@PathVariable int id){ return empService.getEmployeeById(id); }

    @PutMapping("/updateEmployee")
    public  Employee updateEmployee(@RequestBody  Employee  employee){
        return empService.updateEmployee(employee);
    }

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
