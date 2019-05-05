
public class Manager extends User {


	String name;
	String email;
	String password;
	String phone;
	
	//constructor
	public Manager(String name, String email, String password, String phone)
	{
		super(name, email, password, phone);
	}
	//super get methods
	public String getName()
	{
		return super.getEmail();
	}
	
	public String getEmail()
	{
		return super.getEmail();
	}
	public String getPassword()
	{
		return super.getPassword();
	}
	public String getPhone()
	{
		return super.getPhone();
	}
	
	//super set methods
	public void setName(String name)
	{
		super.setName(name);
	}
	public void setEmail(String email)
	{
		super.setEmail(email);
	}
	public void setPassword(String password)
	{
		super.setPassword(password);
	}
	public void setPhone(String phone)
	{
		super.setPhone(phone);
	}
	
	//method to return details of the Manager class
	public String getDetails() {
		return super.getDetails();
	}
	
	//method to save the contents of name, email, password, phone to string
	public String saveGetDetails() {
		String firstLine = name;
		String secondLine = email;
		String thirdLine = password;
		String fourthLine = phone;

		return ("MANAGER" + ":" + super.saveGetDetails());
	}
	

	//method to replenish a product quantity (1)
	public void replenishProductQuantity(Product product, int quantity) {
		product.replenishQuantity(quantity);
	}
	
	//method to list supplier details (2)
	public String listSupplierDetails(Supplier supplier) {
		String details = "";
		for (int i = 0; i < supplier.getSuppliers().size(); i++) {
			details += supplier.getSuppliers().get(i).getDetails(supplier);
			details += "/n";
		}
		
		return details;
	}
	//method to override standard price on specific product (3)
	public void changeStandardPrice(Product product, double price) {
		product.setPrice(price);
	}
	//method to offer specific discount percentages (4)
	public void offerDiscount(Product product, double percentage, double price) {
	int check = 0;
	do {
		System.out.println("Please enter a percentage amount to set the discount to:"
				+ "\n" + "15%"
				+ "\n" + "20%"
				+ "\n" + "Custom Discount");
		if (percentage > 100 || percentage < 0) {
			System.out.println("Error: Percentage is not valid amount");
			continue;
		}
		else {
			System.out.println("You have selected: " + percentage + "% discount.");
		}
		 product.setPrice(price * ((100 - percentage)/100));
		check++;
	}
	while (check < 1);
	}
	//method to generate a sales report (5)
	public double generateSalesReport(SalesLineItem item) {
		return item.getSubtotal();
	}

	//method to generate a supply report, print out all suppliers and their items (6)
	public String generateSupplyReport(Sales s) {
		return s.getAllProducts().toString();
	}

	//method to list top products by price from a supplier (7)
	public String listProducts(Supplier supplier) {
		String listedProducts = "";
		for (int i = 0; i < supplier.products.size(); i++) {
			listedProducts += supplier.products.get(i);
		}
		return listedProducts;
	}


}
