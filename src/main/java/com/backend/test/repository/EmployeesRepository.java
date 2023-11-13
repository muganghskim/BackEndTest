package com.backend.test.repository;

import com.backend.test.model.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeesRepository extends JpaRepository<Employees, Integer> {
    List<Employees> findByDepartmentDepartmentId(int departmentId);
}
