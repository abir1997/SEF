package model;

import java.io.Serializable;

public class SalesLineItem implements Serializable{
	
	private static final long serialVersionUID = -1590511947713463343L;
	
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((product == null) ? 0 : product.hashCode());
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
		SalesLineItem other = (SalesLineItem) obj;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}
	
	
}
