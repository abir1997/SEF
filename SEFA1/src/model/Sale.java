package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import exception.ProductNotFoundException;

public class Sale {
//	private double pts;
	private LocalDateTime dateTime;
	private List<SalesLineItem> saleLineItems = new ArrayList<>();


	public double calcPts() {
		throw new RuntimeException("Not implemented");
	}

	public double calcTotal() {
		double total = 0;
		for	(SalesLineItem sli : saleLineItems) {
			total += sli.getProduct().getPrice() * sli.getQuantity(); 
		}
		return total;
	}

	public List<SalesLineItem> getSaleLineItems() {
		return Collections.unmodifiableList(saleLineItems);
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	
	public int checkQuantity(Product product) throws ProductNotFoundException {
		SalesLineItem sli = findSalesLineItem(product);
		if (sli == null) {
			return 0;
		}
		return sli.getQuantity();
	}

	public boolean removeProduct(Product product) {
		return saleLineItems.remove(product);
	}
	
	public void addToCart(Product product, int quantity) {
		SalesLineItem sli = findSalesLineItem(product);
		if (sli != null) {
			sli.addQuantity(quantity);
		} else {
			sli = new SalesLineItem(product, quantity);
			saleLineItems.add(sli);
		}
	}

	public void emptyCart() {
		saleLineItems.clear();
	}

	/**
	 * 
	 * @param product
	 * @return the matching SalesLineItem or null if not found
	 */
	private SalesLineItem findSalesLineItem(Product product) {
		for	(SalesLineItem sli : saleLineItems) {
			if (sli.getProduct().equals(product)) {
				return sli;
			}
		}
		return null;
	}
}
