package com.vms.root.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vms.root.models.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> 
{
	//Traditional query with multiple parameters
	//"select c from Country c where c.description LIKE %?1% or c.capital LIKE %?1%"
	
	/*Rather than adding multiple or and like operators we can combine them using concat()
	 * 
	 */
	
	//@Query(value = "select c from Country c where "
			//+ "c.description LIKE %?1% or c.capital LIKE %?1%")
	
	@Query(value="select c from Country c where "
			+ "concat(c.code, c.capital, c.description, c.nationality, c.continent) like %?1%")
	List<Country> getBykeyword(String keyword);
}
