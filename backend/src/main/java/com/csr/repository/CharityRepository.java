package com.hotelbooking.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.hotelbooking.models.Charity;

public interface CharityRepository extends CrudRepository<Charity, Integer>  {
	@Query(value = "SELECT * FROM charity WHERE charityCategory =:charityCategory", nativeQuery = true)
    Optional<List<Charity>> getCharities(@Param("charityCategory") String charityCategory);

	Charity findFirstByCharityName(String charityName);

	Charity findByCharityName(String charityName);

}

