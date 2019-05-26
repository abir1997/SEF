package model;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Supplier implements Serializable {
	private String name;
	private String id;
	private String email;
	private String phone;
	private String address;
	ArrayList<Product> products;

	public Supplier(String name, String id, String email, String phone, String address) {
		this.name = name;
		this.id = id;
		this.email = email;
		this.phone = phone;
		this.address = address;
		products = new ArrayList<Product>();
	}
	public void updatedSupplier (String name, String email, String phone, String address) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Supplier [name=" + name + ", id=" + id + ", email=" + email + ", phone=" + phone + ", address="
				+ address + ", products=" + productsSummaryStr() + "]";
	}
	
	public String productsSummaryStr() {
		StringBuffer sb = new StringBuffer();
		for (Product prd : products) {
			sb.append(prd.getProductId() + ", ");
		}
		return sb.toString();
	}
	
	// get methods
	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}

	public ArrayList<Product> getProducts() {
		return products;
	}


	// method to print out Supplier details
	public String getDetails(boolean includeProducts) {
		return id + ":" + name  + ":" + email + ":" + phone + ":" + address + (includeProducts ? "" : (":" + productsToStr()));
	}

	// method to get products that is supplied by a supplier object
	public String productsToStr() {
		String productList = "";
		for (Product product : products) {
			productList += product.toString();
			productList += "/n";
		}
		return productList;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Supplier other = (Supplier) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
