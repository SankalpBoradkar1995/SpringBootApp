package com.vms.root.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vms.root.models.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {
	
	/*@Query(value="select s.name, c.description from state s inner join c.country c where c.id= s.id")
	public List<State> getByJoin();*/
	@Query(
			  value = "select * from state", 
			  nativeQuery = true)
	public List<State> getByforeignKey();

}
