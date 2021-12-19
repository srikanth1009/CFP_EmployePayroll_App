package com.bridgelabz.employepayrollapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.employepayrollapp.model.EmployeePayrollData;

@Repository
public interface EmployeePayrollRepository extends JpaRepository <EmployeePayrollData, Integer > {
}