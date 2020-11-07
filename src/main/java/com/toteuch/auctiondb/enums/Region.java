package com.toteuch.auctiondb.enums;

public enum Region {
	US(1, 1, "https://us.api.blizzard.com/", "us"), 
	EU(2, 1, "https://eu.api.blizzard.com/", "eu"),
	KO(3, 1, "https://kr.api.blizzard.com/", "kr"), 
	TW(3, 2, "https://tw.api.blizzard.com/", "tw"),
	CH(5, 1, "https://gateway.battlenet.com.cn/", "cn");

	private int regionId;
	private int realmId;
	private String host;
	private String identifier;

	Region(int regionId, int realmId, String host, String identifier) {
		this.regionId = regionId;
		this.realmId = realmId;
		this.host = host;
		this.identifier = identifier;
	}

	public int getRegionId() {
		return this.regionId;
	}

	public int getRealmId() {
		return this.realmId;
	}

	public String getHost() {
		return this.host;
	}
	
	public String getIdentifier() {
		return this.identifier;
	}
}
