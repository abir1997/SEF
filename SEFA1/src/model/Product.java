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
}
