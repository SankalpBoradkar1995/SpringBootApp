package com.vms.root.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vms.root.models.Assets;
import com.vms.root.models.Defect;
import com.vms.root.models.UserStory;
import com.vms.root.services.DefectService;
import com.vms.root.services.UserStoryService;

@Controller
public class DefectController {
	
	@Autowired
	DefectService defectService;
	
	@Autowired
	UserStoryService userServiceRepo;
	
		@GetMapping("/defect")
		public String getAllDefects(Model model, String keyword)
		{
			List<Defect> alldefects;
			List<Defect> filteredDefects;
			List<UserStory> allUserStories;
			
			if(keyword==null)
			{
				alldefects = defectService.allDefects();
				model.addAttribute("alldefects", alldefects);
				allUserStories = userServiceRepo.getAll();
				model.addAttribute("allstories", allUserStories);
			}
			else
			{
				System.out.println("Inside else block of /defect controller");
				filteredDefects = defectService.findByKeyword(keyword);
				model.addAttribute("filtereddefects", filteredDefects);
				System.out.println("Added filtered defects to model");
				alldefects=defectService.allDefects();
				model.addAttribute("alldefects", alldefects);
				allUserStories = userServiceRepo.getAll();
				model.addAttribute("allstories", allUserStories);
				
			}
			return "defect";
		}
		
		@GetMapping("/defect/bysql")
		@ResponseBody
		public  ResponseEntity<?> customQuery()
		{
			List<Defect> list =  defectService.allDefects();
			return new  ResponseEntity<>(list, HttpStatus.OK);
		}
		
		
		@GetMapping("/defect/findById")
		@ResponseBody
		public Optional<Defect> findById(int id)
		{
			return defectService.findById(id);
		}
		
		@RequestMapping(value="/defect/delete", method={RequestMethod.DELETE, RequestMethod.GET})
		public String deleteDefect(Integer id)
		{
			defectService.deleteDefect(id);
			return "redirect:/defect";
		}
		
		@RequestMapping(value="/defect/update", method= {RequestMethod.PUT, RequestMethod.GET})
		public String updateDefect(Defect defect)
		{
			defectService.saveDefect(defect);
			return "redirect:/defect";
		}
		
		@RequestMapping(value="/defect/addNew")
		public String addNew(Defect defect)
		{
			defectService.saveDefect(defect);
			return "redirect:/defect";
		}
		
		
		@RequestMapping("/findbyforeignkey")
		@ResponseBody
		public ResponseEntity<?> buildinGraph()
		{
			List<Defect> pieList = defectService.findbyforeignkey();
			//System.out.println(pieList);
			return new ResponseEntity<>(pieList, HttpStatus.OK);
		}
}
