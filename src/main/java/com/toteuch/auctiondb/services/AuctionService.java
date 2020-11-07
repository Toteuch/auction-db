package com.toteuch.auctiondb.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toteuch.auctiondb.entities.AuctionEntity;
import com.toteuch.auctiondb.json.Auction;
import com.toteuch.auctiondb.repositories.AuctionRepository;

@Service
public class AuctionService implements IAuctionService {
	
	@Autowired
	private AuctionRepository repo;
	
	@Override
	public void saveAuctions(List<Auction> auctions) {
		System.out.println("["+new Date()+"]Saving " + auctions.size() + " auctions...");
		Date creationDate = new Date();
		for(Auction auction : auctions) {
			AuctionEntity ent = new AuctionEntity();
			ent.setAuctionId(auction.getId());
			ent.setBid(auction.getBid());
			ent.setBuyout(auction.getBuyout());
			ent.setCreationDate(creationDate);
			ent.setItemId(auction.getItem().getId());
			ent.setQuantity(auction.getQuantity());
			ent.setTimeLeft(auction.getTime_left());
			ent.setUnitPrice(auction.getUnit_price());
			repo.save(ent);
		}
		System.out.println("["+new Date()+"]End of saving " + auctions.size() + " auctions");
	}

}
