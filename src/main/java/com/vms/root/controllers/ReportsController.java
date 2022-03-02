package com.vms.root.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.vms.root.models.Assets;
import com.vms.root.services.ReportService;

@Controller
public class ReportsController {

	@Autowired
	ReportService reportService;
	
	@GetMapping("/assetreport")
	public String showReports()
	{
		return "report";
	}
	
	@GetMapping("/linegraphdata")
	@ResponseBody
	public String lineGraph()
	{
		List<Assets> list = reportService.reportData();
		
		JsonArray jsonMember = new JsonArray();
		JsonArray jsonAssetType = new JsonArray();
		
		JsonObject json = new JsonObject();
		
		list.forEach(data->{
			jsonMember.add(data.getAssettype());
			jsonAssetType.add(data.getAsgdate());
		});
		
		json.add("member", jsonMember);
		json.add("assettype", jsonAssetType);
		
		return json.toString();
	}
	
	@RequestMapping("/piegraph")
	public ResponseEntity<?> getPiedata()
	{
		List<Assets> pieList = reportService.reportData();
		//System.out.println(pieList);
		return new ResponseEntity<>(pieList, HttpStatus.OK);
	}
	
	@RequestMapping("/builtingraph")
	public ResponseEntity<?> buildinGraph()
	{
		List<Assets> pieList = reportService.reportData();
		//System.out.println(pieList);
		return new ResponseEntity<>(pieList, HttpStatus.OK);
	}
}
