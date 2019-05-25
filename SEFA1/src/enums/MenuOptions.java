package enums;


public enum MenuOptions {
	
	WM_ADD_PRODUCTS("Add Products", "1"),
	WM_LIST_PRODUCTS("List Products","2"),
	WM_REMOVE_PRODUCTS("Remove Products", "3"),
	WM_REPLENISH_PRODUCT_QUANTITY("Replenish Product Quantity","4"),
	WM_RETURN_TO_LOGIN_SCREEN("Return to Login Screen","5"),
	
	CM_PURCHASE_PRODUCT("Purchase Product", "1"),
	CM_LIST_PRODUCTS("List Products","2"),
	CM_CHECK_PRICE("Check Price", "3"),
	CM_CHECK_DISCOUNTS("Check Discounts", "4"),
	CM_RETURN_TO_LOGIN_SCREEN("Return to Login Screen","5");
	
	
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
