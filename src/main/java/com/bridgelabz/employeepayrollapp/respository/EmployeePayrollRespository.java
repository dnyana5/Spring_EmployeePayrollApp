package com.bridgelabz.employeepayrollapp.respository;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeePayrollRespository  extends JpaRepository<EmployeePayrollData, Integer>{
}
