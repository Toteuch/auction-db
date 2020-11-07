package com.toteuch.auctiondb.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.toteuch.auctiondb.entities.AuctionEntity;

@Repository
public interface AuctionRepository extends CrudRepository<AuctionEntity, Long> {

}
