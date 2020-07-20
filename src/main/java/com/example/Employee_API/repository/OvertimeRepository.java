package com.example.Employee_API.repository;

import com.example.Employee_API.entity.Overtime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OvertimeRepository extends JpaRepository<Overtime, Integer> {
    @Query("SELECT u FROM Overtime AS u")
    public List<Overtime> getDataOvertime();
}
