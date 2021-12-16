package com.bridgelabz.employepayrollapp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.employepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employepayrollapp.repository.EmployeeRepository;

@Service
public class EmployeePayrollServices implements IEmployeePayrollService{

    @Autowired
    EmployeeRepository employeeRepository;
	private List<EmployeePayrollData> employeePayrollList = new ArrayList<>();
	


    

    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
        return employeePayrollList.get(empId-1);
    }

    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData empData = null;
        EmployeePayrollData employeePayrollData= new EmployeePayrollData();
        employeePayrollData.setEmployeeId(empPayrollDTO.getEmployeeId());
        employeePayrollData.setName(empPayrollDTO.getName());
        employeePayrollData.setSalary(empPayrollDTO.getSalary());
        employeePayrollList.add(employeePayrollData);
        employeeRepository.save(employeePayrollData);
        return employeePayrollData;
        
    }
    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
    	return employeePayrollList;
    }

    @Override
    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
        empData.setName(empPayrollDTO.name);
        empData.setSalary(empPayrollDTO.salary);
        employeePayrollList.set(empId-1, empData);
        return empData;
    }

    @Override
    public void deleteEmployeePayrollData(int empId) {
        employeePayrollList.remove(empId-1);

    }
}