package com.toteuch.auctiondb.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.toteuch.auctiondb.enums.Region;
import com.toteuch.auctiondb.json.AuctionResult;
import com.toteuch.auctiondb.services.IApiBlizzardService;
import com.toteuch.auctiondb.services.IAuctionService;

@Component
public class AuctionScheduledTasks {

	@Autowired
	private IApiBlizzardService apiBlizzardService;
	
	@Autowired
	private IAuctionService auctionService;

	// Executed every hour
	@Scheduled(fixedRate = 3600000)
	public void testApi() {
		AuctionResult result = this.apiBlizzardService.getAuctionHouseElune();
		auctionService.saveAuctions(result.getAuctions());
	}
}
