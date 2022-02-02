package com.vms.root.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vms.root.models.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

}
