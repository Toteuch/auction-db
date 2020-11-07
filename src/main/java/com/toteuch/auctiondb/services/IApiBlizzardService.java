package com.toteuch.auctiondb.services;

import com.toteuch.auctiondb.enums.Region;
import com.toteuch.auctiondb.json.AuctionResult;
import com.toteuch.auctiondb.json.TokenPrice;

public interface IApiBlizzardService {
	public TokenPrice getTokenPrice(Region region);
	public AuctionResult getAuctionHouseElune();
}
