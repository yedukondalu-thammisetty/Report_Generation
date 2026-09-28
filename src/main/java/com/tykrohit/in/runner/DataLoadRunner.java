package com.tykrohit.in.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.hibernate.annotations.Comment;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.tykrohit.in.entity.CitizenPlan;
import com.tykrohit.in.repository.CitizenPlanRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class DataLoadRunner implements ApplicationRunner {
	
	private CitizenPlanRepository citizenPlanRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		

//		 citizenPlanRepository.deleteAll();
		CitizenPlan citizenPlan =  new CitizenPlan();
		citizenPlan.setCitizenName("Rajesh");
		citizenPlan.setCitizenGender("Male");
		citizenPlan.setCitizenPlanName("Cash");
		citizenPlan.setCitizenPlanStartDate(LocalDate.now());
		citizenPlan.setCitizenPlanEndDate(LocalDate.now().plusMonths(6));
		citizenPlan.setCitizenPlanStatus("Approved");
		citizenPlan.setCitizenBenefitAmount(50000.00);
		
		CitizenPlan c2 =  new CitizenPlan();
		c2.setCitizenName("Ramu");
		c2.setCitizenGender("Male");
		c2.setCitizenPlanName("Cash");
//		c2.setCitizenPlanStartDate(LocalDate.now());
//		c2.setCitizenPlanEndDate(LocalDate.now().plusMonths(6));
		c2.setCitizenPlanStatus("Denied");
        c2.setCitizenDenailReason("Rent On mothly income is available");
        
        CitizenPlan c3 =  new CitizenPlan();
        c3.setCitizenName("Shushma");
        c3.setCitizenGender("FeMale");
        c3.setCitizenPlanName("Cash");
        c3.setCitizenPlanStartDate(LocalDate.now().minusMonths(4));
        c3.setCitizenPlanEndDate(LocalDate.now().plusMonths(6));
        c3.setCitizenPlanStatus("Terminated");
        c3.setCitizenBenefitAmount(50000.00);
        c3.setCitizenTerminatedDate(LocalDate.now());
        c3.setCitizenTerminationReson("Employed");
        
        CitizenPlan c4 =  new CitizenPlan();
        c4.setCitizenName("Rakesh");
        c4.setCitizenGender("Male");
        c4.setCitizenPlanName("Food");
        c4.setCitizenPlanStartDate(LocalDate.now());
        c4.setCitizenPlanEndDate(LocalDate.now().plusMonths(6));
        c4.setCitizenPlanStatus("Approved");
        c4.setCitizenBenefitAmount(5000.00);
		
		CitizenPlan c5 =  new CitizenPlan();
		c5.setCitizenName("Balaji");
		c5.setCitizenGender("Male");
		c5.setCitizenPlanName("Food");
//		c2.setCitizenPlanStartDate(LocalDate.now());
//		c2.setCitizenPlanEndDate(LocalDate.now().plusMonths(6));
		c5.setCitizenPlanStatus("Denied");
		c5.setCitizenDenailReason("Property Income");
        
        CitizenPlan c6 =  new CitizenPlan();
        c6.setCitizenName("Poojitha");
        c6.setCitizenGender("FeMale");
        c6.setCitizenPlanName("Food");
        c6.setCitizenPlanStartDate(LocalDate.now().minusMonths(4));
        c6.setCitizenPlanEndDate(LocalDate.now().plusMonths(6));
        c6.setCitizenPlanStatus("Terminated");
        c6.setCitizenBenefitAmount(50000.00);
        c6.setCitizenTerminatedDate(LocalDate.now());
        c6.setCitizenTerminationReson("Employed");
        
        CitizenPlan c7 =  new CitizenPlan();
        c7.setCitizenName("Robort");
        c7.setCitizenGender("Male");
        c7.setCitizenPlanName("Medical");
        c7.setCitizenPlanStartDate(LocalDate.now());
        c7.setCitizenPlanEndDate(LocalDate.now().plusMonths(6));
        c7.setCitizenPlanStatus("Approved");
        c7.setCitizenBenefitAmount(7899.00);
		
		CitizenPlan c8 =  new CitizenPlan();
		c8.setCitizenName("Nagesh");
		c8.setCitizenGender("Male");
		c8.setCitizenPlanName("Medical");
//		c2.setCitizenPlanStartDate(LocalDate.now());
//		c2.setCitizenPlanEndDate(LocalDate.now().plusMonths(6));
		c8.setCitizenPlanStatus("Denied");
		c8.setCitizenDenailReason("Property Income");
        
        CitizenPlan c9 =  new CitizenPlan();
        c9.setCitizenName("Archana");
        c9.setCitizenGender("FeMale");
        c9.setCitizenPlanName("Food");
        c9.setCitizenPlanStartDate(LocalDate.now().minusMonths(4));
        c9.setCitizenPlanEndDate(LocalDate.now().plusMonths(6));
        c9.setCitizenPlanStatus("Terminated");
        c9.setCitizenBenefitAmount(50000.00);
        c9.setCitizenTerminatedDate(LocalDate.now());
        c9.setCitizenTerminationReson("Government Job");
        
        CitizenPlan c10 =  new CitizenPlan();
        c10.setCitizenName("Ranjith");
        c10.setCitizenGender("Male");
        c10.setCitizenPlanName("Employment");
        c10.setCitizenPlanStartDate(LocalDate.now());
        c10.setCitizenPlanEndDate(LocalDate.now().plusMonths(6));
        c10.setCitizenPlanStatus("Approved");
        c10.setCitizenBenefitAmount(7999.00);
		
		CitizenPlan c11 =  new CitizenPlan();
		c11.setCitizenName("Kondaiah");
		c11.setCitizenGender("Male");
		c11.setCitizenPlanName("Employment");
//		c2.setCitizenPlanStartDate(LocalDate.now());
//		c2.setCitizenPlanEndDate(LocalDate.now().plusMonths(6));
		c11.setCitizenPlanStatus("Denied");
		c11.setCitizenDenailReason("Property Income");
        
        CitizenPlan c12 =  new CitizenPlan();
        c12.setCitizenName("Varsha");
        c12.setCitizenGender("FeMale");
        c12.setCitizenPlanName("Employment");
        c12.setCitizenPlanStartDate(LocalDate.now().minusMonths(4));
        c12.setCitizenPlanEndDate(LocalDate.now().plusMonths(6));
        c12.setCitizenPlanStatus("Terminated");
        c12.setCitizenBenefitAmount(50000.00);
        c12.setCitizenTerminatedDate(LocalDate.now());
        c12.setCitizenTerminationReson("Government Job");
        List<CitizenPlan> asList = Arrays.asList(citizenPlan,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12);
//        citizenPlanRepository.saveAll(asList);
}

}
