package com.backend.test.controller;

import com.backend.test.model.JobHistory;
import com.backend.test.service.JobHistoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/jobHistory")
@Api(value = "JobHistory Controller", description = "특정 사원의 이력 정보 조회 API")
public class JobHistoryController {

    @Autowired
    private JobHistoryService jobHistoryService;

    @GetMapping("/employee/{employeeId}")
    @ApiOperation(value = "사원 이력 조회", notes = "특정 사원 id로 이력 정보를 조회합니다.")
    public ResponseEntity<List<JobHistory>> getJobHistory(@ApiParam(value = "조회하려는 특정 사원 ID", required = true) @PathVariable int employeeId) {
        List<JobHistory> jobHistory = jobHistoryService.getJobHistoryByEmployeeId(employeeId);
        if (jobHistory.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(jobHistory);
        }
    }
}