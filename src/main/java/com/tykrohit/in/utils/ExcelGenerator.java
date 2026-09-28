package com.tykrohit.in.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Component;

import com.tykrohit.in.entity.CitizenPlan;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class ExcelGenerator {
	
	public void generate(HttpServletResponse response,List<CitizenPlan> plans,File file ) throws Exception{
		//HSSFWorkbook workbook = new XSSFWorkbook();
		 HSSFWorkbook workbook = new HSSFWorkbook();
		 HSSFSheet sheet = workbook.createSheet("Plans-Data");
		 HSSFRow row = sheet.createRow(0);
		 row.createCell(0).setCellValue("ID");
		 row.createCell(1).setCellValue("Citizen Name");
		 row.createCell(2).setCellValue("Citizen Plan Name");
		 row.createCell(3).setCellValue("Citizen Plan Status");
		 row.createCell(4).setCellValue("Citizen Plan Start Date");
		 row.createCell(5).setCellValue("Citizen Plan End Date");
		 row.createCell(6).setCellValue("Citizen Benefit Amount");
		 int sheetRow = 1;
		 for(CitizenPlan citizenPlan :plans) {
			 HSSFRow dataRow = sheet.createRow(sheetRow);
			 dataRow.createCell(0).setCellValue(citizenPlan.getCitizenId());
			 dataRow.createCell(1).setCellValue(citizenPlan.getCitizenName());
			 dataRow.createCell(2).setCellValue(citizenPlan.getCitizenPlanName());
			 dataRow.createCell(3).setCellValue(citizenPlan.getCitizenPlanStatus());
			 if(null !=citizenPlan.getCitizenPlanStartDate()) {
			  dataRow.createCell(4).setCellValue(citizenPlan.getCitizenPlanStartDate()+"");
			  
			 }else {
				 dataRow.createCell(4).setCellValue("N/A");
			 }
			 if(null !=citizenPlan.getCitizenPlanEndDate()) {
				  dataRow.createCell(5).setCellValue(citizenPlan.getCitizenPlanEndDate()+"");
				  
				 }else {
					 dataRow.createCell(5).setCellValue("N/A");
				 }
			 
//			 dataRow.createCell(5).setCellValue(citizenPlan.getCitizenPlanEndDate());
			 Double citizenBenefitAmount = citizenPlan.getCitizenBenefitAmount();
			 if(citizenBenefitAmount != null) {
				 dataRow.createCell(6).setCellValue(citizenPlan.getCitizenBenefitAmount());
			 }else {
				 dataRow.createCell(6).setCellValue(0);
			 }
			 sheetRow++;

		 }
		 FileOutputStream fileOutputStream = new FileOutputStream(file);
		 workbook.write(fileOutputStream);
		 fileOutputStream.close();
//		 workbook.close();  For Physical File to Store in Server
		 ServletOutputStream outputStream = response.getOutputStream();
		 workbook.write(outputStream);
		 workbook.close();
		
	}

}
