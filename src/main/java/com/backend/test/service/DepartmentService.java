package com.backend.test.service;

import com.backend.test.model.Department;
import com.backend.test.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Optional<Department> getDepartmentById(int id) {
        return departmentRepository.findById(id);
    }
}