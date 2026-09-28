package com.tykrohit.in.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tykrohit.in.entity.CitizenPlan;
import com.tykrohit.in.request.SearchRequest;
import com.tykrohit.in.service.ReportsService;

import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class ReportController {
	
	private ReportsService reportsService;
	
	
	@GetMapping("/")
	public String getIndex(Model modal) {
		init(modal);
		List<CitizenPlan> allPlansInfoWithSearch = reportsService.getAllPlansInfo();
		modal.addAttribute("search", new SearchRequest());
		modal.addAttribute("plans",allPlansInfoWithSearch );		
		
		return "index";
	}

	private void init(Model modal ) {
		modal.addAttribute("planStatuses", reportsService.getCitizenPlanStatus());
		modal.addAttribute("planNames", reportsService.getCitizenPlanNames());
	}
	
	@PostMapping("/search")
	public String handleSearchResult(@ModelAttribute("search") SearchRequest request, Model modal) {
		System.out.println(request);
		init(modal);
		modal.addAttribute("plans", reportsService.getAllPlansInfoWithSearch(request));
        modal.addAttribute("search", request);
		return "index";
	}
	
	@GetMapping("/excel")
	public String excelExport(HttpServletResponse httpServletResponse,Model model) throws Exception {
		httpServletResponse.setContentType("application/octet-stream");
		httpServletResponse.setHeader("Content-Disposition", "attachment;filename=plans.xls;");
		boolean exportExcel = reportsService.exportExcel(httpServletResponse);
		if(exportExcel) {
			model.addAttribute("msg"," Excel  Report Sent To Mail");
		}
		init(model);
		return "index";
	}
	@GetMapping("/pdf")
	public String excelPdf(HttpServletResponse httpServletResponse,Model model) throws Exception {
		httpServletResponse.setContentType("application/pdf");
		httpServletResponse.setHeader("Content-Disposition", "attachment;filename=plans.pdf;");
		boolean exportPdf = reportsService.exportPdf(httpServletResponse);
		if(exportPdf) {
			model.addAttribute("msg","PDF Report Sent To Mail");
		}
		init(model);
		return "index";
		
		
	}

//	@PostMapping("/send-mail")
//	public void sendMail() {
//		
//	}
}
