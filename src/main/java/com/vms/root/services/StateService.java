package com.vms.root.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vms.root.models.State;
import com.vms.root.repositories.StateRepository;

@Service
public class StateService 
{
	@Autowired
	StateRepository stateRepo;
	// Get all states
	
	public List<State> getAllStates()
	{
		return stateRepo.findAll();
	}
	
	public List<State> getbyJoin()
	{
		return stateRepo.getByforeignKey();
	}
	
	//Update State details
	
	public void saveState(State state)
	{
		stateRepo.save(state);
	}
	
	//Find state by ID
	public Optional<State> findStateByID(Integer id)
	{
		return stateRepo.findById(id);
	}
	
	//Delete by ID
	public void deleteState(Integer id)
	{
		stateRepo.deleteById(id);
	}
	
}
