package com.vms.root.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vms.root.models.Defect;
import com.vms.root.repositories.DefectRepository;

@Service
public class DefectService {

	@Autowired
	DefectRepository defectRepo;
	
	public List<Defect> allDefects()
	{	
		return defectRepo.getUserStoryAndDefect();
	}
	
	public List<Defect> findByKeyword(String keyword)
	{
		return defectRepo.getByKeyword(keyword);
	}
	
	public Optional<Defect> findById(int id)
	{
		return defectRepo.findById(id);
	}

	public void deleteDefect(Integer id) {
		defectRepo.deleteById(id);
		
	}

	public void saveDefect(Defect defect) {
		
		defectRepo.save(defect);
	}
}
