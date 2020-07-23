package com.example.Employee_API.repository;

import com.example.Employee_API.entity.LogOvertime;
import com.example.Employee_API.entity.Overtime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LogRepository extends JpaRepository<LogOvertime, Integer> {


    @Query("SELECT u FROM LogOvertime AS u where u.id_emp=:id_emp")
    public List<LogOvertime> getlogOvertimeById(@Param("id_emp") int id_emp);
}
