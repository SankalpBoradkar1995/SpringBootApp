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
import com.vms.root.models.UserStory;
import com.vms.root.models.UserStory;
import com.vms.root.services.UserStoryService;

@Controller
public class UserStoryController {

	@Autowired
	UserStoryService userServiceRepo;
	
	@GetMapping("/userstory")
	public String getAllUserStories(Model model, String keyword)
	{
		List<UserStory> completelist;
		List<UserStory> filteredList;
		
		if(keyword==null)
		{
			completelist = userServiceRepo.getAll();
			model.addAttribute("allModels", completelist);
		}
		else
		{
			filteredList = userServiceRepo.findByKeyword(keyword);
			model.addAttribute("filteredList", filteredList);
			completelist = userServiceRepo.getAll();
			model.addAttribute("allModels", completelist);
		}
		
		return "userstory";
	}
	
	//update
		@RequestMapping(value="/userstory/update",method= {RequestMethod.PUT, RequestMethod.GET})
		public String updateUserStory(UserStory UserStory)
		{
			userServiceRepo.saveUserStory(UserStory);
			return "redirect:/userstory";
		}
		
		//findByID
		@GetMapping("/userstory/findById")
		@ResponseBody
		public Optional<UserStory> findUserStoryById(int id)
		{
			return userServiceRepo.findUserStoryByID(id);
		}
		
		//delete
		@RequestMapping(value="/userstory/delete", method={RequestMethod.DELETE, RequestMethod.GET})
		public String deleteUserStory(Integer id)
		{
			userServiceRepo.deleteUserStory(id);
			return "redirect:/userstory";
		}
		
		//addNew
		@RequestMapping(value="/userstory/addNew")
		public String addUserStory(UserStory userstory)
		{
			userServiceRepo.saveUserStory(userstory);
			return "redirect:/userstory";
		}
		
		
}
