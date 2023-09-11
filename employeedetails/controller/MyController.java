package com.employeedetails.employeedetails.controller;

 
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.employeedetails.employeedetails.entities.Employees;

import com.employeedetails.employeedetails.helper.Helper;
import com.employeedetails.employeedetails.myexceptions.MyExceptions;
//import com.employeedetails.employeedetails.helper.EmployeeHelper;
import com.employeedetails.employeedetails.services.EmployeeServiceImpl;


@RestController
@CrossOrigin(origins="http://localhost:3000")

//@RequestMapping("/search/*")
public class MyController {

	@Autowired
	private EmployeeServiceImpl employeeService;

	@GetMapping("/employe")
	public Page<Employees> getEmploye(
			@RequestParam(defaultValue="0")int page,
			@RequestParam(defaultValue="5")int size) {
		Pageable pageable= PageRequest.of(page, size);
		
		return this.employeeService.getAllEmploye(pageable);
	}
	
	@GetMapping("/employees")
	public List<Employees> getEmployees(){
		
		return this.employeeService.getEmployees();

	}

	

	@GetMapping("/employee1/{localemployeeid}")
	public Employees getEmploye(@PathVariable long localemployeeid) {
		return this.employeeService.getEmployee(localemployeeid);
	}

	@GetMapping("/employee2/{globalgroupid}")
	public Employees getEmploye1(@PathVariable long globalgroupid) {
		return this.employeeService.getEmployee1(globalgroupid);
	}

	@PostMapping("/employees")
	public Employees addEmployee(@RequestBody Employees employee) {
		return this.employeeService.addEmployee(employee);

	}

	@PutMapping("/employees")
	public Employees updateEmployee(@RequestBody Employees employee) {
		return this.employeeService.updateEmployee(employee);

	}

	@DeleteMapping("/employees/{localemployeeid}")
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long localemployeeid) {
		try {
			this.employeeService.deleteEmployee(localemployeeid);
			return new ResponseEntity<>(HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/managers/{peoplemanager}")
	public List<Employees> searchManager(@PathVariable String peoplemanager) {
		return this.employeeService.findEmployeesManager(peoplemanager);
	}
	
	@GetMapping("/projectcode/{projectcode}")
	public List<Employees> searchprojectCode(@PathVariable String projectcode ){
		
		return this.employeeService.findProjectCode(projectcode);
		
		
		
	}
	
	@GetMapping("/projectname/{projectName}")
	public List<Employees> searchprojectName(@PathVariable String projectName){
		return this.employeeService.findProjectName(projectName);
		
	}
	
	@GetMapping("/startdate/{startDate}")
	public List<Employees> searchstartDate(@PathVariable LocalDate startDate){
		return this.employeeService.findStartDate(startDate);
		
	}
	
	@GetMapping("/enddate/{endDate}")
	public List<Employees> searchendDate(@PathVariable LocalDate endDate){
		return this.employeeService.findEndDate(endDate);
	}
	
	@GetMapping("/name/{name}")
	public Employees getName(@PathVariable String name){
		return this.employeeService.getName(name);
		
	}
	
	@GetMapping("/production/{production}")
	public List <Employees> searchproduction(@PathVariable String production){
		return this.employeeService.findProduction(production);
	}
	
	
	@PostMapping("/employees/upload")
	public ResponseEntity<?> 
	upload(@RequestParam("file")MultipartFile file) {
		if(Helper.checkExcelFormat(file)) {
			this.employeeService.save(file);
			
			return ResponseEntity.status(HttpStatus.OK).body("file uploaded");
			
		}
		
		return ResponseEntity.status
				(HttpStatus.BAD_REQUEST).body("upload excel file only");
		
	}
	
	
		
	
	
	

	
}
	


	
	

