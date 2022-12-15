package com.hotelbooking.repository;


import org.springframework.data.repository.CrudRepository;

import com.hotelbooking.models.Business;

public interface BusinessRepository extends CrudRepository<Business, Integer>  {

	Business findByBusinessName(String businessName);

}
