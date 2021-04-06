package com.bridgelabz.employeepayrollapp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.exceptions.EmployeePayrollException;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.respository.EmployeePayrollRespository;


@Service
@Slf4j
public class EmployeePayrollService implements IEmployeePayrollService {
	@Autowired
	private EmployeePayrollRespository employeeRespository;
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
		employeePayrollData = new EmployeePayrollData(empPayrollDTO);
		employeePayrollList.add(employeePayrollData);
		log.debug("Emp Data: "+employeePayrollData.toString());
		return employeeRespository.save(employeePayrollData);
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
