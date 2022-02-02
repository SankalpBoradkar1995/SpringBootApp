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

import com.vms.root.models.State;
import com.vms.root.services.StateService;

@Controller
public class StateController 
{
	@Autowired
	StateService stateRepo;
	
	@GetMapping("/state")
	public String getStates(Model model)
	{
		List<State> stateDetails = stateRepo.getAllStates();
		model.addAllAttributes(stateDetails);
		return "state";
	}
	
	@RequestMapping(value="/state/update",method= {RequestMethod.GET,RequestMethod.PUT})
	public String updateState(State state)
	{
		stateRepo.saveState(state);
		return "redirect:/state";
	}
	
	@GetMapping("/state/findById")
	@ResponseBody
	public Optional<State> findStateById(Integer id)
	{
		return stateRepo.findStateByID(id);
	}
	
	@RequestMapping(value="/state/delete", method=RequestMethod.DELETE)
	public String deleteState(int id)
	{
		stateRepo.deleteState(id);
		return "redirect:/state";
	}
	
	@RequestMapping(value="/state/addNew", method= {RequestMethod.GET,RequestMethod.POST})
	public String addState(State state)
	{
		stateRepo.saveState(state);
		return "redirect:/state";
	}
}
