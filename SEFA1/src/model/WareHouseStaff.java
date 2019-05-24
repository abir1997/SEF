package model;

import java.util.Map;

import dataAccess.ProductDataAccess;

public class WareHouseStaff extends User{

	public WareHouseStaff(String name, int id, String pwd) {
		super(name, id, pwd);
	}

	public void addProduct(Product product) {
		ProductDataAccess.products.put(product.getProductID(), product);
	}



}
