package com.vms.root.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.vms.root.models.Location;
import com.vms.root.services.LocationService;

@Controller
public class LocationController {
	@Autowired
	LocationService locationRepo;
	
	@GetMapping("/location")
	public String getLocations(Model model)
	{
		List<Location> locations = locationRepo.findAll();
		model.addAttribute("locations", locations);
		
		return "location";
	}
}
