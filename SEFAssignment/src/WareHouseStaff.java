import java.util.ArrayList;


public class WareHouseStaff extends User {

	String name;
	String email;
	String password;
	String phone;

	
	
	public WareHouseStaff(String name, String email, String password, String phone)
	{
		super(name, email, password, phone);
	}
	
	public String getName()
	{
		return super.getName();
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
	
	public void  setName(String name)
	{
		super.name = name;
	}
	
	
	
	public String getDetails() {

	return super.getDetails();

	}
	
public String saveGetDetails() {
		String firstLine = name;
		String secondLine = email;
		String thirdLine = password;
		String fourthLine = phone;


		return ("WAREHOUSESTAFF" + ":" + super.saveGetDetails());
	}
	
    
public void replenishQuantity(Product product, int quantity) {
	product.replenishQuantity(quantity);
}

public void listProductInformation() {

	System.out.println("\n------------------------------------------------------------------------");
	System.out.println("*** LIST OF PRODUCTS INFORMATION ***");
	System.out.println("------------------------------------------------------------------------\n");

	for (int i = 0; i < SuperMarketSystem.products.size(); i++) {
		System.out.println(SuperMarketSystem.products.get(i).getDetails());
	}

}
   
  
   
   public void addProduct(Product product) {
       SuperMarketSystem.products.add(product);
   }
   
   public boolean removeProduct(Product product) {
       if( SuperMarketSystem.products.contains(product)){
           SuperMarketSystem.products.remove(product);
           return true;
       }
       return false;
   }
   


   
   public ArrayList<Product> getProducts() {
       return SuperMarketSystem.products;
   }
}
