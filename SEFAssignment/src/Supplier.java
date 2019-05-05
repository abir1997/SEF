import java.util.ArrayList;

public class Supplier {
	private String name;
	private String id;
	private String email;
	private String phone;
	private String address;
	private ArrayList<Supplier> suppliers;
	ArrayList<Product> products;
	
	public Supplier(String name, String id, String email, String phone, String address) {
		this.name = name;
		this.id = id;
		this.email = email;
		this.phone = phone;
		this.address = address;
		ArrayList<Product> products = new ArrayList<Product>();
	}
	
	//get methods
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
	public ArrayList<Supplier> getSuppliers() {
		return suppliers;
	}
	public ArrayList<Product> getProducts() {
		return products;
	}
	//set methods
	public void setName(String name) {
		this.name = name;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setAddress(String address) {
		this.address = address;;
	}
	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}
	public void setSuppliers(ArrayList<Supplier> suppliers) {
		this.suppliers = suppliers;
	}
	
	//method to print out Supplier details
	public String getDetails(Supplier supplier) {
		return name + ":" + id + ":" + email + "phone" + ":" + address + ":" + showProducts(supplier);
	}
	
	//method to add Suppliers to ArrayList, invokes constructor method
	public void addSupplier(String name, String id, String email, String phone, String address) {
		Supplier supplier = new Supplier(name, id, email, phone, address);
		getSuppliers().add(supplier);
	}
	
	//method to iterate through ArrayList
	public String showSuppliers() {
		String supplierList = "";
		for (int i = 0; i < getSuppliers().size(); i++) {
			supplierList += getSuppliers().get(i).toString();
		}
		return supplierList;
	}
	//method to get products that is supplied by a supplier object
	public String showProducts(Supplier supplier) {
		String productList = "";
		for (int i = 0; i < products.size(); i++) {
			productList += products.get(i).toString();
			productList += "/n";
		}
		return productList;
	}
	
	//method to add products to productList of a Supplier
	public void addProductList(Supplier supplier, String productID, int quantity, double price) {
		Product newProduct = new Product(productID, quantity, price);
		supplier.products.add(newProduct);
	}
	
	//method to show specific supplier, searches based on entered variables
	public String findSupplier(String name, String id, String email, String phone, String address) {
		String specificSupplier = "";
		System.out.println("Please enter one or more of the Supplier's details: name, id, email, phone, address");
		for (int i = 0; i < getSuppliers().size(); i++) {
			if (getSuppliers().get(i).getName() == name) {
				specificSupplier += getSuppliers().get(i).toString();
				break;
			}
			else if (getSuppliers().get(i).getId() == id) {
				specificSupplier += getSuppliers().get(i).toString();
				break;
			}
			else if (getSuppliers().get(i).getEmail() == email) {
				specificSupplier += getSuppliers().get(i).toString();
				break;
			}
			else if (getSuppliers().get(i).getPhone() == phone) {
				specificSupplier += getSuppliers().get(i).toString();
				break;
			}
			else if (getSuppliers().get(i).getAddress() == address) {
				specificSupplier += getSuppliers().get(i).toString();
				break;
			}
		}
		return specificSupplier;
	}
	
	//method to remove a supplier from ArrayList
	public void removeSupplier(String name, String id, String email, String phone, String address) {
		System.out.println("Please enter one or more of the Supplier's details: name, id, email, phone, address");
		for (int i = 0; i < getSuppliers().size(); i++) {
			if (getSuppliers().get(i).getName() == name) {
				getSuppliers().remove(i);
				break;
			}
			else if (getSuppliers().get(i).getId() == id) {
				getSuppliers().remove(i);
				break;
			}
			else if (getSuppliers().get(i).getEmail() == email) {
				getSuppliers().remove(i);
				break;
			}
			else if (getSuppliers().get(i).getPhone() == phone) {
				getSuppliers().remove(i);
				break;
			}
			else if (getSuppliers().get(i).getAddress() == address) {
				getSuppliers().remove(i);
				break;
			}
		}
	}
}
