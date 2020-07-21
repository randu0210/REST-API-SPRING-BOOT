package com.example.Employee_API.service;

import com.example.Employee_API.entity.Employee;
import com.example.Employee_API.entity.Overtime;
import com.example.Employee_API.repository.OvertimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OvertimeService {
    @Autowired
    private OvertimeRepository overtimeRepository;

    public List<Overtime> getOvertime(){return overtimeRepository.findAll();}
}
