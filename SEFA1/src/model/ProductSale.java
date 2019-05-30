package model;

import java.util.Comparator;

/**
 * This class is used for Top selling report. This class should not be persisted but rather is used for report
 * generation as a transient convenient class that can be sorted easily and can hold aggregated information for total
 * value and volume of product sale.
 */
public class ProductSale {
	private Product product;
	private int totalVolume;
	private double totalValue;
	
	public ProductSale(Product product, int totalVolume, double totalValue) {
		this.product = product;
		this.totalVolume = totalVolume;
		this.totalValue = totalValue;
	}
	public Product getProduct() {
		return product;
	}
	public int getTotalVolume() {
		return totalVolume;
	}
	public double getTotalValue() {
		return totalValue;
	}
	
	
	public void addTotalVolume(int qty) {
		this.totalVolume += qty;
	}
	public void addTotalValue(double value) {
		this.totalValue += value;
	}
	

	//A comparator for this calss to sort based on totalVolume sale
	public static final Comparator<ProductSale> VOLUME_COMPARATOR = new Comparator<ProductSale>() {
		@Override
		public int compare(ProductSale ps0, ProductSale ps1) {
			
			return ps1.getTotalVolume() - ps0.getTotalVolume();
		}
	};

	//A comparator for this calss to sort based on totalValue sale
	public static final Comparator<ProductSale> VALUE_COMPARATOR = new Comparator<ProductSale>() {
		@Override
		public int compare(ProductSale ps0, ProductSale ps1) {
			
			return (int) (ps1.getTotalValue() - ps0.getTotalValue());
		}
	};

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((product == null) ? 0 : product.hashCode());
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
		ProductSale other = (ProductSale) obj;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		return true;
	}
	
	
}