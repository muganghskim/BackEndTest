package com.backend.test.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
public class JobHistoryId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employees employees;

    @Column(name = "start_date")
    private LocalDate startDate;

    // getters and setters...
}
