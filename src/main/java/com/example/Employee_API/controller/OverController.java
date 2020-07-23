package com.example.Employee_API.controller;

import com.example.Employee_API.dto.EmpRequest;
import com.example.Employee_API.dto.OverRequest;
import com.example.Employee_API.entity.Employee;
import com.example.Employee_API.entity.Overtime;
import com.example.Employee_API.repository.OvertimeRepository;
import com.example.Employee_API.service.OvertimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class OverController {
    @Autowired
    private OvertimeService service;
    @Autowired
    private OvertimeRepository overtimeRepository;


    @GetMapping("/getOvertime")
    public List<Overtime> findAllEmployee(){return service.getOvertime();}

    @GetMapping("/getDataOvertimeById/{id_emp}")
    private List<Overtime> getDataOvertimeById(@PathVariable int id_emp){ return overtimeRepository.getDataOvertimeById(id_emp); }

    @PostMapping("/addOvertime")
    public Overtime addOvertime(@RequestBody OverRequest overRequest){
        return overtimeRepository.save(overRequest.getOvertime());
    }
}
