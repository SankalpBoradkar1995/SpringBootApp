package com.vms.root.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vms.root.models.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> 
{
	
}
