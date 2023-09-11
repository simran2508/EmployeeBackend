package com.employeedetails.employeedetails.services;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.employeedetails.employeedetails.dao.EmployeeDao;
import com.employeedetails.employeedetails.entities.Employees;
import com.employeedetails.employeedetails.helper.Helper;

@Service
public class EmployeeServiceImpl implements EmployeeServices {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	

	@Override
	public List<Employees> getEmployees() {
		//List<Employees> e = employeeDao.findAll();
		//return e;
		return employeeDao.findAll();
	}



	@Override
	public Employees getEmployee(long localemployeeid) {
		return employeeDao.findById(localemployeeid).orElse(null);
		
	}


	@Override
	public Employees getEmployee1(long globalgroupid) {
		return employeeDao.findById(globalgroupid).orElse(null);
		
		
	}


	@Override
	public Employees addEmployee(Employees employee) {
		employeeDao.save(employee);
		return employee;
	}


	@Override
	public Employees updateEmployee(Employees employee) {
		employeeDao.save(employee);
		return employee;
	}


	@Override
	public void deleteEmployee(long localemployeeid) {
		Employees entity = employeeDao.findById(localemployeeid).orElse(null);
		if (entity != null)
			employeeDao.delete(entity);
		
	}
	
	@Override
	public List<Employees> findEmployeesManager(String peoplemanager) {
		return employeeDao.findByPeopleManager(peoplemanager);
		
	}


	@Override
	public List<Employees> findProjectCode(String projectCode) {
		return employeeDao.findByProjectCode(projectCode);
	}

    @Override
	public List<Employees> findProjectName(String projectName) {
		return employeeDao.findByProjectName(projectName);
	}

    @Override
	public List<Employees> findStartDate(LocalDate startDate) {
		return employeeDao.findByStartDate(startDate);
	}
    
    



	@Override
	public Page<Employees> getAllEmploye(Pageable pageable) {
		return employeeDao.findAll(pageable);
	}


    @Override
	public Employees getName(String name) {
		return employeeDao.findByName(name);
	}


    @Override
	public List<Employees> findProduction(String production) {
	   return employeeDao.findByProduction(production);
	   
	}



	@Override
	public List<Employees> findEndDate(LocalDate endDate) {
		return employeeDao.findByEndDate(endDate);
	}



	



	public void save(MultipartFile file) {
		try{
    		List<Employees> employees = Helper.convertExcelToListOfEmployees(file.getInputStream());
    		this.employeeDao.saveAll(employees);
    	}catch (IOException e) {
    		e.printStackTrace();
    		
    	}
	
		
	}



//	public void save(MultipartFile file) {
//		// TODO Auto-generated method stub
//    	try{
//		List<Employees> employees = EmployeeDao.convertExcelToListOfEmployees(file.getInputStream());
//		this.employeeDao.saveAll(employees);
//	}catch (IOException e) {
//		e.printStackTrace();
//		
//	}




}




	

	


	


	





