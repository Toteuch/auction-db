package com.toteuch.auctiondb.json;

public class TokenPrice extends ResponseBlizzard {
	private Long last_updated_timestamp;
	private int price;
	public Long getLast_updated_timestamp() {
		return last_updated_timestamp;
	}
	public void setLast_updated_timestamp(Long last_updated_timestamp) {
		this.last_updated_timestamp = last_updated_timestamp;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
