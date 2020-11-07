package com.toteuch.auctiondb.json;

import java.util.List;

public class AuctionResult extends ResponseBlizzard {
	private ConnectedRealm connected_realm;
	private List<Auction> auctions;
	public ConnectedRealm getConnected_realm() {
		return connected_realm;
	}
	public void setConnected_realm(ConnectedRealm connected_realm) {
		this.connected_realm = connected_realm;
	}
	public List<Auction> getAuctions() {
		return auctions;
	}
	public void setAuctions(List<Auction> auctions) {
		this.auctions = auctions;
	}
	
	
}
