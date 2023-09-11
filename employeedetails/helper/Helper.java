package com.employeedetails.employeedetails.helper;

import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.employeedetails.employeedetails.entities.Employees;

public class Helper {
	
	
	
	public static boolean checkExcelFormat(MultipartFile file) {
		
		String contentType = file.getContentType();
		 
		if(contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
		{
			return true;
		}else {
		return false;
	}

	
	
	}
	

	public static List<Employees> convertExcelToListOfEmployees(InputStream is) {
        List<Employees> list=new ArrayList<>();
		
		try {
			
			XSSFWorkbook workbook = new XSSFWorkbook(is);
			if(workbook == null) {System.out.print("workbook is Empty");}
			XSSFSheet sheet = workbook.getSheet("sheet1");
			
			int rowNumber =0;
			Iterator<Row> iterator = sheet.iterator();
			
			int i=0;
			while(iterator.hasNext()) {
				Row row =iterator.next();
				
				if(rowNumber==0) {rowNumber++;continue;}
				
				Iterator<Cell> cells =row.iterator();
				int cid=0;
				
				 Employees e= new Employees();
				
				while (cells.hasNext()){
					Cell cell = cells.next();
									

					switch (cid) {
					case 0:
						e.setLocalEmployeeId((long) cell.getNumericCellValue());
						break;
					case 1:
						e.setGlobalGroupId((long)cell.getNumericCellValue());
						break;
					case 2:
						e.setName(cell.getStringCellValue());
						break;
					case 3:
						e.setLocalGrade(cell.getStringCellValue());
						break;
					case 4:
						e.setLocalApprover(cell.getStringCellValue());
						break;
					case 5:
						e.setPeopleManager(cell.getStringCellValue());
						break;
					
					case 6:

						 try {

						e.setProjectCode(String.valueOf(cell.getStringCellValue()));

						}catch(Exception ee) {

						e.setProjectCode(String.valueOf(cell.getNumericCellValue()));

						}
						//e.setProjectCode((String)cell.getStringCellValue());
				        break;
					case 7:
						e.setProjectName((String)cell.getStringCellValue());
						break;
					case 8:
						e.setStartDate(cell.getLocalDateTimeCellValue().toLocalDate());
						break;
					case 9:
						e.setEndDate(cell.getLocalDateTimeCellValue().toLocalDate());
						break;
					case 10:
						e.setProductionUnitName(String.valueOf(cell.getStringCellValue()));
						break;
					case 11:
						e.setProduction(String.valueOf(cell.getStringCellValue()));
						break;
					case 12:
						e.setRoleName(String.valueOf(cell.getStringCellValue()));
						break;
						default:
							System.out.println("Unknown case");
							break;
					
					}
					
					cid++;
				}
				list.add(e);
				
				
				i++;
			}
				
		}catch (Exception e) {
			
			e.printStackTrace();
		}
		return list;
		
		
	}
	

	
}
