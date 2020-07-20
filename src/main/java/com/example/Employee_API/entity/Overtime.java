package com.example.Employee_API.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "overtime")
public class Overtime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 8)
    private int id_overtime;
    @Column(length = 32)
    private Date time_start;
    @Column(length = 32)
    private Date time_end;
    private String report_text;
    @Column(nullable = true)
    private Integer id_emp;
}
