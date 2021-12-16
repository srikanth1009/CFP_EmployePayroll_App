package com.bridgelabz.employepayrollapp.services;

import java.util.List;

import com.bridgelabz.employepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employepayrollapp.model.EmployeePayrollData;

public interface IEmployeePayrollService {
	List<EmployeePayrollData> getEmployeePayrollData();
    EmployeePayrollData getEmployeePayrollDataById(int empId);
    EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO);
    EmployeePayrollData updateEmployeePayrollData(int empId,EmployeePayrollDTO empPayrollDTO);
    void deleteEmployeePayrollData(int empId);
	
}


