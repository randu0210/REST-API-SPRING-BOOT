package com.example.Employee_API.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "slip")
public class Slip {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 4)
    private int id_slip;
    @Column(length = 32)
    private String name;
    @Column(length = 32)
    private String position;
    @Column(length = 8)
    private int salary_over;
    @Column(length = 8)
    private int salary_final;
    @Column(nullable = true)
    private Integer id_emp;
}
