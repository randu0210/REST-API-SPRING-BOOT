package com.example.Employee_API.repository;

import com.example.Employee_API.entity.Employee;
import com.example.Employee_API.entity.Overtime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OvertimeRepository extends JpaRepository<Overtime, Integer> {
//    @Query("SELECT u FROM Overtime AS u")
//    public List<Overtime> getDataOvertime();

//    Overtime findByid_emp(int id_emp);

    @Query("SELECT u FROM Overtime AS u where u.id_emp=:id_emp")
    public List<Overtime> getDataOvertimeById(@Param("id_emp") int id_emp);
}
