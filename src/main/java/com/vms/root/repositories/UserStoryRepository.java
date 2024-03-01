package com.vms.root.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vms.root.models.UserStory;

@Repository
public interface UserStoryRepository extends JpaRepository<UserStory, Integer>{

	@Query(value="select c from UserStory c where "
			+ "concat(c.id, c.status, c.storypoint, c.sprint, c.priority, c.status, c.asignee, c.summary, c.acceptancecriteria, c.description, "
			+ "c.comment) like %?1%")
	public List<UserStory> findByKeyword(String keyword);
	
	
	List<UserStory> findByStatus(String status);
	
	List<UserStory> findByPriority(String priority);
	
}
