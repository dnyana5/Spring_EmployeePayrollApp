package com.bridgelabz.employeepayrollapp.services;

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
	

	public List<EmployeePayrollData> getEmployeePayrollData() {
		return employeeRespository.findAll();
	}


	public EmployeePayrollData getEmployeePayrollDataById(int empId) {
		  return employeeRespository
		  			.findById(empId)
					.orElseThrow(() -> new EmployeePayrollException("Employee with employeeId"
													 + empId + "does not exists..!!"));
	}

	
	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData employeePayrollData = null;
		employeePayrollData = new EmployeePayrollData(empPayrollDTO);
		log.debug("Emp Data: "+employeePayrollData.toString());
		return employeeRespository.save(employeePayrollData);
	}

	public EmployeePayrollData updateEmployeePayrollData(int empId, 
											EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData employeePayrollData = this.getEmployeePayrollDataById(empId);
		employeePayrollData.updateEmployeePayrollData(empPayrollDTO); 
		employeePayrollData.setSalary(empPayrollDTO.salary);
			return employeeRespository.save(employeePayrollData);
	}

	public void deleteEmployeePayrollData(int empId) {
		EmployeePayrollData employeePayrollData = this.getEmployeePayrollDataById(empId);
		employeeRespository.delete(employeePayrollData);
		
	}

}
