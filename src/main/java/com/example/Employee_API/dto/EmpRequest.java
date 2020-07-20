package com.example.Employee_API.dto;

import com.example.Employee_API.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpRequest {
    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }
}
