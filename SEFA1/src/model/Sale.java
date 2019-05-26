package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import exception.ProductNotFoundException;
import main.Const;

public class Sale implements Serializable {
	
	private static final long serialVersionUID = 2479689347021814758L;
	
	private LocalDateTime dateTime;
	private Set<SalesLineItem> saleLineItems = new HashSet<SalesLineItem>();
	private double totalPaid;


	public boolean contains (Product product) {
		for (SalesLineItem sli : saleLineItems) {
			if (sli.getProduct().equals(product)) {
				return true;
			}
		}
		return false;
	}
	
	
	public double getTotalPaid() {
		return totalPaid;
	}

	public void setTotalPaid(double totalPaid) {
		this.totalPaid = totalPaid;
	}

	/**
	 * @return points for total cost
	 */
	public int calcPts() {
		return (int) (calcTotalBaseCost() / Const.DOLLARS_FOR_A_POINT);
	}

	/**
	 * @return the combined base cost of all items  
	 */
	public double calcTotalBaseCost() {
		double total = 0;
		for	(SalesLineItem sli : saleLineItems) {
			total += sli.getProduct().getPrice() * sli.getQuantity(); 
		}
		return total;
	}

//	/**
//	 * @return the total amount to be charged to the customer
//	 */
//	public double calcCheckoutCost() {
//		//TODO account for discount
//		double baseTotal = calcTotalBaseCost();
//		double newPts = calcPts();
//		// If base cost > $5 and 20 pts in card give discount.
//		if(baseTotal > 5 && newPts>Const.BASE_POINTS_DISCOUNT_DIV) {
//			
//		}
//		
//		double total = baseTotal - (((int)(newPts / Const.BASE_POINTS_DISCOUNT_DIV))* Const.DISCOUNT_AMOUNT_FOR_POINTS );
//
//		return total;
//	}

	public Set<SalesLineItem> getSaleLineItems() {
		return saleLineItems;
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
		SalesLineItem sli = findSalesLineItem(product);
		return saleLineItems.remove(sli);
	}
	
	public boolean decreaseProduct(Product product,int qty) {
		SalesLineItem sli = findSalesLineItem(product);
		if(sli != null) {
		sli.setQuantity(qty);
		return true;
		}else {
			System.out.println("Product Not found");
			return false;
		}
	}
	

	public int totalItems() {
		int counter = 0;
		for(SalesLineItem sli : saleLineItems) {
			if(sli != null) {
				counter += sli.getQuantity();
			}
		}
		return counter;
	}
	public void removeAllProducts() {
		saleLineItems.clear();
	}

	/**
	 * 
	 * @param product
	 * @return the matching SalesLineItem or null if not found
	 */
	public SalesLineItem findSalesLineItem(Product product) {
		for	(SalesLineItem sli : saleLineItems) {
			if (sli.getProduct().equals(product)) {
				return sli;
			}
		}
		return null;
	}
	
}
