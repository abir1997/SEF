//Peter Class
public class Product {

String productID;
int quantity;
double weight;
double price;

public Product(String productID, int quantity, double price)
{
	this.productID = productID;
	this.quantity = quantity;
	this.price = price;
}

public String getDetails() {

    String firstLine = String.format("%-20s %s\n", "Product ID:", productID);
    String secondLine = String.format("%-20s %s\n", "Quantity:", quantity);
    String thirdLine = String.format("%-20s %s\n", "Price:", price);


    return (firstLine + secondLine + thirdLine);

}

public String saveGetDetails() {
	String firstLine = productID;
	int secondLine = quantity;
	double thirdLine = price;


	return ("PRODUCT" + ":" + firstLine + ":" + secondLine + ":" + thirdLine);
}




public String getProductID()
{
	return productID;
}

public int getQuantity()
{
	return quantity;
}

public double getPrice()
{
	return price;
}

public void replenishQuantity(int quantity)
{
    this.quantity += quantity;

}

public void setProductID(String productID)
{
	this.productID = productID;
}

public void setQuantity(int quantity)
{
	this.quantity = quantity;
	
}

public void setPrice(double price)
{
	this.price = price;
}

public void ToString(){
	System.out.printf( getProductID());
	System.out.printf( "the quantity is" + Integer.toString(getQuantity()));
	System.out.printf( "the Price is"+ Double.toString(getPrice()));
	
}

}
