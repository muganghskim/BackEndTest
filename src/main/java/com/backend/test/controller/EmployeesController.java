package com.backend.test.controller;

import com.backend.test.model.Employees;
import com.backend.test.model.EmployeesDTO;
import com.backend.test.service.EmployeesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@Slf4j
@RestController
@RequestMapping("/api/employee")
@Api(value = "Employees Controller", description = "특정 사원들과 관련된 API")
public class EmployeesController {
    @Autowired
    private EmployeesService employeesService;

    @GetMapping("/{id}")
    @ApiOperation(value = "사원 현재 조회", notes = "특정 사원 id로 현재 정보를 조회합니다.")
    public ResponseEntity<EmployeesDTO> getEmployee(@ApiParam(value = "조회하려는 특정 사원 ID", required = true) @PathVariable int id) {
        try {
            Optional<Employees> employee = employeesService.getEmployeeById(id);
            if (employee.isPresent()) {
                EmployeesDTO employeeDTO = new EmployeesDTO(employee.get());
                return ResponseEntity.ok(employeeDTO);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            // 로그에 에러 기록
            log.error("사원 조회 컨트롤러 에러 발생", e);

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/increaseSalary/{departmentId}/{percentage}")
    @ApiOperation(value = "특정 부서 사원 임금 인상", notes = "특정 부서 사원의 임금을 특정 비율로 인상합니다.")
    public ResponseEntity<Void> increaseSalary(@ApiParam(value = "인상하려는 특정 부서 ID", required = true) @PathVariable int departmentId,
                                               @ApiParam(value = "인상하려는 특정 비율", required = true) @PathVariable double percentage) {
        employeesService.increaseSalary(departmentId, percentage);
        return ResponseEntity.ok().build();
    }
}
