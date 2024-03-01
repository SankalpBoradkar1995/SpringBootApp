package com.vms.root.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vms.root.models.Assets;
import com.vms.root.repositories.AssetRepository;
import com.vms.root.repositories.ReportRepository;

@Service
public class ReportService {

	@Autowired
	ReportRepository reportRepo;
	
	@Autowired
	AssetRepository assetRepo;
	
	 public List<Assets> reportData()
	 {
		 return assetRepo.findAll();
	 }
}
