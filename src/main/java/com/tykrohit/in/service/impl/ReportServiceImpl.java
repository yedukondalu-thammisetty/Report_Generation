package com.tykrohit.in.service.impl;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.openpdf.text.Document;
import org.openpdf.text.PageSize;
import org.openpdf.text.Paragraph;
import org.openpdf.text.pdf.PdfPTable;
import org.openpdf.text.pdf.PdfWriter;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.tykrohit.in.entity.CitizenPlan;
import com.tykrohit.in.repository.CitizenPlanRepository;
import com.tykrohit.in.request.SearchRequest;
import com.tykrohit.in.service.ReportsService;
import com.tykrohit.in.utils.ExcelGenerator;
import com.tykrohit.in.utils.MailUtils;
import com.tykrohit.in.utils.PdfGenearator;

import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ReportServiceImpl implements ReportsService{
	
	private CitizenPlanRepository citizenPlanRepository;
	
	private ExcelGenerator excelGenerator;
	
	private PdfGenearator pdfGenerator;
	
	private MailUtils mailUtils;

	@Override
	public List<String> getCitizenPlanNames() {
		return citizenPlanRepository.getPlanNames();
	}

	@Override
	public List<String> getCitizenPlanStatus() {
		return citizenPlanRepository.getCitizenPlanStatus();
	}

	@Override
	public List<Optional<CitizenPlan>> getAllCitizenPlanInfo(String planName, String planStatus, String citizenGender,
			LocalDate planStartDate, LocalDate planendDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CitizenPlan> getAllPlansInfo() {
		return citizenPlanRepository.findAll();
	}

	@Override
	public ByteArrayInputStream exportCitizenPlanInfoToExcel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ByteArrayInputStream exportCitizenPlanInfoToPdf() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CitizenPlan> getAllPlansInfoWithSearch(SearchRequest request) {
		CitizenPlan citizenPlan = new CitizenPlan();
//		BeanUtils.copyProperties(request, citizenPlan);// without data dont add or copy to entity
		
		if (request.getPlanName() != null && !"".equals(request.getPlanName())) {
			citizenPlan.setCitizenPlanName(request.getPlanName());

		}
		if (request.getPlanStatus() != null && !"".equals(request.getPlanStatus())) {
			citizenPlan.setCitizenPlanStatus(request.getPlanStatus());

		}
		if (request.getPlanStartDate() != null && !"".equals(request.getPlanStartDate())) {
			citizenPlan.setCitizenPlanStartDate(request.getPlanStartDate());

		}
		if (request.getPlanEndDate() != null && !"".equals(request.getPlanEndDate())) {
			citizenPlan.setCitizenPlanEndDate(request.getPlanEndDate());

		}
		if (request.getGender() != null && !"".equals(request.getGender())) {
			citizenPlan.setCitizenGender(request.getGender());
		}
		System.out.println(citizenPlan);
				return citizenPlanRepository.findAll(Example.of(citizenPlan));
	}

	@Override
	public boolean exportExcel(HttpServletResponse response) throws Exception {
		List<CitizenPlan> all = citizenPlanRepository.findAll();
		String subject = "Test Mail ";
		String body = "<h5> Testing Gmail Funationality </h5>";
		File file = new File("Plans-info.xls");
		excelGenerator.generate(response, all,file);
		mailUtils.sendMail(subject, body, "yedukondalu897811@gmail.com",file);
		file.delete();
		return true;
	}

	@Override
	public boolean exportPdf(HttpServletResponse response) throws Exception {

		List<CitizenPlan> all = citizenPlanRepository.findAll();
		File file = new File("Plans-info.pdf");

		pdfGenerator.generatePdf(response, all,file);
		String subject = "Test Mail ";
		String body = "<h1> Testing Gmail Funationality </h1>";
		mailUtils.sendMail(subject, body, "yedukondalu897811@gmail.com",file);
		file.delete();
		return true;
	}

}
