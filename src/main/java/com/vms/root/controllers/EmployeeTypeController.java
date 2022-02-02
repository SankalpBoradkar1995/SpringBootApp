package com.vms.root.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeTypeController {
	@GetMapping("/employeetype")
	public String getEmployeetypes()
	{
		return "employeetype";
	}
}
