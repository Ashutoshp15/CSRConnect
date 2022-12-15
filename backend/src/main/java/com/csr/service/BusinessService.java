package com.hotelbooking.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.hotelbooking.models.Business;
import com.hotelbooking.models.Donation;
import com.hotelbooking.repository.BusinessRepository;
import com.hotelbooking.repository.DonationRepository;

@Service
public class BusinessService {
	
	public BusinessRepository businessRepository;
	private DonationRepository donationRepository;
	
	public BusinessService (BusinessRepository businessRepository, DonationRepository donationRepository) {
		this.businessRepository = businessRepository;
		this.donationRepository = donationRepository;
	}

	public void addBusiness(Business business) {
		businessRepository.save(business);		
	}

	public void updateBusiness(Business business, int id) {
		Business businessCurrent = businessRepository.findById(id).orElseThrow(RuntimeException::new);
		/**
		 * Update the current charity values
		**/
		businessRepository.save(business);
		
	}

	public List<Business> getAllBusinesses() {
		return (List<Business>) businessRepository.findAll();
	}

	public int getTotalDonation(String businessName) {
		
		List<Donation> donationList = donationRepository.findByBusiness(businessName);
		int totalDonation = 0;
		for (Donation d: donationList) {
			totalDonation += d.getAmount();
		}
		return totalDonation;
	}

	public Map<String, Integer> getDonationMap(String businessName) {
		List<Donation> donationList = donationRepository.findByBusiness(businessName);
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		for (Donation d: donationList) {
			map.put(d.getCharity(), map.getOrDefault(d.getCharity(), 0) + d.getAmount());
		}
		
		return map;
	}
	
	public List<Donation> getDonationDist(String businessName) {
		// TODO Auto-generated method stub
		List<Donation> donationList = new ArrayList<>();
		Map<String, Integer> map = getDonationMap(businessName);
		for(String key : map.keySet())
		{
			Donation d = new Donation();
			d.setAmount(map.get(key));
			d.setCharity(key);
			d.setBusiness(businessName);
			donationList.add(d);
		}
		
		return donationList;
	}
	
	public List<Donation> getTopCharities(String businessName) {
		
		List<Donation> list = new ArrayList<Donation>();
		list = getDonationDist(businessName);
		
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
	
	public void addDonation(Donation donation) {
		donationRepository.save(donation);		
	}

	public Business getBusiness(String businessName) {
		// TODO Auto-generated method stub 
		return businessRepository.findByBusinessName(businessName);
	}

}
