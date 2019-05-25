package system;

import dataAccess.ProductDataAccess;
import dataAccess.SupplierDataAccess;
import model.Product;
import model.Supplier;

public class SystemController {
	public void replenishProductQuantity(Product product, int quantity) {
		product.replenishQuantity(quantity);
	}

	//from Supplier
	// method to add Suppliers to ArrayList, invokes constructor method
	public void addSupplier(String id, String name, String email, String phone, String address) {
		Supplier supplier = new Supplier(name, id, email, phone, address);
		SupplierDataAccess.addSupplier(supplier);
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
