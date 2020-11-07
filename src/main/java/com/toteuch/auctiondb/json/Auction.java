package com.toteuch.auctiondb.json;

import com.toteuch.auctiondb.enums.AuctionTime;

public class Auction {
	private Long id;
	private Item item;
	private int quantity;
	private Long unit_price;
	private AuctionTime time_left;
	private Long bid;
	private Long buyout;
	
	@Override
	public String toString() {
		return "Auction[id:"+id+",itemId:"+item.getId()+",quantity:"+quantity+",unit_price:"+unit_price+",time_left:"+time_left+"]";
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Long getUnit_price() {
		return unit_price;
	}
	public void setUnit_price(Long unit_price) {
		this.unit_price = unit_price;
	}
	public AuctionTime getTime_left() {
		return time_left;
	}
	public void setTime_left(AuctionTime time_left) {
		this.time_left = time_left;
	}
	public Long getBid() {
		return bid;
	}
	public void setBid(Long bid) {
		this.bid = bid;
	}
	public Long getBuyout() {
		return buyout;
	}
	public void setBuyout(Long buyout) {
		this.buyout = buyout;
	}
}
