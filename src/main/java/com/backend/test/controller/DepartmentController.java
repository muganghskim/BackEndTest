package com.backend.test.controller;

import com.backend.test.model.Department;
import com.backend.test.model.DepartmentDTO;
import com.backend.test.service.DepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/departments")
@Api(value = "Department Controller", description = "부서 및 위치 정보 조회 관련된 API")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/{id}")
    @ApiOperation(value = "부서 및 위치 조회", notes = "특정 부서 및 위치 정보를 조회합니다.")
    public ResponseEntity<DepartmentDTO> getDepartment(@ApiParam(value = "조회하려는 특정 부서 ID", required = true) @PathVariable int id) {
        Optional<Department> department = departmentService.getDepartmentById(id);
        return department
                .map(dept -> new DepartmentDTO(dept))
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}