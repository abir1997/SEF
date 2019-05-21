package model;

public class Product {

	private String productID;
	private int quantity;
	private double price;

	public Product(String productID, int quantity, double price) {
		this.productID = productID;
		this.quantity = quantity;
		this.price = price;
	}

	public String toString() {
		return String.format("Product : %s\nQuantity : %d\nPrice : %f", productID, quantity, price);
	}

	public String getProductID()
	{
		return productID;
	}

	public int getQuantity()
	{
		return quantity;
	}

	public double getPrice()
	{
		return price;
	}

	public void replenishQuantity(int quantity)
	{
	    this.quantity += quantity;

	}

	public void setProductID(String productID)
	{
		this.productID = productID;
	}

	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
		
	}

	public void setPrice(double price)
	{
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((productID == null) ? 0 : productID.hashCode());
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
		Product other = (Product) obj;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (productID == null) {
			if (other.productID != null)
				return false;
		} else if (!productID.equals(other.productID))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}
	
	
}
