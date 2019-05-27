package main;

import enums.DataStoreMode;

public class Const {

	//Select between the default source of Data (FILE) and the mock version 
	// of it loading hard coded mock values for testing and validations.
	public static final DataStoreMode DATA_STORE_MODE =  DataStoreMode.FILE;
	
	public static final int DOLLARS_FOR_A_POINT = 10;
	public static final int BASE_POINTS_DISCOUNT_DIV = 20;
	public static final int DISCOUNT_AMOUNT_FOR_POINTS = 5;
	
	//how many days the report goes back to. Default, 14 days, 2 weeks
	public static final int TOP_SELLING_REPORT_DAYS = 14;
	
	//how many products to be displayed as top selling
	public static final int TOP_SELLING_REPORT_NUMBER = 10;
}
