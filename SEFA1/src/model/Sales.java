package model;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;

import menu.SuperMarketSystem;

public class Sales {
	private double pts;
	private double total;
	private ArrayList<SalesLineItem> products = new ArrayList<>();

	public void claimPts(CustomerCard card) {
		double points;
		points = this.pts;
		this.pts = 0;
		card.addLoyaltyPts(points);
	}

	public double getPts() {
		return pts;
	}

	public boolean makePayment(double amount) {

		if (checkStock())
			updateStock();
		else
			return false;

		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.CEILING);

		pts += Double.parseDouble(df.format(amount * 0.1));
		return true;
	}

	private void updateStock() {
		for (SalesLineItem product : products) {
			for (Map.Entry<String, Product> entry : SuperMarketSystem.products.entrySet()) {
				if (product.getProduct().equals(entry.getValue())) {
					entry.getValue().setQuantity(entry.getValue().getQuantity() - product.getQuantity());
					break;
				}

			}
		}
	}

	private boolean checkStock() {
		for (SalesLineItem product : products) {
			for (Map.Entry<String, Product> item : SuperMarketSystem.products.entrySet()) {
				if (product.getProduct().equals(item.getValue())) {
					if (product.getQuantity() <= item.getValue().getQuantity())
						return true;
					else
						return false;
				}
			}
		}
		return false;
	}

	public Collection<SalesLineItem> getAllProducts() {
		return Collections.unmodifiableList(products);
	}

	public boolean removeProduct(Product product) {
		for (SalesLineItem item : products) {
			if (item.getProduct().equals(product)) {
				if (item.getQuantity() == 1)
					products.remove(item);
				else
					item.setQuantity(item.getQuantity() - 1);
				updateTotal();
				return true;
			}
		}
		return false;
	}

	public boolean removeProduct(Product product, int quantity) {
		for (SalesLineItem item : products) {
			if (item.getProduct().equals(product)) {
				if (item.getQuantity() == quantity)
					products.remove(item);
				else if (item.getQuantity() < quantity)
					return false;
				else
					item.setQuantity(item.getQuantity() - quantity);
				updateTotal();
				return true;
			}
		}
		return false;
	}

	private void updateTotal() {
		double subTotal = 0;

		for (SalesLineItem product : products) {
			subTotal += product.getSubtotal();
		}

		total = subTotal;
	}

	public int checkQuantity(Product product) {
		for (SalesLineItem item : products) {
			if (item.getProduct().equals(product)) {
				return item.getQuantity();
			}
		}
		return 0;
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

	public double getTotal() {
		return total;
	}

	public void deduct(int discount) {
		total -= discount;
	}
	
	public void discount(int percentage){
		total *= ((double)100 - percentage) / 100;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((products == null) ? 0 : products.hashCode());
		long temp;
		temp = Double.doubleToLongBits(pts);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(total);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sales other = (Sales) obj;
		if (products == null) {
			if (other.products != null)
				return false;
		} else if (!products.equals(other.products))
			return false;
		if (Double.doubleToLongBits(pts) != Double.doubleToLongBits(other.pts))
			return false;
		if (Double.doubleToLongBits(total) != Double.doubleToLongBits(other.total))
			return false;
		return true;
	}

}
