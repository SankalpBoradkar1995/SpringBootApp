package com.vms.root.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VehicleHireController {
	@GetMapping("/vehiclehire")
	public String getVehiclehires()
	{
		return "vehiclehire";
	}
}
