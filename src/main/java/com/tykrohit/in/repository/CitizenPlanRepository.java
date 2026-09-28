package com.tykrohit.in.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;

import com.tykrohit.in.entity.CitizenPlan;

public interface CitizenPlanRepository extends JpaRepository<CitizenPlan, Integer>{
	
	@NativeQuery( "select distinct(citizen_plan_name) from citizen_plan")
	List<String> getPlanNames();
	
	@NativeQuery("select distinct(citizen_plan_status) from citizen_plan")
	List<String>getPlanStatus();
	
	@Query("select distinct citizenPlanName from CitizenPlan")
	List<String>getPlanName();
	
	@Query("select distinct(citizenPlanStatus) from CitizenPlan")
	List<String>getCitizenPlanStatus();

}
