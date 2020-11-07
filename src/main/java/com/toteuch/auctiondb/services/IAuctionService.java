package com.toteuch.auctiondb.services;

import java.util.List;

import com.toteuch.auctiondb.json.Auction;

public interface IAuctionService {
	public void saveAuctions(List<Auction> auctions);
}
