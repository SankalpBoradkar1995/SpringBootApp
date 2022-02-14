package com.vms.root;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class App 
{
	@GetMapping("/index")
	public String Home()
	{
		return "index";
	}
}
