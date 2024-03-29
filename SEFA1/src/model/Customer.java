package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dataAccess.ProductDataAccess;
import exception.ProductNotFoundException;
import main.Const;

public class Customer extends User {

	private static final long serialVersionUID = 6395386684232462670L;

	private CustomerCard card;
	private List<Sale> previousSales = new ArrayList<Sale>();
	private Sale cart;
	private String postCode;

	public Customer(String name, int id, String pwd, CustomerCard card) {
		super(name, id, pwd);
		this.card = card;
		cart = new Sale();
	}

	public Sale getCart() {
		return cart;
	}

	public CustomerCard getCard() {
		return card;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	private void consumeFromStock() {
		for (SalesLineItem sli : cart.getSaleLineItems()) {
			ProductDataAccess.consumeProduct(sli.getProductId(),sli.getQuantity());
		}
	}

	public double checkout() {
		
		double baseCost = cart.calcTotalBaseCost();
		System.out.printf("Total undiscounted cost : $%7.2f\n", baseCost);
		
		double bulkDiscountedCost = cart.calcTotalBaseCostWithDiscount();
		System.out.printf("Total bulk discounted cost : $%7.2f\n", bulkDiscountedCost);
		
		double currentLoyaltyPts = card.getLoyaltyPts();

		cart.setDateTime(LocalDateTime.now());
		previousSales.add(cart);

		double finalCost = bulkDiscountedCost;
		if (bulkDiscountedCost > Const.DISCOUNT_AMOUNT_FOR_POINTS &&
			card.getLoyaltyPts() > Const.BASE_POINTS_DISCOUNT_DIV) {
			
			double n = bulkDiscountedCost / Const.BASE_POINTS_DISCOUNT_DIV;
			double discount = Const.DISCOUNT_AMOUNT_FOR_POINTS * n;
			if(discount < finalCost) {
			finalCost -= discount;
			}
			System.out.printf("Discount applied : $%7.2f\n", discount);
			card.deductLoyaltyPoints(currentLoyaltyPts);
			System.out.printf("%7.0f loyalty points used up!\n", currentLoyaltyPts);
		}
		cart.setTotalPaid(finalCost);
		int pts = cart.calcPts();
		card.addLoyaltyPts(pts);
		consumeFromStock();
		cart = new Sale();
		return finalCost;
	}


	// If product already exists - > add it
	public boolean addToCart(String productID, int qty) {
		Product product;
		try {
			product = ProductDataAccess.getProduct(productID);
			if (product.getWarehouseQuantity() < qty) {
				return false;
			}
			addToCart(product, qty);
			return true;
		} catch (ProductNotFoundException e) {
			return false;
		}
	}
	
	public void addToCart(Product product, int quantity) {
		if (cart == null) {
			cart = new Sale();
		}
		SalesLineItem sli = cart.findSalesLineItem(product);
		if (sli != null) {
			sli.addQuantity(quantity);
		} else {
			sli = new SalesLineItem(product, quantity);
			cart.getSaleLineItems().add(sli);
		}
	}

	public void emptyCart() {
		cart.getSaleLineItems().clear();
	}


	public List<Sale> getPreviousSales() {
		return previousSales;
	}

}
