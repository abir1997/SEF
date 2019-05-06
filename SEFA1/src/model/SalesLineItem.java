package model;

public class SalesLineItem {
	private int quantity;
	private Product product;
	
	public SalesLineItem(Product product,int quantity){
		this.product=product;
		this.quantity=quantity;
	}
	//get method
	public int getQuantity(){
		return quantity;
	}
	//set method
	public void setQuantity(int quantity){
		this.quantity = quantity;
	}
	//method to increase quantity
	public void addQuantity(){
		quantity++;
	}
	
	public void addQuantity(int quantity){
		this.quantity += quantity;
	}
	
	public Product getProduct(){
		return product;
	}
	
	public void setProduct(Product product){
		this.product = product;
	}
	
	public double getSubtotal(){
		return product.getPrice() * quantity;
}
	
}
