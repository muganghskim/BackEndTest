package com.backend.test.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "employees")
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private int employeeId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "hire_date")
    private LocalDate hireDate;

    @ManyToOne
    @JoinColumn(name = "job_id", nullable=false)
    private Jobs jobs;

    @Column(name = "salary")
    private Integer salary;

    @Column(name = "commission_pct")
    private Integer commission_pct;

    @ManyToOne
    @JoinColumn(name = "manager_id", nullable=false)
    private Employees manager;

    @OneToMany(mappedBy = "manager")
    private List<Employees> subordinates;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable=false)
    private Department department;

}
