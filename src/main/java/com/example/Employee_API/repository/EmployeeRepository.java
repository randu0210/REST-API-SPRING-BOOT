package com.example.Employee_API.repository;

import com.example.Employee_API.dto.DTORequest;
import com.example.Employee_API.dto.DTOResponse;
import com.example.Employee_API.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query("SELECT new com.example.Employee_API.dto.DTOResponse(a.id_employee, a.name, a.username, a.password, a.position, a.ttl, a.salary, " +
            "b.id_overtime, b.time_start, b.time_end, b.report_text) " +
            "FROM Employee a JOIN a.overtime b ")
    public List<DTOResponse> getAllDataEmployee();
    Employee findByUsername(String username);

    @Query("SELECT u FROM Employee AS u")
    public List<Employee> getDataEmployee();

    @Query("SELECT u FROM Employee AS u where u.username=:username")
    public List<Employee> getDataEmployeeByName(@Param("username") String username);

}
