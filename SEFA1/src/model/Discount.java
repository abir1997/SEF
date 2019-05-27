package model;

import java.io.Serializable;

public class Discount implements Comparable<Discount>, Serializable {
	private static final long serialVersionUID = 4288890572272016673L;
	
	private int quantity;
	private int discountPercent;
	

	public Discount(int quantity, int discountPercent) {
		this.quantity = quantity;
		this.discountPercent = discountPercent;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public int getDiscountPercent() {
		return discountPercent;
	}

	public String toString() {
		return String.format("Quantity : %d\nDiscount Percent : %d", quantity, discountPercent);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + quantity;
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
		Discount other = (Discount) obj;
		if (quantity != other.quantity)
			return false;
		return true;
	}

	@Override
	public int compareTo(Discount discount) {
		return discount.quantity - quantity;
	}
}
