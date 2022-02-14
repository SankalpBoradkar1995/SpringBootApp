package com.vms.root.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vms.root.models.Country;
import com.vms.root.models.State;
import com.vms.root.services.CountryService;
import com.vms.root.services.StateService;

@Controller
public class StateController 
{
	@Autowired
	StateService stateRepo;
	@Autowired
	CountryService countryRepo;
	
	//get
	@GetMapping("/state")
	public String getStates(Model model)
	{
		List<State> stateList = stateRepo.getAllStates();
		model.addAttribute("states", stateList);
		List<Country> countryList = countryRepo.getCountries();
		model.addAttribute("countries",countryList);
		return "state";
	}
	
	//update
	@RequestMapping(value="/state/update",method= {RequestMethod.PUT, RequestMethod.GET})
	public String updateState(State state)
	{
		stateRepo.saveState(state);
		return "redirect:/state";
	}
	
	//findByID
	@GetMapping("/state/findById")
	@ResponseBody
	public Optional<State> findStateById(int id)
	{
		return stateRepo.findStateByID(id);
	}
	
	//delete
	@RequestMapping(value="/state/delete", method={RequestMethod.DELETE, RequestMethod.GET})
	public String deleteState(Integer id)
	{
		stateRepo.deleteState(id);
		return "redirect:/state";
	}
	
	//addNew
	@RequestMapping(value="/state/addNew")
	public String addState(State state)
	{
		stateRepo.saveState(state);
		return "redirect:/state";
	}
}
