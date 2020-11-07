package com.toteuch.auctiondb.repositories;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.toteuch.auctiondb.entities.AuctionEntity;

@Repository
public interface AuctionRepository extends CrudRepository<AuctionEntity, Long> {
	
	@Modifying
	@Transactional
	@Query("delete from AuctionEntity a where a.creationDate <:minDate")
	void purgeDatabase(Date minDate);
}
