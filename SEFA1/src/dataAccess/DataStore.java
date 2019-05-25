package dataAccess;

public class DataStore {
	private static void saveProductData() {
		// TODO Auto-generated method stub

	}

	private static void saveUserData() {
		// TODO Auto-generated method stub

	}

	private static void saveSupplierData() {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Saves all the data
	 */
	public static void saveData() {
		saveSupplierData();
		saveProductData();
		saveUserData();
	}

	
	private static void loadProductData() {
		// TODO Auto-generated method stub

	}

	private static void loadUserData() {
		// TODO Auto-generated method stub

	}

	private static void loadSupplierData() {
		// TODO Auto-generated method stub

	}
	
	/**
	 * loads all the data
	 */
	public static void loadData() {
		loadSupplierData();
		loadProductData();
		loadUserData();
	}

}
