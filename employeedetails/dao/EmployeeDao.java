package com.employeedetails.employeedetails.dao;

import java.io.InputStream;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employeedetails.employeedetails.entities.Employees;
@Repository
public interface EmployeeDao extends JpaRepository<Employees,Long>{
	
	List<Employees> findByProduction(String production);
	List<Employees> findByPeopleManager(String peoplemanager);
	List<Employees> findByProjectCode(String projectcode);
	List<Employees> findByProjectName(String projectName);
	List<Employees> findByStartDate(LocalDate startDate);
	Employees findByName(String name);
	List<Employees> findByEndDate(LocalDate endDate);
	static List<Employees> convertExcelToListOfEmployees(InputStream inputStream) {
		// TODO Auto-generated method stub
		return null;
	}
	 
	
	
	
	
	
	

}
