package enums;


public enum WarehouseStaffMenu {
	
	ADD_PRODUCTS("Add Products", "1"),
	LIST_PRODUCTS("List Products","2"),
	REMOVE_PRODUCTS("Remove Products", "3"),
	REPLENISH_PRODUCT_QUANTITY("Replenish Product Quantity","4"),
	RETURN_TO_LOGIN_SCREEN("Return to Login Screen","5");
	
	private String txt;
	private String key;
	
	WarehouseStaffMenu (String txt, String key) {
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
