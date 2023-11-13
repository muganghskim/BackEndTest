package com.backend.test.service;

import com.backend.test.model.Employees;
import com.backend.test.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeesService {
    @Autowired
    private EmployeesRepository employeesRepository;

    public Optional<Employees> getEmployeeById(int id) {
        return employeesRepository.findById(id);
    }

    public void increaseSalary(int departmentId, double percentage) {
        List<Employees> employees = employeesRepository.findByDepartmentDepartmentId(departmentId);
        for (Employees employee : employees) {
            int newSalary = (int) (employee.getSalary() * (1 + percentage / 100));
            employee.setSalary(newSalary);
            employeesRepository.save(employee);
        }
    }
}
