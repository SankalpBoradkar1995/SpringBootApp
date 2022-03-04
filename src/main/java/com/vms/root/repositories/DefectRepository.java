package com.vms.root.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.vms.root.models.Defect;

public interface DefectRepository extends JpaRepository<Defect, Integer>{
	
	@Query(
			  value = "select * from defect", 
			  nativeQuery = true)
	public List<Defect> getUserStoryAndDefect();
	
	@Query("select d from Defect d where "
			+ "concat(d.id, d.sprint, d.priority, d.status, d.asignee, d.summary, d.description, d.comment) like %?1%")
	public List<Defect> getByKeyword(String keyword);

}
