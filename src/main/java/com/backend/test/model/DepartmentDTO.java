package com.backend.test.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DepartmentDTO {
    private int departmentId;
    private String departmentName;
    private int managerId;
    private int locationId;

    // Department 엔티티를 DTO로 변환하는 생성자
    public DepartmentDTO(Department department) {
        this.departmentId = department.getDepartmentId();
        this.departmentName = department.getDepartmentName();
        this.managerId = department.getManager().getEmployeeId();
        this.locationId = department.getLocation().getLocationId();
    }
}