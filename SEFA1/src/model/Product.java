package model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Product implements Serializable{

	private String productID;
	private int warehouseQty;
	private int replenishLevel;
	private int orderQty;
	private double price;
	private Set<Discount> discounts = new HashSet<>();

	public Product(String productID, int warehouseQty, int replenishLevel, int orderQty, double price) {
		super();
		this.productID = productID;
		this.warehouseQty = warehouseQty;
		this.replenishLevel = replenishLevel;
		this.orderQty = orderQty;
		this.price = price;
	}

	public void update(int warehouseQty, int replenishLevel, int orderQty, double price) {
		this.warehouseQty = warehouseQty;
		this.replenishLevel = replenishLevel;
		this.orderQty = orderQty;
		this.price = price;
	}
	
	public String toString() {
		return String.format("Product : %s\nQuantity : %d\nPrice : %f\nDiscount Available : %b", productID,
				warehouseQty, price, !discounts.isEmpty());
	}

	public String getProductID()
	{
		return productID;
	}


	public double getPrice()
	{
		return price;
	}

	public void replenishQuantity(int quantity)
	{
	    this.warehouseQty += quantity;

	}

	public void setProductID(String productID)
	{
		this.productID = productID;
	}

	public void setWarehouseQuantity(int quantity)
	{
		this.warehouseQty = quantity;
	}

	
	public int getWarehouseQuantity() {
		return warehouseQty;
	}

	public void setPrice(double price)
	{
		this.price = price;
	}

	public void addDiscount(int qty, int discountPercent) {
		Discount dis = new Discount(qty, discountPercent);
		discounts.add(dis);
	}
	
	public Set<Discount> getDiscounts() {
		return discounts;
	}

	
	public int getReplenishLevel() {
		return replenishLevel;
	}

	public void setReplenishLevel(int replenishLevel) {
		this.replenishLevel = replenishLevel;
	}

	public int getOrderQty() {
		return orderQty;
	}

	public void setOrderQty(int orderQty) {
		this.orderQty = orderQty;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productID == null) ? 0 : productID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (productID == null) {
			if (other.productID != null)
				return false;
		} else if (!productID.equals(other.productID))
			return false;
		return true;
	}


}
