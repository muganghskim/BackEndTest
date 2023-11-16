package com.backend.test.repository;

import com.backend.test.model.JobHistory;
import com.backend.test.model.JobHistoryId;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JobHistoryRepository extends JpaRepository<JobHistory, JobHistoryId> {
    @Query("SELECT j FROM JobHistory j WHERE j.id.employees.employeeId = :employeeId")
    List<JobHistory> findByEmployeeId(@Param("employeeId") int employeeId);
}
