package com.vms.root.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vms.root.models.Assets;
import com.vms.root.models.Location;
import com.vms.root.repositories.AssetRepository;

@Service
public class AssetsService 
{
	@Autowired
	AssetRepository AssetRepo;
	
	//get by keyword
	public List<Assets> filteredList(String keyword)
	{
		return AssetRepo.getByKeyword(keyword);
	}
	
	//get all
	public List<Assets> allAssets()
	{
		return AssetRepo.findAll();
	}
	
	//find by id
	public Optional<Assets> getById(int id)
	{
		return AssetRepo.findById(id);
	}
	
	//delete by id
	public void deleteById(Integer id)
	{
		AssetRepo.deleteById(id);
	}
	
	//add new
	public void addNew(Assets asset)
	{
		AssetRepo.save(asset);
		
	}
}
