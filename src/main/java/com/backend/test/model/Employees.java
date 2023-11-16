package com.backend.test.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "employees")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "jobId", nullable=false)
    private Jobs jobs;

    @Column(name = "salary")
    private Integer salary;

    @Column(name = "commission_pct")
    private Integer commissionPct;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    @JsonBackReference
    private Employees manager;

    @OneToMany(mappedBy = "manager")
    @JsonManagedReference
    private List<Employees> subordinates;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "departmentId", nullable=false)
    private Department department;

}
