package com.bridgelabz.employepayrollapp.model;
import com.bridgelabz.employepayrollapp.dto.EmployeePayrollDTO;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "employeepayroll_db")
@Data
public class EmployeePayrollData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    private int employeeId;
    @Column(name = "name")
    private String name;

    private long salary;

    private String gender;

    private LocalDate startDate;

    private String note;

    private String profilePic;

    @ElementCollection
    @CollectionTable(name = "employee_department",
            joinColumns = @JoinColumn(name ="id"))
    @Column(name = "department")
    private List<String> departments;

    public EmployeePayrollData() {
    }
    public EmployeePayrollData(EmployeePayrollDTO employeePayrollDTO){
        this.updateEmployeePayollData(employeePayrollDTO);
    }

    public void updateEmployeePayollData( EmployeePayrollDTO employeePayrollDTO) {
        this.name = employeePayrollDTO.name;
        this.salary = employeePayrollDTO.salary;
        this.gender = employeePayrollDTO.gender;
        this.note = employeePayrollDTO.note;
        this.startDate = employeePayrollDTO.startDate;
        this.profilePic = employeePayrollDTO.profilePic;
        this.departments = employeePayrollDTO.departments;

    }
}