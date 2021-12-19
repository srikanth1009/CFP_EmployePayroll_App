package com.bridgelabz.employepayrollapp.services;

import com.bridgelabz.employepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employepayrollapp.exceptions.EmployeePayrollException;
import com.bridgelabz.employepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employepayrollapp.repository.EmployeePayrollRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@Slf4j
public class EmployeePayrollServices implements IEmployeePayrollService {

    @Autowired
    private EmployeePayrollRepository employeePayrollRepository;


    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {

        return employeePayrollRepository.findAll();
    }

    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
        return employeePayrollRepository.findById(empId)
                .orElseThrow(() -> new EmployeePayrollException("Employee with EmployeeId" + empId
                        + " Doesn't Exists...!"));

    }

    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData(empPayrollDTO);
        log.debug("Employee Data: " + empData.toString());
        return employeePayrollRepository.save(empData);
    }

    @Override
    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
        empData.updateEmployeePayollData(empPayrollDTO);
        return employeePayrollRepository.save(empData);
    }

    @Override
    public void deleteEmployeePayrollData(int empId) {
        EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
        employeePayrollRepository.delete(empData);

    }
    @Override
    public List<EmployeePayrollData> getEmployeesPayrollDataByDepartment(String department) {
        return employeePayrollRepository.findEmployeesByDepartment(department);
    }
}