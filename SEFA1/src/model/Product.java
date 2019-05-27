package model;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

public class Product implements Serializable{

	private static final long serialVersionUID = -6411877934409588801L;
	
	private String productId;
	private String name;
	private int warehouseQty;
	private int replenishLevel;
	private int orderQty;
	private double price;
	private Set<Discount> discounts = new TreeSet<>();

	public Product(String productId, String name, int warehouseQty, int replenishLevel, int orderQty, double price) {
		super();
		this.productId = productId;
		this.name = name;
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
	
	/**
	 * loop through the descendingly sorted tree based on quantity and return
	 * applicable percentage for the given quantity.
	 * 
	 * @param qty
	 * @return
	 */
	public int calcDiscount(int qty) {
		for (Discount discount : discounts) {
			if (discount.getQuantity() <= qty) {
				return discount.getDiscountPercent();
			}
		}
		return 0;
	}

	public String toString() {
		return String.format("Product : %s\nQuantity : %d\nPrice : %f\nDiscount Available : %b", productId,
				warehouseQty, price, !discounts.isEmpty());
	}

	public String getProductId() {
		return productId;
	}

	public double getPrice() {
		return price;
	}

	public void replenishQuantity(int quantity) {
		this.warehouseQty += quantity;
	}

	public void setProductI1d(String productID) {
		this.productId = productID;
	}

	public void setWarehouseQuantity(int quantity) {
		this.warehouseQty = quantity;
	}

	public int getWarehouseQuantity() {
		return warehouseQty;
	}

	public void setPrice(double price) {
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

	public int getOrderQty() {
		return orderQty;
	}

	public void setOrderQty(int orderQty) {
		this.orderQty = orderQty;
	}

	
	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
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
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		return true;
	}

}
