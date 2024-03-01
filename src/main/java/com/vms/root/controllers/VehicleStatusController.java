package com.vms.root.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VehicleStatusController {
	@GetMapping("/vehiclestatus")
	public String getVehiclestatus()
	{
		return "vehiclestatus";
	}
}
