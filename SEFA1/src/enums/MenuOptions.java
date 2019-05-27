package enums;


public enum MenuOptions {
	
	WM_LIST_PRODUCTS("List Products","1"),
	WM_REPLENISH_PRODUCT_QUANTITY("Replenish Product Quantity","2"),
	WM_RETURN_TO_LOGIN_SCREEN("Return to Login Screen","3"),
	
	CM_PURCHASE_PRODUCT("Purchase Product", "1"),
	CM_LIST_PRODUCTS("List Products","2"),
	CM_CHECK_PRICE("Check Price", "3"),
	CM_CHECK_DISCOUNTS("Check Discounts", "4"),
	CM_CHECKOUT("Checkout", "5"),
	CM_RETURN_TO_LOGIN_SCREEN("Return to Login Screen","6"),

	MM_LIST_PRODCUT("List Prodcut", "1"),
	MM_ADD_PRODUCT("Add Product", "2"),
	MM_UPDATE_PRODUCT("Update Product", "3"),
	MM_REMOVE_PRODUCT("Remove Product", "4"),
	MM_REPLENISH_PRODUCT_QUANTITY("Replenish Product Quantity", "5"),
	MM_LIST_SUPPLIER_DETAILS("List Supplier Details", "6"),
	MM_OFFER_DISCOUNTS("Offer Bulk Discounts", "7"),
	MM_AUTO_REPLENISH_PURCHASE_ORDER("Place purchase orderfor all items below replenishment level", "8"),
	MM_GENERATE_SALES_REPORT("Generate Sales Report", "9"),
	MM_GENERATE_SUPPLY_REPORT("Generate Supply Report", "10"),
	MM_LIST_TOP_PRODUCTS("List Top Products", "11"),
	MM_REPORT_FAST_SELLING_PRODUCTS("Report Fast Selling Products", "12"),
	MM_RETURN_TO_LOGIN_SCREEN("Return to Login Screen", "13");

	
	private String txt;
	private String key;
	
	MenuOptions (String txt, String key) {
		this.txt = txt;
		this.key= key;
	}
	public String getTxt() {
		return txt;
	}

	public String getKey() {
		return key;
	}
	
}
