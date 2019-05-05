
public class User{
	String name;
	String email;
	String password;
	String phone;
	
	//constructor
	public User(String name, String email, String password, String phone)
	{
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		
	}
	
	//get methods
	public String getName()
	{
		return this.name;
	}
	
	public String getEmail()
	{
		return this.email;
	}
	public String getPassword()
	{
		return this.password;
	}
	public String getPhone()
	{
		return this.phone;
	}
	
	//set methods
	public void setName(String name)
	{
		this.name = name;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	
	//method to return details of user in string format
	public String getDetails() {

	    String firstLine = String.format("%-20s %s\n", "Name", name);
	    String secondLine = String.format("%-20s %s\n", "Email", email);
	    String thirdLine = String.format("%-20s %s\n", "Password:", password);
	    String fourthLine = String.format("%-20s %s\n", "Phone:", phone);


	    return (firstLine + secondLine + thirdLine + fourthLine);

	}
	
	//method that returns formatted string, with each line denoted by :
	public String saveGetDetails() {
		String firstLine = name;
		String secondLine = email;
		String thirdLine = password;
		String fourthLine = phone;


		return (firstLine + ":" + secondLine + ":" + thirdLine + ":" + fourthLine);
	}
	
	

}
