package com.vms.root.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.vms.root.models.Country;
import com.vms.root.repositories.CountryRepositoryByName;
import com.vms.root.services.CountryService;


@Controller
public class CountryController 
{
	@Autowired(required = true)
	private CountryService countryService;
	
	
	@GetMapping("/country")
	public String getCountries(Model model) //-->Adding parameter to method to send list & html page in return
	{
		List<Country> countryList = countryService.getCountries();
		
		model.addAttribute("countries", countryList); //-->Adding list to model with attribute name as countries
													 //-->Using "countries" can iterate list of countries on HTML page	
		return "country";
	}
	
	@PostMapping("/country/addNew")
	public String addNew(Country country)
	{
		countryService.saveCountry(country);
		return "redirect:/country";
		
		/*-->Not calling this request directly from browser
		 *-->On add country form in country.html, added this request with action as post
		 *-->So when user submits details, post method will be executed and dispatcher will route it here
		 *-->HTML page will send all country details submitted by user as Country object
		 *-->That country object we are sharing with CountryService, where it is getting saves
		 *-->At last redirecting user to country page where they will get updated countries 
		 */
		
		/*-->NOTE: It will save empty values in db
		 * Follow these steps to resolve the issue
		 * Exit/Shutdown STS
		   Find lombok Jar in ~/.m2/repository/org/projectlombok/lombok/version.x
		   From Command Prompt/Shell java -jar lombok-1.x.y.jar
		 * 
		 */
	}
	
	@RequestMapping("/country/findById")
	@ResponseBody
	public Optional<Country> findById(int id)
	{
		/*-->Inside for loop to list countries I've mapped findById url
		 *-->When clicked on edit button control will come to this method
		 *   and edit button will give me id for that particular row
		 *   of which edit button is clicked
		 *-->Since we have added @ResponseBody, it will fetch data for taht id and give response as json   
		 *-->Click action on edit button will execute country.js script which will open editModel from country.htlm
		 *-->country.js will parse dynamic url for particular row and fetch all details from json for that ID
		 *   and will display all those details from parsed json inside opened model
		 */
		return countryService.getCountryById(id);
		
		 
	}
	
	@RequestMapping(value="/country/update",method= {RequestMethod.PUT,RequestMethod.GET})
	public String updateCountry(Country country)
	{
		/*-->After modifying entries inside model when clicked submit,
		 *   addModel from country.html will get called and received country fields from thymeleaf as Country country 
		 *   will get passed to saveCountry() of CountryRepository
		 *-->Here added two annotations  RequestMethod.PUT,RequestMethod.GET 
		 *-->RequestMethod.PUT will put updated data to DB
		 *-->RequestMethod.GET will get data from thymeleaf and pass to RequestMethod.PUT-->saveCountry() to update in db
		 */
		countryService.saveCountry(country);
		return "redirect:/country";
	}
	
	@RequestMapping(value="/country/delete",method= {RequestMethod.DELETE,RequestMethod.GET})
	
	public String deleteByID(Integer id)
	{
		countryService.delete(id);
		
		return "redirect:/country";
	}
	
	
	@RequestMapping(value="/country/description/{capital}", method=RequestMethod.GET)
	public String findByName(@RequestParam String capital, Model map)
	{
		System.out.println("Input from UI:"+" "+capital);
		System.out.println("Inside by name controller");
		//ModelAndView model = new ModelAndView();
		List<Country> countryList = countryService.getCountries();
		
		map.addAttribute("countries", countryList);
		map.addAttribute("capitalData", countryService.findBycapital(capital));
		
		//System.out.println(countryService.findBycapital(capital));
		 
		 return "country";
	}
	
	
}
