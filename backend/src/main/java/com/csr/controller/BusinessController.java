package com.hotelbooking.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hotelbooking.models.Donation;
import com.hotelbooking.models.Business;
import com.hotelbooking.service.BusinessService;

@RestController
public class BusinessController {

	private BusinessService businessService;
	
	public BusinessController(BusinessService businessService) {
		this.businessService = businessService;
	}
	
	@PostMapping("/business/add")
	public void addOrUpdateBusiness(@RequestBody Business business) {
		business.setBusinessName(business.getBusinessName().toLowerCase());
		businessService.addBusiness(business);
	}
	
	@PostMapping("/business/update/{id}")
	public void addOrUpdateCharity(@RequestBody Business business, @PathVariable int id) {
		businessService.updateBusiness(business, id);
	}
	
	@GetMapping("/business/all")
    public List<Business> searchBusinesses() throws Exception {
		return businessService.getAllBusinesses();        
    }
	
	@GetMapping("/business/totalDonation/{businessName}")
	public int totalDonation(@PathVariable String businessName) {
		return businessService.getTotalDonation(businessName);
	}
	
	@PostMapping("/donate")
	public void donate(@RequestBody Donation donation) {
		businessService.addDonation(donation);
	}
	
	@GetMapping("/business/donatedCharities/{businessName}/all")
	public List<Donation> donationDist(@PathVariable String businessName) {
		return businessService.getDonationDist(businessName);
	}
	
	@GetMapping("/business/donatedCharities/{businessName}/top")
	public List<Donation> donationDistByCharity(@PathVariable String businessName) {
		return businessService.getTopCharities(businessName);
	}
	
	@GetMapping("/business/get/{businessName}")
	public Business getBusiness(@PathVariable String businessName) {
		return businessService.getBusiness(businessName);
	}
	
	@GetMapping("/testimonials/business")	
	public List<String> getTestimonials()
	{
		List<String> testimonials = new ArrayList<String>();
		
		ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i=1; i<11; i++) list.add(i);
        
        Collections.shuffle(list);
		
		return testimonials;
	}

}
