package com.hotelbooking.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hotelbooking.models.Donation;


public interface DonationRepository extends CrudRepository<Donation, Integer>  {

	List<Donation> findByCharity(String charityName);

	List<Donation> findByBusiness(String businessName);

}
