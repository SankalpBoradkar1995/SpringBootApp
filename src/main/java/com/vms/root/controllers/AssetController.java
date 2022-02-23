package com.vms.root.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vms.root.models.Assets;
import com.vms.root.services.AssetsService;

@Controller
public class AssetController 
{
	@Autowired
	AssetsService assetService;

	@GetMapping("/asset")
	public String getAll(Model model, String keyword)
	{
		List<Assets> assetList;
		List<Assets> filteredAssets;
		
		if(keyword==null)
		{
			assetList = assetService.allAssets();
			model.addAttribute("allAssets", assetList);
		}
		else
		{
			filteredAssets = assetService.filteredList(keyword);
			assetList = assetService.allAssets();
			
			model.addAttribute("filteredAssets", filteredAssets);
			model.addAttribute("allAssets", assetList);
		}
		
		return "asset";
	}
	
	@PostMapping("/asset/addNew")
	public String addNew(Assets asset)
	{
		assetService.addNew(asset);
		return "redirect:/asset";
	}
	
	@GetMapping("/asset/findById")
	@ResponseBody
	public Optional<Assets> findById(int id)
	{
		return assetService.getById(id);
	}
	
	@RequestMapping(value="/asset/update", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String deleteAsset(Integer id)
	{
		assetService.deleteById(id);
		return "redirect:/asset";
	}
	
	@RequestMapping(value="/asset/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String updateAsset(Assets asset)
	{
		assetService.addNew(asset);
		
		return "redirect:/asset";
	}
	
}
