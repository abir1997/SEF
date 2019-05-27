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
	//public Product(String productId, String name, int warehouseQty, int replenishLevel, int orderQty, double price) 
	private Product p0 = new Product("p"+pId++, "Lemonade", 500, 200, 100, 5);
	private Product p1 = new Product("p"+pId++, "Coke", 500, 200, 100, 5);
	private Product p2 = new Product("p"+pId++, "Pepsi", 300, 200, 100, 4);
	private Product p3 = new Product("p"+pId++, "Plates", 1500, 400, 200, 2);
	private Product p4 = new Product("p"+pId++, "Spoons", 3000, 600, 300, 1);
	private Product p5 = new Product("p"+pId++, "Curtain", 500, 10, 20, 200);
	private Product p6 = new Product("p"+pId++, "Milk", 500, 100, 200, 2);
	private Product p7 = new Product("p"+pId++, "Chips", 300, 60, 30, 3);
	private Product p8 = new Product("p"+pId++, "Gold", 100, 20, 50, 5000);
	private Product p9 = new Product("p"+pId++, "Gum", 300, 60, 30, 1);
	private Product p10 = new Product("p"+pId++, "Shampoo", 300, 60, 300, 9);
	private Product p11 = new Product("p"+pId++, "Soap", 300, 60, 30, 1);
	private Product p12 = new Product("p"+pId++, "Bread", 300, 60, 30, 2);
	
		
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
		
		u = new Customer("Wealthy", id++, "pass", new CustomerCard(0, "123"+id));
		UserDataAccess.users.put(u.getId(), u);
		c = (Customer) u;
		c.addToCart(p1, 1);
		c.addToCart(p2, 1);
		c.addToCart(p3, 1);
		c.addToCart(p4, 1000);
		c.addToCart(p5, 1);
		c.addToCart(p6, 1);
		c.addToCart(p7, 1);
		c.addToCart(p8, 1);
		c.addToCart(p9, 2);
		c.addToCart(p10, 1);
		c.addToCart(p11, 1);
		c.addToCart(p12, 1);
		c.checkout();
		c.addToCart(p1, 1);
		c.addToCart(p2, 1);
		c.addToCart(p3, 1);
		c.addToCart(p4, 1000);
		c.addToCart(p5, 1);
		c.addToCart(p6, 1);
		c.addToCart(p7, 1);
		c.addToCart(p8, 11);
		c.addToCart(p9, 2);
		c.addToCart(p10, 1);
		c.addToCart(p11, 1);
		c.addToCart(p12, 1);
		System.out.println("\n----------" + c.getCard().getLoyaltyPts());
//		c.getCard().addLoyaltyPts(30);
		
		
		System.out.println("\n\n********  MOCK: USERS added 	********* ");
		for (User user: UserDataAccess.getUsers()) {
			System.out.println(user);
		}
	}
	
	private void loadProductData() {
		ProductDataAccess.products.put(p0.getProductId(), p0);
		ProductDataAccess.products.put(p1.getProductId(), p1);
		ProductDataAccess.products.put(p2.getProductId(), p2);
		ProductDataAccess.products.put(p3.getProductId(), p3);
		ProductDataAccess.products.put(p4.getProductId(), p4);
		ProductDataAccess.products.put(p5.getProductId(), p5);
		ProductDataAccess.products.put(p6.getProductId(), p6);
		ProductDataAccess.products.put(p7.getProductId(), p7);
		ProductDataAccess.products.put(p8.getProductId(), p8);
		p8.addDiscount(20, 12);
		p8.addDiscount(5, 5);
		p8.addDiscount(10, 10);
		p8.addDiscount(30, 30);
		p8.addDiscount(8, 8);
		
		ProductDataAccess.products.put(p9.getProductId(), p9);
		ProductDataAccess.products.put(p10.getProductId(), p10);
		ProductDataAccess.products.put(p11.getProductId(), p11);
		ProductDataAccess.products.put(p12.getProductId(), p12);
		
		System.out.println("\n\n********  MOCK: PRODUCTS added 	********* ");
		for (Product product: ProductDataAccess.getAllProducts()) {
			System.out.println(product);
			System.out.println();
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
