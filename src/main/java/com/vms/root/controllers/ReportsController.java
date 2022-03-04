package com.vms.root.controllers;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.vms.root.models.Assets;
import com.vms.root.services.ReportService;
import com.vms.root.services.UserStoryService;

@Controller
public class ReportsController {

	@Autowired
	ReportService reportService;
	
	@Autowired
	UserStoryService userServiceRepo;
	
	@GetMapping("/assetreport")
	public String showReports()
	{
		return "report";
	}
	
	
	/*
	 * 
	 * User Story Graph Controllers
	 * 
	 * 
	 */
	
	
	
	@GetMapping("/pirgraphdata")
	@ResponseBody
	public Hashtable<String, Integer> donughtGraph()
	{
		Hashtable<String, Integer> pieList = userServiceRepo.donughtGraphData();
		

		Set<String> keys = pieList.keySet();
		System.out.println(keys);
		Iterator value = keys.iterator();
		while(value.hasNext())
		{
			System.out.println(pieList.get(value.next())); 
		}
		return pieList;
	} 
	
	@GetMapping("/piechartbypriority")
	@ResponseBody
	public Hashtable<String, Integer> bePriority()
	{
		Hashtable<String, Integer> pieList = userServiceRepo.byPriority();

		/*Set<String> keys = pieList.keySet();
		System.out.println(keys);
		Iterator value = keys.iterator();
		while(value.hasNext())
		{
			System.out.println(pieList.get(value.next())); 
		}*/
		return pieList;
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
