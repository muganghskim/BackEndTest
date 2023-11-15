package com.backend.test.repository;

import com.backend.test.model.JobHistory;
import com.backend.test.model.JobHistoryId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobHistoryRepository extends JpaRepository<JobHistory, JobHistoryId> {
    List<JobHistory> findByIdEmployeesEmployeeId(int employeeId);
}
