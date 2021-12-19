package com.bridgelabz.employepayrollapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bridgelabz.employepayrollapp.model.EmployeePayrollData;

@Repository
public interface EmployeePayrollRepository extends JpaRepository <EmployeePayrollData, Integer > {
	 @Query(value = "select * from employeepayroll_db,employee_department where employee_id=id and department= :department", nativeQuery = true)
	    List<EmployeePayrollData> findEmployeesByDepartment(String department);
}