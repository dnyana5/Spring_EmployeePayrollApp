package com.bridgelabz.employeepayrollapp.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.ToString;

public @ToString class EmployeePayrollDTO {
	@NotEmpty(message = "Employee name cannot be null")
	public String name;

	@Min(value = 500, message = "Minimum Wage should be more than 500")
	public long salary;

	public String gender;

	@JsonFormat(pattern = "dd MMM yyyy")
	public LocalDate startDate;
	public String note;
	public String profilePic;
	public List<String> departments;
	}


