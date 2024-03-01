package com.vms.root.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JobTitleController {
	@GetMapping("/jobtitle")
	public String getJobtitles()
	{
		return "jobtitle";
	}
}
