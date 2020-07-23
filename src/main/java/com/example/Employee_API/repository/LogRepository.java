package com.example.Employee_API.repository;

import com.example.Employee_API.entity.LogOvertime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<LogOvertime, Integer> {
}
