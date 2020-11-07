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

	@Scheduled(cron = "0 0 * * * *")
	public void testApi() {
		System.out.println(this.apiBlizzardService.getTokenPrice(Region.EU).getPrice());
		AuctionResult result = this.apiBlizzardService.getAuctionHouseElune();
		auctionService.saveAuctions(result.getAuctions());
	}
}
