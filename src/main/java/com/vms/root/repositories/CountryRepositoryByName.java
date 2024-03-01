package com.vms.root.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.vms.root.models.Country;

public interface CountryRepositoryByName extends CrudRepository<Country, Integer>
{
	public List<Country> findBycapital(String capital);
}
