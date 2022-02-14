package com.vms.root.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vms.root.models.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {

}
