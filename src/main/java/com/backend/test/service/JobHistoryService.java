package com.backend.test.service;

import com.backend.test.model.JobHistory;
import com.backend.test.repository.JobHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobHistoryService {

    @Autowired
    private JobHistoryRepository jobHistoryRepository;

    public List<JobHistory> getJobHistoryByEmployeeId(int employeeId) {
        return jobHistoryRepository.findByIdEmployeesEmployeesId(employeeId);
    }
}
