package com.backend.test.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class EmployeesDTO {
    private int employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private LocalDate hireDate;
    private Integer salary;
    private Integer commissionPct;
    private Integer managerId;
    private List<Integer> subordinateIds;
    private String jobId;
    private int departmentId;

    public EmployeesDTO(Employees employee) {
        this.employeeId = employee.getEmployeeId();
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.email = employee.getEmail();
        this.phoneNumber = employee.getPhoneNumber();
        this.hireDate = employee.getHireDate();
        this.salary = employee.getSalary();
        this.commissionPct = employee.getCommissionPct();

        if (employee.getManager() != null) {
            this.managerId = employee.getManager().getEmployeeId();
        }

        if (employee.getSubordinates() != null) {
            this.subordinateIds = employee.getSubordinates().stream()
                    .map(Employees::getEmployeeId)
                    .collect(Collectors.toList());
        }

        this.jobId = employee.getJobs().getJobId();
        this.departmentId = employee.getDepartment().getDepartmentId();
    }
}
