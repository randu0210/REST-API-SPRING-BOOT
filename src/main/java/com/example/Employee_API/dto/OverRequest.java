package com.example.Employee_API.dto;

import com.example.Employee_API.entity.Overtime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OverRequest {
    private Overtime overtime;

    public Overtime getOvertime() {
        return overtime;
    }
}
