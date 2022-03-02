package com.vms.root.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vms.root.models.Assets;

@Repository
public interface ReportRepository extends JpaRepository<Assets, Integer>
{
	/*@Query(value="SELECT a.member, a.assettype FROM Assets a GROUP BY member",
			nativeQuery=true)
	List<Assets> getListOfMembers();*/

}
