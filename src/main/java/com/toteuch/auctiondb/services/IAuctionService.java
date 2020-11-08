package com.toteuch.auctiondb.services;

import java.util.List;

import com.toteuch.auctiondb.entities.AuctionEntity;
import com.toteuch.auctiondb.json.Auction;

public interface IAuctionService {

	/**
	 * Save listed Auctions in database
	 * 
	 * @param auctions objects from BlizzardApi
	 */
	public void saveAuctions(List<Auction> auctions);

	/**
	 * Delete all auctions in database older than a month
	 */
	public void purgeDatabase();
	
	public List<AuctionEntity> getTopTen();
	
	public List<AuctionEntity> getAuctionsForItemId(Long itemId);
}
