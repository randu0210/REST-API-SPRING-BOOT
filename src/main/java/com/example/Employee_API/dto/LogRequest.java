package com.example.Employee_API.dto;

import com.example.Employee_API.entity.LogOvertime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogRequest {
    private LogOvertime logOvertime;

    public LogOvertime getLogOvertime() {
        return logOvertime;
    }
}
