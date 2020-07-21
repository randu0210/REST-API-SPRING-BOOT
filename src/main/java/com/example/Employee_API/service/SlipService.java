package com.example.Employee_API.service;

import com.example.Employee_API.entity.Slip;
import com.example.Employee_API.repository.EmpRepository;
import com.example.Employee_API.repository.SlipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
public class SlipService {
    @Autowired
    private SlipRepository slip;
    private EntityManager em;
    private EmpRepository employee;

    public Slip addSlip(Slip h) {
        return slip.save(h);
    }
}
