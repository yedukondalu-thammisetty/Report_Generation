package com.tykrohit.in.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.openpdf.text.Document;
import org.openpdf.text.PageSize;
import org.openpdf.text.Paragraph;
import org.openpdf.text.pdf.PdfPTable;
import org.openpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Component;

import com.tykrohit.in.entity.CitizenPlan;

import jakarta.servlet.http.HttpServletResponse;

@Component
public class PdfGenearator {
	
	public void generatePdf(HttpServletResponse response,List<CitizenPlan> plans,File file) throws  Exception{
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());
		PdfWriter.getInstance(document, new FileOutputStream(file));
		document.open();
		Paragraph paragraph = new Paragraph("Citizen Plan Info");
		paragraph.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(paragraph);
		
		PdfPTable pdfPTable = new PdfPTable(6);
		pdfPTable.setSpacingBefore(5);
		pdfPTable.addCell("Ciizen Id");
		pdfPTable.addCell("Ciizen Name");
		pdfPTable.addCell("Ciizen Plan Name");
		pdfPTable.addCell("Ciizen Plan Status");
		pdfPTable.addCell("Ciizen Plan Start Date");
		pdfPTable.addCell("Ciizen Plan End Date");
		for (CitizenPlan citizenPlan : plans) {
			pdfPTable.addCell(citizenPlan.getCitizenId().toString());
			pdfPTable.addCell(citizenPlan.getCitizenName());
			pdfPTable.addCell(citizenPlan.getCitizenPlanName());
			pdfPTable.addCell(citizenPlan.getCitizenPlanStatus());
			if (null != citizenPlan.getCitizenPlanStartDate()) {
				pdfPTable.addCell(citizenPlan.getCitizenPlanStartDate() + "");

			} else {
				pdfPTable.addCell("N/A");
			}
			if (null != citizenPlan.getCitizenPlanEndDate()) {
				pdfPTable.addCell(citizenPlan.getCitizenPlanEndDate() + "");

			} else {
				pdfPTable.addCell("N/A");
			}

		}
		
		document.add(pdfPTable);
		document.close();
		
	}

}
