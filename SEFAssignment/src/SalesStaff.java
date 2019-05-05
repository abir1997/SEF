
public class SalesStaff extends User {


	String name;
	String email;
	String password;
	String phone;
	
	
	public SalesStaff(String name, String email, String password, String phone){
		super(name, email, password, phone);
	}
	
	public String getName(){
		return super.getEmail();
	}
	
	public String getEmail(){
		return super.getEmail();
	}
	
	public String getPassword(){
		return super.getPassword();
	}
	
	public String getPhone(){
		return super.getPhone();
	}
	
	public String getDetails() {
	return super.getDetails();
	}
	
	public String saveGetDetails() {
		String firstLine = name;
		String secondLine = email;
		String thirdLine = password;
		String fourthLine = phone;
		return ("SALESSTAFF" + ":" + super.saveGetDetails());
	}
	
	public boolean removeProduct(Customer customer, Product product){
		return customer.getSales().removeProduct(product);
	}
	
	public boolean removeProduct(Customer customer, Product product, int quantity){
		return customer.getSales().removeProduct(product, quantity);
	}
	
	public void cancelTransaction(Customer customer){
		customer.getSales().removeAllProduct();
	}
}
