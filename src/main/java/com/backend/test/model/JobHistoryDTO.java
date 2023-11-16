package com.backend.test.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Getter
@NoArgsConstructor
public class JobHistoryDTO {
    private LocalDate endDate;
    private String jobId;
    private int departmentId;

    // Todo : startDate 어떻게 하쥐?
    public JobHistoryDTO(JobHistory jobHistory) {
        this.endDate = jobHistory.getEndDate();
        this.jobId = jobHistory.getJobs().getJobId();
        this.departmentId = jobHistory.getDepartment().getDepartmentId();
    }

}

