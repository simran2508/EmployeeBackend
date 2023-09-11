package com.employeedetails.employeedetails.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.employeedetails.employeedetails.entities.Employees;
import com.employeedetails.employeedetails.myexceptions.MyExceptions;
 
public interface EmployeeServices {
	
	public List<Employees> getEmployees();
	public Employees getEmployee(long localemployeeid);
	public Employees getEmployee1(long globalgroupid);
	public Employees addEmployee(Employees employee);
	public Employees updateEmployee(Employees employee);
	public void deleteEmployee(long localemployeeid);
	public List<Employees> findEmployeesManager(String manager);
	public List<Employees> findProjectCode(String projectCode);
	public List<Employees> findProjectName(String projectName);
	public List<Employees> findStartDate(LocalDate startDate);
	
	public Page<Employees> getAllEmploye(Pageable pageable);
	
	public Employees getName(String name);
	public List<Employees> findProduction(String production);
	public List<Employees> findEndDate(LocalDate endDate);
	

}
