package com.example.Employee_API.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class DTOResponse {
    private int id_employee;
    private String name;
    private String username;
    private String password;
    private String ttl;
    private String position;
    private int salary;
    private int id_overtime;
    private Date time_start;
    private Date time_end;
    private String report_text;
//    private Integer id_goods;
//    private Integer sold_total;
//    private String name_goods;
//    private Integer stock_goods;
}
