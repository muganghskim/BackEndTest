package com.backend.test.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "job_history")
public class JobHistory {

    @EmbeddedId
    private JobHistoryId id;

    @Column(name = "end_date")
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Jobs jobs;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    // getters and setters...
}

