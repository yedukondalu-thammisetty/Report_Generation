package com.tykrohit.in.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class CitizenPlan {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer citizenId;
	
	private String citizenName;
	
	private String citizenPlanName;
	
	private String citizenGender;
	
	private String citizenPlanStatus;
	
	private LocalDate citizenPlanStartDate;
	
	private LocalDate citizenPlanEndDate;
	
	private Double citizenBenefitAmount;
	
	private LocalDate citizenTerminatedDate;
	
	private String citizenDenailReason;
	
	private String citizenTerminationReson;
	
	

}
