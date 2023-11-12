package com.backend.test.model;

import javax.persistence.*;
@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private int departmentId;

    @Column(name = "department_name")
    private String departmentName;

    @ManyToOne
    @JoinColumn(name = "manager_id", nullable=false)
    private Employees manager;

    @ManyToOne
    @JoinColumn(name="location_id", nullable=false)
    private Location location;
}
