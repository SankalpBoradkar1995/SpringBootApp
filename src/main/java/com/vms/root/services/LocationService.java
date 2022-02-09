package com.vms.root.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vms.root.models.Location;
import com.vms.root.repositories.LocationRepository;

@Service
public class LocationService 
{
	@Autowired 
	LocationRepository locationRepo;
	
	//add new location
	
	public void addNew(Location location)
	{
		locationRepo.save(location);
	}
	
	// get all
	 public List<Location> findAll()
	 {
		 return locationRepo.findAll();
	 }
	 
	 // find by ID
	 
	 public Optional<Location> findById(int id)
	 {
		 return locationRepo.findById(id);
	 }
	 
	 // delete
	 
	 public void delete(Integer id)
	 {
		 locationRepo.deleteById(id);
	 }
}
