package model;

import java.util.ArrayList;

public class Supplier {
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
}
