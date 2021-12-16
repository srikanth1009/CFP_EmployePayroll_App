package com.bridgelabz.employepayrollapp.model;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.bridgelabz.employepayrollapp.dto.EmployeePayrollDTO;
@Entity
@Table(name = "employee")
public class EmployeePayrollData {
    @Id
    @Column(name = "employeeId")
	private int employeeId;
    
    @Column(name = "name")
    private String name;
    @Column(name = "salary")
    private long salary;

    public EmployeePayrollData() {}

    public EmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO) {
        this.employeeId = empId;
        this.name= empPayrollDTO.name;
        this.salary = empPayrollDTO.salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public long getSalary() {
        return salary;
    }
    public void setSalary(long salary) {
        this.salary = salary;
    }
}