package system;

import java.util.Map;

import dataAccess.ProductDataAccess;
import model.Customer;
import model.Product;
import model.SalesLineItem;
import model.Supplier;

public class SystemController {
	public void replenishProductQuantity(Product product, int quantity) {
		product.replenishQuantity(quantity);
	}

	public static boolean removeProduct(Customer customer, Product product, int quantity) {
		//TODO remove method and use one from customer to remove a prodcut from cart
		throw new RuntimeException("Not implemented");
		
//		SalesLineItem salesLineItemRemove = null;
//		boolean isRemoved = false; 
//		for (SalesLineItem item : customer.getSale().getSaleLineItems()) {
//			if (item.getProduct().equals(product)) {
//				if (item.getQuantity() == quantity) {
//					salesLineItemRemove = item;
//					break;
//				}
//				else if (item.getQuantity() < quantity) {
//					break;	
//				}
//					
//				else {
//					item.setQuantity(item.getQuantity() - quantity);
//					isRemoved = true;
//				}
//			}
//		}
//		
//		if (salesLineItemRemove != null) {
//			customer.getSale().getSaleLineItems().remove(salesLineItemRemove);
//			isRemoved = true;
//		}
//		return isRemoved;
	}
	

	//from Supplier
	// method to add Suppliers to ArrayList, invokes constructor method
	public void addSupplier(String name, String id, String email, String phone, String address) {
		Supplier supplier = new Supplier(name, id, email, phone, address);
	}
	
	// method to add products to productList of a Supplier
	public void addProductList(Supplier supplier, String productID, int quantity, double price) {
		Product newProduct = new Product(productID, quantity, price);
		supplier.getProducts().add(newProduct);
	}
//	// method to show specific supplier, searches based on entered variables
//	public String findSupplier(String name, String id, String email, String phone, String address) {
//		String specificSupplier = "";
//		System.out.println("Please enter one or more of the Supplier's details: name, id, email, phone, address");
//		for (int i = 0; i < DataAccess.getSuppliers().size(); i++) {
//			if (DataAccess.getSuppliers().get(i).getName() == name) {
//				specificSupplier += DataAccess.getSuppliers().get(i).toString();
//				break;
//			} else if (DataAccess.getSuppliers().get(i).getId() == id) {
//				specificSupplier += DataAccess.getSuppliers().get(i).toString();
//				break;
//			} else if (DataAccess.getSuppliers().get(i).getEmail() == email) {
//				specificSupplier += DataAccess.getSuppliers().get(i).toString();
//				break;
//			} else if (DataAccess.getSuppliers().get(i).getPhone() == phone) {
//				specificSupplier += DataAccess.getSuppliers().get(i).toString();
//				break;
//			} else if (DataAccess.getSuppliers().get(i).getAddress() == address) {
//				specificSupplier += DataAccess.getSuppliers().get(i).toString();
//				break;
//			}
//		}
//		return specificSupplier;
//	}

//	// method to remove a supplier from ArrayList
//	public void removeSupplier(String name, String id, String email, String phone, String address) {
//		System.out.println("Please enter one or more of the Supplier's details: name, id, email, phone, address");
//		for (int i = 0; i < getSuppliers().size(); i++) {
//			if (getSuppliers().get(i).getName() == name) {
//				getSuppliers().remove(i);
//				break;
//			} else if (getSuppliers().get(i).getId() == id) {
//				getSuppliers().remove(i);
//				break;
//			} else if (getSuppliers().get(i).getEmail() == email) {
//				getSuppliers().remove(i);
//				break;
//			} else if (getSuppliers().get(i).getPhone() == phone) {
//				getSuppliers().remove(i);
//				break;
//			} else if (getSuppliers().get(i).getAddress() == address) {
//				getSuppliers().remove(i);
//				break;
//			}
//		}
//	}
	//from Supplier - end

	//warehouse
	public void replenishQuantity(Product product, int quantity) {
		product.replenishQuantity(quantity);
	}

	public void removeProduct(Product product) {
		if(ProductDataAccess.products.containsValue(product)) {
			ProductDataAccess.products.remove(product.getProductID());
		}
	}
	
	//warehouse - end
}
