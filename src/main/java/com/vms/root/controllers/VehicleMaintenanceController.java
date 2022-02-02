package com.vms.root.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VehicleMaintenanceController {
	@GetMapping("/vehiclemaintenance")
	public String getVehiclemaintenance()
	{
		return "vehiclemaintenance";
	}
}
