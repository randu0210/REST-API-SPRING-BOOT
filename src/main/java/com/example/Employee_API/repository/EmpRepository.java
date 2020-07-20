package com.example.Employee_API.repository;

import com.example.Employee_API.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRepository extends JpaRepository<Employee, Integer> {
}
