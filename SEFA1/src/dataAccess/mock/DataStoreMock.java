package dataAccess.mock;

import dataAccess.DataStoreInterface;
import dataAccess.ProductDataAccess;
import dataAccess.SupplierDataAccess;
import dataAccess.UserDataAccess;
import model.Customer;
import model.CustomerCard;
import model.Manager;
import model.Product;
import model.SalesStaff;
import model.Supplier;
import model.User;
import model.WareHouseStaff;

public class DataStoreMock implements DataStoreInterface {

	@Override
	public void saveData() {
		// TODO Auto-generated method stub
	}

	@Override
	public void loadData() {
		loadProductData();
		loadSupplierData();
		loadUserData();
	}
	
	private int pId = 0;
	private Product p1 = new Product("Coke1", "p"+pId++, 500, 200, 100, 5);
	private Product p2 = new Product("Pepsi", "p"+pId++, 300, 200, 100, 4);
	private Product p3 = new Product("Plates", "p"+pId++, 1500, 400, 200, 2);
		
	private void loadUserData() {
		int id = 0;
		User u = new Manager("Charles", id++, "pass");
		UserDataAccess.users.put(u.getId(), u);
		
		u = new WareHouseStaff("Mate", id++, "pass");
		UserDataAccess.users.put(u.getId(), u);

		u = new SalesStaff("Mate", id++, "pass");
		UserDataAccess.users.put(u.getId(), u);

		u = new Customer("Johny", id++, "pass", new CustomerCard(0, "123"+id));
		UserDataAccess.users.put(u.getId(), u);
		
		u = new Customer("Kiddy", id++, "pass", new CustomerCard(0, "123"+id));
		UserDataAccess.users.put(u.getId(), u);
		
		Customer c = (Customer) u;
		c.addToCart(p1, 5);
		c.addToCart(p2, 20);
		c.checkout();
		c.addToCart(p3, 10);
		
		System.out.println("\n\n********  MOCK: USERS added 	********* ");
		for (User user: UserDataAccess.getUsers()) {
			System.out.println(user);
		}
	}
	
	private void loadProductData() {
		ProductDataAccess.products.put(p1.getProductId(), p1);
		ProductDataAccess.products.put(p2.getProductId(), p2);
		
		System.out.println("\n\n********  MOCK: PRODUCTS added 	********* ");
		for (Product product: ProductDataAccess.getAllProducts()) {
			System.out.println(product);
		}

	}

	private void loadSupplierData() {
		int id = 0;
		Supplier s = new Supplier("SAM", "S"+id++, "Email@sam.com", "0412314444", "124 a st, 2000");
		SupplierDataAccess.suppliers.put(s.getId(), s);
		s.getProducts().add(p1);
		s.getProducts().add(p2);
		
		s = new Supplier("JON", "S"+id++, "Email@jon.com", "0412312312", "2 b st, 3000");
		SupplierDataAccess.suppliers.put(s.getId(), s);
		s.getProducts().add(p3);
		
		System.out.println("\n\n********  MOCK: SUPPLIERS added 	********* ");
		for (Supplier supplier: SupplierDataAccess.getSuppliers()) {
			System.out.println(supplier);
		}

	}

}
