package com.nt.service;

import java.util.List;
import java.util.Map;

import com.nt.entity.TravelPlan;

public interface ITravelPlanService {
	
	public String registerTravelPlan(TravelPlan plan);
	
	public List<TravelPlan> showAllPlans();
	
	public Map<Integer, String> getPlanCategory();
	
	public String updateTravelPlan(TravelPlan plan);
	
	public String deletePlan(Integer id);	// for Hard Deletion
	
	public String changeTravelPlanId(Integer id, String plan); 
	
	public TravelPlan getPlanById(Integer id);
}
