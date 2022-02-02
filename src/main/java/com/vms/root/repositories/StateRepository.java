package com.vms.root.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vms.root.models.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {

}
