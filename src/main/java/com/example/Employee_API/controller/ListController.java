package com.example.Employee_API.controller;

import com.example.Employee_API.dto.LogRequest;
import com.example.Employee_API.entity.LogOvertime;
import com.example.Employee_API.entity.Overtime;
import com.example.Employee_API.repository.LogRepository;
import com.example.Employee_API.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ListController {
    @Autowired
    private ListService service;
    @Autowired
    private LogRepository logRepository;

    @DeleteMapping("/delete/{id_overtime}")
    public String deleteOvertimeById(@PathVariable int id_overtime){
        return service.deleteList(id_overtime);
    }

    @PostMapping("/addList")
    public LogOvertime addList(@RequestBody LogRequest logRequest){
       return logRepository.save(logRequest.getLogOvertime());
    }
    @GetMapping("/getLogOvertime")
    public List<LogOvertime> findAllLog(){return service.getLogOvertime();}
}
