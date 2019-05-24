package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Sale {
//	private double pts;
//	private double total;
	private LocalDateTime dateTime;
	private List<SalesLineItem> saleLineItems = new ArrayList<>();


	public double calcPts() {
		throw new RuntimeException("Not implemented");
	}

	public double calcTotal() {
		throw new RuntimeException("Not implemented");
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
	
	public int checkQuantity(Product product) {
		throw new RuntimeException("Not implemented");		
	}

	public boolean removeProduct(Product product, int parseInt) {
		throw new RuntimeException("Not implemented");
	}
}
