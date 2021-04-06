package com.bridgelabz.employeepayrollapp.respository;

import java.util.List;

import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeePayrollRespository  extends JpaRepository<EmployeePayrollData, Integer>{
    @Query(value = "select * from employee_payroll, employee_department where employee_id = Id and departments = :departments",nativeQuery = true)
    List<EmployeePayrollData> findEmployeesByDepartment(String departments);
}

