package com.vms.root.services;

import java.util.Hashtable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vms.root.models.UserStory;
import com.vms.root.repositories.UserStoryRepository;

@Service
public class UserStoryService 
{
	@Autowired
	UserStoryRepository userStoryRepo;
	
	public List<UserStory> getAll()
	{
		return userStoryRepo.findAll();
	}

	public List<UserStory> findByKeyword(String keyword) {
		
		List<UserStory> list = userStoryRepo.findByKeyword(keyword);
		
		System.out.println("Size of searched fields: "+list.size());
		
		return list;
	}
	
	public void saveUserStory(UserStory userstory)
	{
		userStoryRepo.save(userstory);
	}
	
	public Optional<UserStory> findUserStoryByID(int id)
	{
		return userStoryRepo.findById(id);
	}
	
	public void deleteUserStory(Integer id)
	{
		userStoryRepo.deleteById(id);
	}
	
	public Hashtable<String,Integer> donughtGraphData()
	{
		Hashtable<String,Integer> counts = new Hashtable<String,Integer>();
		
		List<UserStory> recordList;
		
		for(int i=0;i<5;i++)
		{
			int count;
			switch(i) {
			
			case 0:
			recordList = userStoryRepo.findByStatus("Completed");
			count = recordList.size();
			counts.put("completed", count);
			recordList.clear();
			break;
			
			case 1:
				recordList = userStoryRepo.findByStatus("New");
				count = recordList.size();
				counts.put("new", count);
				recordList.clear();
				break;
				
			case 2:
				recordList = userStoryRepo.findByStatus("In Progress");
				count = recordList.size();
				counts.put("in_progress", count);
				recordList.clear();
				break;
				
			case 3:
				recordList = userStoryRepo.findByStatus("On hold");
				count = recordList.size();
				counts.put("on_hold", count);
				recordList.clear();
				break;
				
			case 4:
				recordList = userStoryRepo.findByStatus("Obsolute");
				count = recordList.size();
				counts.put("obsolute", count);
				recordList.clear();
				break;
			}
		}
		
		 
		return counts;
	}
	
	public Hashtable<String,Integer> byPriority()
	{
		Hashtable<String,Integer> counts = new Hashtable<String,Integer>();
		
		List<UserStory> recordList;
		//findByPriority
		
		int count;
		
		for(int i=0;i<3;i++)
		{
			switch(i) {
			
			case 0:
				recordList = userStoryRepo.findByPriority("P1");
				count = recordList.size();
				counts.put("P1", count);
				recordList.clear();
				break;
				
			case 1:
				recordList = userStoryRepo.findByPriority("P2");
				count = recordList.size();
				counts.put("P2", count);
				recordList.clear();
				break;
			
			case 2:
				recordList = userStoryRepo.findByPriority("P3");
				count = recordList.size();
				counts.put("P3", count);
				recordList.clear();
				break;
			}
		}
		
		return counts;
	}
	
	public int storyCount()
	{
		List<UserStory> storyCount = userStoryRepo.findAll();
		int count = storyCount.size();
		return count;
	}
}
