package com.vms.root.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vms.root.models.Country;
import com.vms.root.repositories.CountryRepository;
import com.vms.root.repositories.CountryRepositoryByName;

@Service
public class CountryService 
{
	// Initiliazing CountryRepository to talk to DB
	
	@Autowired
	private CountryRepository countryRepo;
	@Autowired
	CountryRepositoryByName countryByName;
	
	
	public List<Country> findByKeyword(String keyword)
	{
		return countryRepo.getBykeyword(keyword);
	}
	
	public List<Country> findBycapital(String capital)
	{
		System.out.println("Inside by service by name controller");
		return countryByName.findBycapital(capital);
		
	}
	
	//Returns list of countries from DB
	public List<Country> getCountries()
	{
		return countryRepo.findAll();
	}
	
	//Add new country
	
	public void saveCountry(Country country)
	{
		countryRepo.save(country);
	}
	
	//Get country by ID, added optional to avoid exception in case no country is present with provided id
	
	public Optional<Country> getCountryById(int id)
	{
		
		return countryRepo.findById(id);
	}
	
	//Delete country by ID
	
	public void delete(Integer id)
	{
		countryRepo.deleteById(id);
	}
	
}
