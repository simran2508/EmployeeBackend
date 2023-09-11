package com.employeedetails.employeedetails.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employees {
	
	@Id
	private Long localEmployeeId;
	private Long globalGroupId;
	private String name;
	private String localGrade;
	private String roleName;
	private String production;
	private String productionUnitName;
	private String localApprover;
	private String peopleManager;
	private String projectCode;
	private String projectName;
	private LocalDate startDate;
	private LocalDate endDate;
	public Employees(long localEmployeeId, long globalGroupId, String name, String localGrade, String roleName,
			String production, String productionUnitName, String localApprover, String peopleManager,
			String projectCode, String projectName, LocalDate startDate, LocalDate endDate) {
		super();
		this.localEmployeeId = localEmployeeId;
		this.globalGroupId = globalGroupId;
		this.name = name;
		this.localGrade = localGrade;
		this.roleName = roleName;
		this.production = production;
		this.productionUnitName = productionUnitName;
		this.localApprover = localApprover;
		this.peopleManager = peopleManager;
		this.projectCode = projectCode;
		this.projectName = projectName;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public Employees() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getLocalEmployeeId() {
		return localEmployeeId;
	}
	public void setLocalEmployeeId(long localEmployeeId) {
		this.localEmployeeId = localEmployeeId;
	}
	public long getGlobalGroupId() {
		return globalGroupId;
	}
	public void setGlobalGroupId(long globalGroupId) {
		this.globalGroupId = globalGroupId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocalGrade() {
		return localGrade;
	}
	public void setLocalGrade(String localGrade) {
		this.localGrade = localGrade;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getProduction() {
		return production;
	}
	public void setProduction(String production) {
		this.production = production;
	}
	public String getProductionUnitName() {
		return productionUnitName;
	}
	public void setProductionUnitName(String productionUnitName) {
		this.productionUnitName = productionUnitName;
	}
	public String getLocalApprover() {
		return localApprover;
	}
	public void setLocalApprover(String localApprover) {
		this.localApprover = localApprover;
	}
	public String getPeopleManager() {
		return peopleManager;
	}
	public void setPeopleManager(String peopleManager) {
		this.peopleManager = peopleManager;
	}
	public String getProjectCode() {
		return projectCode;
	}
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "Employees [localEmployeeId=" + localEmployeeId + ", globalGroupId=" + globalGroupId + ", name=" + name
				+ ", localGrade=" + localGrade + ", roleName=" + roleName + ", production=" + production
				+ ", productionUnitName=" + productionUnitName + ", localApprover=" + localApprover + ", peopleManager="
				+ peopleManager + ", projectCode=" + projectCode + ", projectName=" + projectName + ", startDate="
				+ startDate + ", endDate=" + endDate + "]";
	}
	
	
	
}