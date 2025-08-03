package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import com.nt.entity.TravelPlan;
import com.nt.service.ITravelPlanService;

@RestController
@RequestMapping("travel/api")
public class TravelPlanController {

	@Autowired
	private ITravelPlanService service;
	
	@PostMapping("/register")
	public ResponseEntity<String> registerPlan(@RequestBody TravelPlan plan) {
		try {
		// Invoke the service Method
		String registerTravelPlan = service.registerTravelPlan(plan);
		return new ResponseEntity<String>(registerTravelPlan,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> retriveAllPlans() {
		try {
			List<TravelPlan> showAllPlans = service.showAllPlans();
			return new ResponseEntity<List<TravelPlan>>(showAllPlans,HttpStatus.INTERNAL_SERVER_ERROR);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/categories")
	public ResponseEntity<?> retriveAllCategories() {
		try {
			Map<Integer, String> planCategory = service.getPlanCategory();
			return new ResponseEntity<Map<Integer,String>>(planCategory,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/find/{planId}")
	public ResponseEntity<?> getPlanBasedOnId(@PathVariable Integer planId){
		try {
			TravelPlan planById = service.getPlanById(planId);
			return new ResponseEntity<TravelPlan>(planById,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/delete/{planId}")
	public ResponseEntity<String> deleteTravelPlan(@PathVariable Integer planId) {
		try {
			String deletePlan = service.deletePlan(planId);
			return new ResponseEntity<String>(deletePlan,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateTravelPlan(@RequestBody TravelPlan plan) {
		try {
			String updateTravelPlan = service.updateTravelPlan(plan);
			return new ResponseEntity<String>(updateTravelPlan,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PatchMapping("/update/{planId}/{name}")
	public ResponseEntity<String> travelPlanInActive(@PathVariable Integer planId,@PathVariable String name) {
		try {
			String changeTravelPlanId = service.changeTravelPlanId(planId, name);
			return new ResponseEntity<String>(changeTravelPlanId,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
