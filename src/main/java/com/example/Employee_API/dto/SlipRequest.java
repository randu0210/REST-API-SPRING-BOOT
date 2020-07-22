package com.example.Employee_API.dto;

import com.example.Employee_API.entity.Slip;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SlipRequest {
    private Slip slip;

    public Slip getSlip() {
        return slip;
    }
}
