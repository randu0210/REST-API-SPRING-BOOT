package com.example.Employee_API.service;

import com.example.Employee_API.entity.LogOvertime;
import com.example.Employee_API.entity.Overtime;
import com.example.Employee_API.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListService {
    @Autowired
    private LogRepository logRepository;

    public String deleteList(int id_overtime){
        logRepository.deleteById(id_overtime);
        return "list remove";
    }
    public List<LogOvertime> getLogOvertime(){return logRepository.findAll();}
}
