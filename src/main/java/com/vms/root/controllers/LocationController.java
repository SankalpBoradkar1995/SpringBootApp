package com.vms.root.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vms.root.models.Country;
import com.vms.root.models.Location;
import com.vms.root.models.State;
import com.vms.root.services.CountryService;
import com.vms.root.services.LocationService;
import com.vms.root.services.StateService;

@Controller
public class LocationController {
	@Autowired
	LocationService locationRepo;
	@Autowired
	StateService stateRepo;
	@Autowired
	CountryService countryRepo;
	
	@GetMapping("/location")
	public String getLocations(Model model)
	{
		List<Location> locations = locationRepo.findAll();
		model.addAttribute("locations", locations);
		
		List<Country> countryLists = countryRepo.getCountries();
		model.addAttribute("countries", countryLists);
		
		List<State> stateLists = stateRepo.getAllStates();
		model.addAttribute("states", stateLists);
		
		return "location";
	}
	
	@PostMapping("/location/addNew")
	public String addNew(Location location)
	{
		locationRepo.addNew(location);
		return "redirect:/location";
	}
	
	@GetMapping("/location/findById")
	@ResponseBody
	public Optional<Location> findById(int id)
	{
		return locationRepo.findById(id);
	}
	
	@RequestMapping(value="/location/update",method={RequestMethod.PUT,RequestMethod.GET})
	public String update(Location location)
	{
		locationRepo.addNew(location);
		return "redirect:/location";
	}
	
	@RequestMapping(value="/location/delete",method= {RequestMethod.DELETE,RequestMethod.GET})
	public String deleteLocation(Integer id)
	{
		locationRepo.delete(id);
		return "redirect:/location";
	}
}
