package com.example.Employee_API.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, length = 4)
    private int id_employee;
    @Column(length = 32)
    private String name;
    @Column(unique = true,length = 32)
    private String username;
    @Column(length = 32)
    private String password;
    @Column(length = 40)
    private String ttl;
    @Column(length = 32)
    private String position;
    @Column(length = 8)
    private int salary;
    @Column(length = 40)
    private String join_At;

    @OneToMany(targetEntity = Overtime.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_emp", referencedColumnName = "id_employee")
    private List<Overtime> overtime;

    @OneToMany(targetEntity = Slip.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_emp", referencedColumnName = "id_employee")
    private List<Slip> slip;

    public int getId_employee() {
        return id_employee;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPosition() {
        return position;
    }

    public int getSalary() {
        return salary;
    }

    public String getTtl() {
        return ttl;
    }

    public String getJoin_At() {
        return join_At;
    }

    public void setId_employee(int id_employee) {
        this.id_employee = id_employee;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setTtl(String ttl) {
        this.ttl = ttl;
    }

    public void setJoin_At(String join_At) {
        this.join_At = join_At;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public List<Overtime> getOvertime() {
        return overtime;
    }

    public List<Slip> getSlip() {
        return slip;
    }
}
