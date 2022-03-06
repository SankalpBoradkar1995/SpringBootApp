package com.vms.root;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vms.root.models.Defect;
import com.vms.root.services.DefectService;
import com.vms.root.services.UserStoryService;

@Controller
public class App 
{
	
	@Autowired
	DefectService defectService;
	
	@Autowired
	UserStoryService userServiceRepo;
	
	/*@RequestMapping("/findbyforeignkey")
	@ResponseBody
	public ResponseEntity<?> buildinGraph()
	{
		List<Defect> pieList = defectService.findbyforeignkey();
		//System.out.println(pieList);
		return new ResponseEntity<>(pieList, HttpStatus.OK);
	}*/
	
	@GetMapping("/index")
	public String Home(Model model)
	{
		List<Defect> defectList = defectService.findbyforeignkey();
		model.addAttribute("defectdetails", defectList);
		
		
		return "index";
	}
	
	@GetMapping("/defectcount")
	@ResponseBody
	public ResponseEntity<Object> defectCount() {
		List<Defect> pieList = defectService.findbyforeignkey();
		int defectcount = pieList.size();
		return new ResponseEntity<>(defectcount,HttpStatus.OK);
	}
	
	@GetMapping("/storycount")
	@ResponseBody
	public ResponseEntity<Object> storyCOunt() {
		//System.out.println("Inside user story count controller of index page");
		int count = userServiceRepo.storyCount();
		return new ResponseEntity<>(count,HttpStatus.OK);
	}

}
