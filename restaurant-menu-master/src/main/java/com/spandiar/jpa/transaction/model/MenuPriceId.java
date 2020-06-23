package com.spandiar.jpa.transaction.model;

import java.io.Serializable;
import java.util.Date;

public class MenuPriceId implements Serializable {
	
	private String itemId;
	private int itemPriceId;
	private Date startDate;
	private Date endDate;
	
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public int getItemPriceId() {
		return itemPriceId;
	}
	public void setItemPriceId(int itemPriceId) {
		this.itemPriceId = itemPriceId;
	}
	public MenuPriceId() {
		super();
		// TODO Auto-generated constructor stub
	}

}
