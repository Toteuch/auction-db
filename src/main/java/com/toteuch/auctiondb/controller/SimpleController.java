package com.toteuch.auctiondb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.toteuch.auctiondb.entities.AuctionEntity;
import com.toteuch.auctiondb.models.AuctionItemModel;
import com.toteuch.auctiondb.services.IAuctionService;

@Controller
public class SimpleController extends AbstractAuctionDBController {
	@Value("${spring.application.name}")
    String appName;
	
	@Autowired
	private IAuctionService auctionService;
	
	@RequestMapping("/")
    public String homePage(Model model) {
        model.addAttribute("appName", appName);
        AuctionItemModel auction = new AuctionItemModel();
        auction.setItemId(2L);
        model.addAttribute("auction", auction);
        List<AuctionEntity> topTenAuctions = auctionService.getTopTen();
        model.addAttribute("topTenAuctions", topTenAuctions);
        return "home";
    }
	
	@RequestMapping("/auctionItem")
	public String getAuctionsForItemId(
			@ModelAttribute(value = "auction") final AuctionItemModel auctionItemModel,
			Model model
			) {
		List<AuctionEntity> auctions = auctionService.getAuctionsForItemId(auctionItemModel.getItemId());
		model.addAttribute("auctions", auctions);
		return "auctionsItem";
	}
}
