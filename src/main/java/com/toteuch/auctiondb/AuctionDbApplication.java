package com.toteuch.auctiondb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AuctionDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuctionDbApplication.class, args);
	}

}
