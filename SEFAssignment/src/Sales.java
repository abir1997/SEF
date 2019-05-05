import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Sales {
private double points;
private double total;
private ArrayList<SalesLineItem> products = new ArrayList<SalesLineItem>();

	
	public double getPoints(){
		return points;
	}
	
	public void claimPoints(CreditCard card){
		double points;
		points = this.points;
		this.points = 0;
		card.addLoyaltyPoints(points);
	}
	
	public boolean makePayment(double amount){
		
		if(checkStock())
			updateStock();
		else
			return false;
		
		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.CEILING);
		
		points += Double.parseDouble(df.format(amount * 0.1));
		return true;
	}
	
	public void discount(int percentage){
		total *= percentage / 100;
	}
	
	public void deduct(int discount){
		total -= discount;
	}
	
	public double getTotal(){
		return total;
	}
	
	public void updateTotal(){
		double subTotal = 0;
		
		for(SalesLineItem product : products){
			subTotal += product.getSubtotal();
		}
		
		total = subTotal;
	}
	
	public boolean checkStock(){
		for(SalesLineItem product : products){
			for(Product item : SuperMarketSystem.products){
				if(product.getProduct().equals(item)){
					if(product.getQuantity() <= item.getQuantity())
						return true;
					else
						return false;
				}
			}
		}
		return false;
	}
	
	public void updateStock(){
		for(SalesLineItem product : products){
			for(Product item : SuperMarketSystem.products){
				if(product.getProduct().equals(item)){
					item.setQuantity(item.getQuantity()-product.getQuantity());
					break;
				}
			}
		}
	}
	
	public boolean removeProduct(Product product){
		for(SalesLineItem item : products){
			if(item.getProduct().equals(product)){
				if(item.getQuantity() == 1)
					products.remove(item);
				else
					item.setQuantity(item.getQuantity()-1);
				updateTotal();
				return true;
			}
		}
		return false;
	}
	
	public boolean removeProduct(Product product, int quantity){
		for(SalesLineItem item : products){
			if(item.getProduct().equals(product)){
				if(item.getQuantity() == quantity)
					products.remove(item);
				else if(item.getQuantity() < quantity)
					return false;
				else
					item.setQuantity(item.getQuantity()-quantity);
				updateTotal();
				return true;
			}
		}
		return false;
	}
	
	public void removeAllProduct(){
		products.clear();
		updateTotal();
	}
	
	public void addProduct(Product product){
		for(SalesLineItem item : products){
			if(item.getProduct().equals(product)){
				products.get(products.indexOf(item)).addQuantity();
				updateTotal();
				return;
			}
		}
		products.add(new SalesLineItem(product, 1));
		updateTotal();
	}
	
	public void addProduct(Product product, int quantity){
		for(SalesLineItem item : products){
			if(item.getProduct().equals(product)){
				products.get(products.indexOf(item)).addQuantity(quantity);
				updateTotal();
				return;
			}
		}
		products.add(new SalesLineItem(product, quantity));
		updateTotal();
	}
	
	public int checkQuantity(Product product){
		for(SalesLineItem item : products){
			if(item.getProduct().equals(product)){
				return item.getQuantity();
			}
		}
		return 0;
	}
	
	public Collection<SalesLineItem> getAllProducts(){
		return Collections.unmodifiableList(products);
	}
	
}
