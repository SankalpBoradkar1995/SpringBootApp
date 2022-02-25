package com.vms.root.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vms.root.models.Assets;

@Repository
public interface AssetRepository extends JpaRepository<Assets, Integer>
{
	@Query("select a from Assets a where "
			+ "concat(a.member, a.assettype, a.expirydate, a.hardwarepurpose, a.macid, a.licencetype, a.licencedetails, a.softwarepurpose) like %?1%")
	public List<Assets> getByKeyword(String keyword);
	
}
