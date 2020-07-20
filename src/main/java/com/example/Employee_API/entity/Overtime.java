package com.example.Employee_API.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "overtime")
public class Overtime {
    @Id
    @GeneratedValue
    @Column(length = 8)
    private int id_overtime;
    @Column(length = 32)
    private String time_start;
    @Column(length = 32)
    private String time_end;
    private String report_text;
}
