package com.example.Employee_API.repository;

import com.example.Employee_API.entity.Slip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SlipRepository extends JpaRepository<Slip, Integer> {
    @Query("SELECT u FROM Slip AS u where u.id_emp=:id")
    public List<Slip> getSlipById(@Param("id") Integer id);
}
