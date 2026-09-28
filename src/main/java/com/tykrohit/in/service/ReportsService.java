package com.tykrohit.in.service;

import java.io.ByteArrayInputStream;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.tykrohit.in.entity.CitizenPlan;
import com.tykrohit.in.request.SearchRequest;

import jakarta.servlet.http.HttpServletResponse;
@Component
public interface ReportsService {
	
	List<String>getCitizenPlanNames();
	
	List<String>getCitizenPlanStatus();
	
	List<Optional<CitizenPlan>>getAllCitizenPlanInfo(String planName,String planStatus,String citizenGender,LocalDate planStartDate,LocalDate planendDate);
	
	List<CitizenPlan> getAllPlansInfo();
	 
	ByteArrayInputStream  exportCitizenPlanInfoToExcel();

	ByteArrayInputStream exportCitizenPlanInfoToPdf();
	
	List<CitizenPlan> getAllPlansInfoWithSearch(SearchRequest request);
	
	boolean exportExcel(HttpServletResponse response) throws  Exception;
	
	boolean exportPdf(HttpServletResponse response) throws  Exception;
	

}
