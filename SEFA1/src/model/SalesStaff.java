package model;

public class SalesStaff extends User {

	public SalesStaff(String name, int id, String pwd) {
		super(name, id, pwd);
	}

	public boolean removeProduct(Customer customer, Product product) {
		return customer.getSales().removeProduct(product);
	}

	public boolean removeProduct(Customer customer, Product product, int quantity) {
		return customer.getSales().removeProduct(product, quantity);
	}

	public void cancelTransaction(Customer customer) {
		customer.getSales().removeAllProduct();
	}

}
