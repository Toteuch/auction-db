package com.toteuch.auctiondb.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

public abstract class AbstractAuctionDBController {
	
	@ModelAttribute
	public void addAttributes(Model model) {
		model.addAttribute("username","Toteuch");
	}
}
