package model;

import java.util.HashSet;
import java.util.Set;

public class Product {

	private String productID;
	private int warehouseQuantity;
	private double price;
	private Set<Discount> discounts = new HashSet<>();

	
	public Product(String productID, int warehouseQuantity, double price) {
		this.productID = productID;
		this.warehouseQuantity = warehouseQuantity;
		this.price = price;
	}

	public String toString() {
		return String.format("Product : %s\nQuantity : %d\nPrice : %f", productID, warehouseQuantity, price);
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
	    this.warehouseQuantity += quantity;

	}

	public void setProductID(String productID)
	{
		this.productID = productID;
	}

	public void setWarehouseQuantity(int quantity)
	{
		this.warehouseQuantity = quantity;
	}

	
	public int getWarehouseQuantity() {
		return warehouseQuantity;
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
