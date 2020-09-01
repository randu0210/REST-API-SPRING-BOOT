package com.example.Employee_API.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Log_overtime")
public class LogOvertime implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 8)
    private int id_overtime;
    @Column
    private Date time_start;
    @Column
    private Date time_end;
    private String report_text;
    @Column(length = 32)
    private String position;
    @Column(length = 32)
    private String name;
    @Column(nullable = true)
    private Integer id_emp;
}
