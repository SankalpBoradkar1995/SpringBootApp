package com.vms.root.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vms.root.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
