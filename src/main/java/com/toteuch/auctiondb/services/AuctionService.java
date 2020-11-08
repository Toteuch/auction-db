package com.toteuch.auctiondb.services;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.toteuch.auctiondb.entities.AuctionEntity;
import com.toteuch.auctiondb.json.Auction;
import com.toteuch.auctiondb.repositories.AuctionRepository;

@Service
public class AuctionService implements IAuctionService {
	
	@Autowired
	private AuctionRepository repo;
	
	Logger logger = LoggerFactory.getLogger(AuctionService.class);
	
	@Override
	public void saveAuctions(List<Auction> auctions) {
		logger.info("Saving " + auctions.size() + " auctions...");
		Date creationDate = new Date();
		int compteur = 1;
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
			logger.debug("Saving " + compteur+"/"+auctions.size()+ " auctions...");
			repo.save(ent);
			compteur++;
		}
		logger.info("End of saving " + auctions.size() + " auctions");
	}

	@Override
	public void purgeDatabase() {
		// Calculate minDate to keep in database
		Calendar minusOneMonth = Calendar.getInstance();
		minusOneMonth.add(Calendar.MONTH, -1);
		logger.info("Purging database from auctions older than " + minusOneMonth.getTime().toString());
		repo.purgeDatabase(minusOneMonth.getTime());
	}

	@Override
	public List<AuctionEntity> getTopTen() {
		logger.debug("Get top ten auctions...");
		Pageable page = PageRequest.of(0, 10);
		return repo.findAllByUnitPriceIsNotNullOrderByUnitPriceDesc(page);
	}

	@Override
	public List<AuctionEntity> getAuctionsForItemId(Long itemId) {
		logger.debug("Get Auctions for itemId : " + itemId);
		Pageable page = PageRequest.of(0, 200);
		return repo.findByItemIdOrderByCreationDateDescUnitPriceAsc(itemId, page);
	}

}
