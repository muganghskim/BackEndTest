package com.backend.test.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
public class JobHistoryId implements Serializable {
    @MapsId("employeeId")
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employees employees;

    @Column(name = "start_date")
    private LocalDate startDate;

}
