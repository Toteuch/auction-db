package com.toteuch.auctiondb.services;

import com.toteuch.auctiondb.enums.Region;
import com.toteuch.auctiondb.json.AuctionResult;
import com.toteuch.auctiondb.json.TokenPrice;

public interface IApiBlizzardService {

	/**
	 * Return token price for specified {@link Region}
	 * 
	 * @param region See {@link Region}
	 * @return See {@link TokenPrice}
	 */
	public TokenPrice getTokenPrice(Region region);

	/**
	 * Return all auctions for EU-Elune realm
	 * 
	 * @return See {@link AuctionResult}
	 */
	public AuctionResult getAuctionHouseElune();
}
