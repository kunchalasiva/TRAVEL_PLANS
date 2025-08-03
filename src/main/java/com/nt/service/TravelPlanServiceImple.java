package com.nt.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.config.ApplicationProperties;
import com.nt.constants.AppConstants;
import com.nt.entity.PlanCategory;
import com.nt.entity.TravelPlan;
import com.nt.repository.IPlanCategoryRepository;
import com.nt.repository.ITravelPlanRepository;

@Service
public class TravelPlanServiceImple implements ITravelPlanService {

	@Autowired
	private ITravelPlanRepository planRepo;
	
	@Autowired
	private IPlanCategoryRepository planCateRepo;
	
	private Map<String,String> messages;
	
	
	@Autowired
	public TravelPlanServiceImple(ApplicationProperties props) {
		messages = props.getMessages();
	}

	@Override
	public String registerTravelPlan(TravelPlan plan) {
		// save the object

		TravelPlan entity = planRepo.save(plan);
		return entity.getPlanId() !=null? messages.get(AppConstants.SAVE_SUCCESS) + entity.getPlanId():messages.get(AppConstants.SAVE_FAILURE);
	}

	@Override
	public List<TravelPlan> showAllPlans() {
		return planRepo.findAll();
	}

	@Override
	public Map<Integer, String> getPlanCategory() {
		 List<PlanCategory> all = planCateRepo.findAll();
		Map<Integer, String> map = new HashMap<>();
		all.forEach(e -> {
			map.put(e.getPlanId(), e.getPlanCategoryName());
		});
		return map;
	}

	@Override
	public String updateTravelPlan(TravelPlan plan) {
		Optional<TravelPlan> opt = planRepo.findById(plan.getPlanId());
		if(opt.isPresent()) {
			planRepo.save(plan);
		return plan.getPlanId() + messages.get(AppConstants.UPDATE_SUCCESS);	
		}else {
			return plan.getPlanId() + messages.get(AppConstants.UPDATE_FAILURE);	
		}
	}

	@Override
	public String deletePlan(Integer id) {
		
		Optional<TravelPlan> opt = planRepo.findById(id);
		if(opt.isPresent()) {
			planRepo.deleteById(id);
		return( id + messages.get(AppConstants.DELETE_SUCCESS));	
		}else {
			return(id + messages.get(AppConstants.DELETE_FAILURE));	
		}
	}

	@Override
	public String changeTravelPlanId(Integer id, String status) {
		Optional<TravelPlan> optional = planRepo.findById(id);
		if(optional.isPresent()) {
			TravelPlan travelPlan = optional.get();
			travelPlan.setActiveSW(status);
			planRepo.save(travelPlan);
			return(id + messages.get(AppConstants.PLAN_STATUS_SUCCESS));
		}
		return id + messages.get(AppConstants.PLAN_STATUS_FAILURE) ;
	}

	@Override
	public TravelPlan getPlanById(Integer id) {
		return planRepo.findById(id).orElseThrow(() -> new IllegalArgumentException(id + messages.get(AppConstants.FIND_BY_ID_FAILURE)));
	}

}
