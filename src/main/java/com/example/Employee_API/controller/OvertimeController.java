package com.example.Employee_API.controller;

import com.example.Employee_API.entity.Overtime;
import com.example.Employee_API.repository.OvertimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class OvertimeController {
    @Autowired
    private OvertimeRepository overtime;

    @GetMapping("/getDataOvertime")
    private List<Overtime> getDataOvertime(){
        return overtime.getDataOvertime();
    }

}
