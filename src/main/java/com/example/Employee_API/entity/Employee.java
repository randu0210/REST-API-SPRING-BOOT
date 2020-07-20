package com.example.Employee_API.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue
    @Column(nullable = false, length = 4)
    private int id_employee;
    @Column(length = 32)
    private String name;
    @Column(unique = true,length = 32)
    private String username;
    @Column(length = 32)
    private String password;
    @Column(length = 40)
    private String TTL;
    @Column(length = 32)
    private String position;
    @Column(length = 8)
    private int salary;

    @OneToMany(targetEntity = Overtime.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_emp", referencedColumnName = "id_employee")
    private List<Overtime> overtimes;

    @OneToMany(targetEntity = Slip.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_emp", referencedColumnName = "id_employee")
    private List<Slip> slips;
}
