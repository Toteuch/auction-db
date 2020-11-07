package com.toteuch.auctiondb.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.toteuch.auctiondb.enums.AuctionTime;

@Entity
@Table(name="auction")
@SequenceGenerator(name="seq_auction", initialValue = 1, allocationSize = 1)
public class AuctionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_auction")
	private Long id;
	@Column
	private Date creationDate;
	@Column
	private Long auctionId;
	@Column
	private Long itemId;
	@Column
	private int quantity;
	@Column
	private Long unitPrice;
	@Column
	private AuctionTime timeLeft;
	@Column
	private Long bid;
	@Column
	private Long buyout;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Long getAuctionId() {
		return auctionId;
	}
	public void setAuctionId(Long auctionId) {
		this.auctionId = auctionId;
	}
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Long getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Long unitPrice) {
		this.unitPrice = unitPrice;
	}
	public AuctionTime getTimeLeft() {
		return timeLeft;
	}
	public void setTimeLeft(AuctionTime timeLeft) {
		this.timeLeft = timeLeft;
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
