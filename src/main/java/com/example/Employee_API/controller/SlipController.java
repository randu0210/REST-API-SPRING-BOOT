package com.example.Employee_API.controller;

import com.example.Employee_API.dto.OverRequest;
import com.example.Employee_API.dto.SlipRequest;
import com.example.Employee_API.entity.Overtime;
import com.example.Employee_API.entity.Slip;
import com.example.Employee_API.repository.SlipRepository;
import com.example.Employee_API.service.SlipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class SlipController {
    @Autowired
    private SlipService service;
    @Autowired
    private SlipRepository history;

//    @PostMapping("/addHistory")
//    public Slip addSlip(@RequestBody Slip h) {
//        return service.addSlip(h);
//    }

    @GetMapping("/getSlipById/{id}")
    public List<Slip> getSlipById(@PathVariable Integer id) {
        return history.getSlipById(id);
    }

    @PostMapping("/addSlip")
    public Slip addSlip(@RequestBody SlipRequest slipRequest){
        return history.save(slipRequest.getSlip());
    }
}
