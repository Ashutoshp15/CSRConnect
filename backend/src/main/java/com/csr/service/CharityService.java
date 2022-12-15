package com.hotelbooking.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.hotelbooking.models.Charity;
import com.hotelbooking.models.Donation;
import com.hotelbooking.repository.CharityRepository;
import com.hotelbooking.repository.DonationRepository;

@Service
public class CharityService {
	
	private final CharityRepository charityRepository;
	private final DonationRepository donationRepository;
	
	
	public CharityService(CharityRepository charityRepository, DonationRepository donationRepository) {
		this.charityRepository = charityRepository;
		this.donationRepository = donationRepository;
	}
	
	
	public void addCharity(Charity charity) {
		charityRepository.save(charity);
	}
	
	public void updateCharity(Charity charity, int id) {
		Charity currentCharity = getCharity(id);
		/**
		 * Update the current charity values
		**/
		currentCharity.setCharityCategory(charity.getCharityCategory());
		currentCharity.setCharityName(charity.getCharityName());
		
		charityRepository.save(currentCharity);
	}
	
	public Charity getCharity(int id) {
		Charity charity = charityRepository.findById(id).orElseThrow(RuntimeException::new);
		System.out.println(charity);
		return charity;
	}
	public List<Charity> searchCharityByCategory(String category) {
		
		Optional<List<Charity>> charityList = charityRepository.getCharities(category);
		charityList.orElseThrow(
	        () ->
	            new EntityNotFoundException(
	                "No charities found for " + category + ". Let's try something else."));
	    return charityList.get();
	}
	
	public List<Charity> getAllCharities() {
		return (List<Charity>) charityRepository.findAll();
	}
	
	public int getTotalDonation(String charityName) {
		List<Donation> donationList = donationRepository.findByCharity(charityName);
		int totalDonation = 0;
		for (Donation d: donationList) {
			totalDonation += d.getAmount();
		}
		return totalDonation;
	}
	
	public Map<String, Integer> getDonationMap(String charityName) {
		// TODO Auto-generated method stub
		List<Donation> donationList = donationRepository.findByCharity(charityName);
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		for(Donation d: donationList) {
			map.put(d.getBusiness(), map.getOrDefault(d.getBusiness(), 0) + d.getAmount());
		}
		
		return map;
	}
	

	public List<Donation> getDonationDist(String charityName) {
		// TODO Auto-generated method stub
		List<Donation> donationList = new ArrayList<>();
		Map<String, Integer> map = getDonationMap(charityName);
		for(String key : map.keySet())
		{
			Donation d = new Donation();
			d.setAmount(map.get(key));
			d.setBusiness(key);
			d.setCharity(charityName);
			donationList.add(d);
		}
		
		return donationList;
	}
	
	public List<Donation> getTopBusiness(String charityName) {
		
		List<Donation> list = new ArrayList<Donation>();
		list = getDonationDist(charityName);
		
		Collections.sort(list, new Comparator<Donation>() {
            public int compare(Donation d1, Donation d2)
            {
                return d2.getAmount() - d1.getAmount();
            }
        });
		
		List<Donation> temp = new ArrayList<Donation>();
		int i=5;
		for(Donation d: list)
		{
			if(i==0)
			{
				break;
			}
			temp.add(d);
		}
		
		return temp;
		
	}


	public Map<String, Integer> getRecentBusiness(String charityName) {
		// TODO Auto-generated method stub
		return null;
	}


	public Charity getCharities(String charityName) {
		// TODO Auto-generated method stub
		return charityRepository.findByCharityName(charityName);
	}

}
