package model;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Sales {
	private double pts;
	private double total;
	private ArrayList<SalesLineItem> products = new ArrayList<>();
	
	public void claimPts(CustomerCard card) {
		double points;
		points = this.pts;
		this.pts=0;
		card.addLoyaltyPts(points);
	}
	
	public double getPts() {
		return pts;
	}
	
public boolean makePayment(double amount){
		
		if(checkStock())
			updateStock();
		else
			return false;
		
		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.CEILING);
		
		pts += Double.parseDouble(df.format(amount * 0.1));
		return true;
	}

private void updateStock() {
	// TODO Auto-generated method stub
	
}

private boolean checkStock() {
	// TODO Auto-generated method stub
	return false;
}
}
