package dataAccess;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class DataStore implements DataStoreInterface{
	
	private static void saveMapData(Map map,String fName) {
		try {
			FileOutputStream fos = new FileOutputStream(fName);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(map);
			System.out.printf("Serialized HashMap data is saved in %s",fName);
            oos.close();
            fos.close();
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	private static void loadMapData(Map map,String loadFile) {
		map = null;
		try {
			FileInputStream fis = new FileInputStream(loadFile);
			ObjectInputStream ois = new ObjectInputStream(fis);
			map = (Map) ois.readObject();
			ois.close();
			fis.close();
		}catch(IOException ioe) {
			ioe.printStackTrace();
			return;
		}catch(ClassNotFoundException c) {
			c.printStackTrace();
			return;
		}
		System.out.printf("Deserialized map %s\n", loadFile);
		Set set = map.entrySet();
		Iterator iterator = set.iterator();
		while(iterator.hasNext()) {
			Map.Entry entry = (Map.Entry)iterator.next();
			System.out.println("key : "+entry.getKey() + " & value : "+entry.getValue());
		}
		
	}
	
	private static void saveProductData() {
		saveMapData(ProductDataAccess.products,"products.ser");
	}

	private static void saveUserData() {
		saveMapData(UserDataAccess.users,"users.ser");
	}

	private static void saveSupplierData() {
		saveMapData(SupplierDataAccess.suppliers,"suppliers.ser");
	}
	
	/**
	 * Saves all the data
	 */
	public void saveData() {
		saveSupplierData();
		saveProductData();
		saveUserData();
	}

	
	private static void loadProductData() {
		loadMapData(ProductDataAccess.products,"products.ser");
	}

	private static void loadUserData() {
		loadMapData(UserDataAccess.users,"users.ser");
	}

	private static void loadSupplierData() {
		loadMapData(SupplierDataAccess.suppliers,"suppliers.ser");
	}
	
	/**
	 * loads all the data
	 */
	public void loadData() {
		loadSupplierData();
		loadProductData();
		loadUserData();
	}

}
