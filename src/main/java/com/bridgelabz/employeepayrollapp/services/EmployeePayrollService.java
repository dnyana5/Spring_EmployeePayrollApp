package com.bridgelabz.employeepayrollapp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.exceptions.EmployeePayrollException;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {
	
	private List<EmployeePayrollData> employeePayrollList = new ArrayList<>(); 


	public List<EmployeePayrollData> getEmployeePayrollData() {
		return employeePayrollList;
	}


	public EmployeePayrollData getEmployeePayrollDataById(int empId) {
		  return employeePayrollList.stream()
		  			.filter(empData -> empData.getEmployeeId() == empId)
					.findFirst()
					.orElseThrow(() -> new EmployeePayrollException("Employee Not Found"));
	}

	
	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData employeePayrollData = null;
		employeePayrollData = new EmployeePayrollData(employeePayrollList.size()+1, empPayrollDTO);
		employeePayrollList.add(employeePayrollData);
		return employeePayrollData;
	}

	public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData employeePayrollData = this.getEmployeePayrollDataById(empId);
		employeePayrollData.setName(empPayrollDTO.name); 
		employeePayrollData.setSalary(empPayrollDTO.salary);
		employeePayrollList.set(empId-1, employeePayrollData);
		return employeePayrollData;
	}

	public void deleteEmployeePayrollData(int empId) {
		employeePayrollList.remove(empId-1);
		
	}

}
