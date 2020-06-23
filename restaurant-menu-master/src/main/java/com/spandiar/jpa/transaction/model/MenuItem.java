package com.spandiar.jpa.transaction.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="menuitem")
public class MenuItem {
	@Id
	@Column(name="item_id")
	private String itemId;
	@Column(name="item_Name")
	private String itemName;
	@Column(name="item_Type")
	private String itemType;
	//private Restaurant.Cuisine itemCuisine;
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="item_id")
	private List<MenuPrice> price;
	@JsonIgnore
	@Column(name = "status")
	private String status;
	@JsonIgnore
	@Column(name="created_Date")
	private Date createdDate;
	@JsonIgnore
	@Column(name="created_By")
	private String createdBy;
	
	@Entity
	@Table(name="menuprice")
	@IdClass(MenuPriceId.class)
	public static class MenuPrice {
		@Id
		@JsonIgnore
		@Column(name="item_id")
		private String itemId;
		@Id
		@Column(name="item_price_id")
		private int itemPriceId;
		@Column(name="item_price")
		private float itemPrice;
		@Column(name="currency")
		private String currency;
		@Column(name="start_date")
		private Date startDate;
		@Column(name="end_date")
		private Date endDate;
		//private boolean isActive;
		@JsonIgnore
		@Column(name="created_Date")
		private Date createdDate;
		@JsonIgnore
		@Column(name="created_By")
		private String createdBy;
		@Column(name="modified_date")
		private Date modifiedDate;
		
		public MenuPrice() {
			super();
		}
		
		public String getItemId() {
			return itemId;
		}
		public void setItemId(String itemId) {
			this.itemId = itemId;
		}
		public float getItemPrice() {
			return itemPrice;
		}
		public void setItemPrice(float itemPrice) {
			this.itemPrice = itemPrice;
		}
		public String getCurrency() {
			return currency;
		}
		public void setCurrency(String currency) {
			this.currency = currency;
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
		public Date getCreatedDate() {
			return createdDate;
		}
		public void setCreatedDate(Date createdDate) {
			this.createdDate = createdDate;
		}
		public String getCreatedBy() {
			return createdBy;
		}
		public void setCreatedBy(String createdBy) {
			this.createdBy = createdBy;
		}

		public int getItemPriceId() {
			return itemPriceId;
		}

		public void setItemPriceId(int itemPriceId) {
			this.itemPriceId = itemPriceId;
		}

		public Date getModifiedDate() {
			return modifiedDate;
		}

		public void setModifiedDate(Date modifiedDate) {
			this.modifiedDate = modifiedDate;
		}

		@Override
		public String toString() {
			return "MenuPrice [itemId=" + itemId + ", itemPrice=" + itemPrice + ", currency=" + currency
					+ ", startDate=" + startDate + ", endDate=" + endDate + "]";
		}
	}
	
	public MenuItem() {
		super();
	}

	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	/*
	 * public Cuisine getItemCuisine() { return itemCuisine; } public void
	 * setItemCuisine(Cuisine itemCuisine) { this.itemCuisine = itemCuisine; }
	 */
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public List<MenuPrice> getPrice() {
		return price;
	}
	public void setPrice(List<MenuPrice> price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "MenuItem [itemId=" + itemId + ", itemName=" + itemName + ", itemType=" + itemType + ", price=" + price
				+ ", getPrice()=" + getPrice().toString() + "]";
	}
	
	
}
