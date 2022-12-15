package com.hotelbooking.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotelbooking.models.Charity;
import com.hotelbooking.models.Donation;
import com.hotelbooking.service.CharityService;

@RestController
public class CharityController {
	

	
	private CharityService charityService;
	
	public CharityController(CharityService charityService) {
		this.charityService = charityService;
	}
	
	@PostMapping("/charities/add")
	public void addOrUpdateCharity(@RequestBody Charity charity) {
		charity.setCharityName(charity.getCharityName().toLowerCase());
		charityService.addCharity(charity);
	}
	
	@GetMapping("/charities/get/{charityName}")
	public Charity getCharity(@PathVariable String charityName) {
		return charityService.getCharities(charityName);
	}
	
	@PostMapping("/charities/update/{id}")
	public void addOrUpdateCharity(@RequestBody Charity charity, @PathVariable int id) {
		charityService.updateCharity(charity, id);
	}
	
	@GetMapping("/charities/all")
    public List<Charity> searchCharities(@RequestParam(required = false) String category) throws Exception {
        if (category != null) {
            return charityService.searchCharityByCategory(category.toLowerCase());
        }
        else {
            return charityService.getAllCharities();
        }
    }
	
	@GetMapping("/charity/totalDonation/{charityName}")
	public int totalDonation(@PathVariable String charityName) {
		return charityService.getTotalDonation(charityName);
	}
	
	@GetMapping("/charity/donationFromBusiness/{charityName}/all")
	public List<Donation> donationDist(@PathVariable String charityName) {
		return charityService.getDonationDist(charityName);
	}
	
	@GetMapping("/charity/donationFromBusiness/{charityName}/top")
	public List<Donation> donationDistTop(@PathVariable String charityName) {
		return charityService.getTopBusiness(charityName);
	}
	
	//get recent 5
	@GetMapping("/charity/donationFromBusiness/{charityName}/recent")
	public Map<String, Integer> donationDistRecent(@PathVariable String charityName) {
		return charityService.getRecentBusiness(charityName);
	}


}
