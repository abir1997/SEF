package dataAccess;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

import exception.SupplierNotFoundException;
import model.Supplier;

public class SupplierDataAccess {

	public static HashMap<String, Supplier> suppliers = new HashMap<>();
	
	public static Collection<Supplier> getSuppliers() {
		return Collections.unmodifiableCollection(suppliers.values());
	}
	public static void addSupplier(Supplier supplier) {
		suppliers.put(supplier.getId(), supplier);
	}
	
	public static boolean removeSupplier(String id) {
		Supplier sup = suppliers.remove(id);
		return (sup != null )? true : false ;
	}

	public static Supplier getSupplier(String supplierId) throws SupplierNotFoundException {
		Supplier sup = suppliers.get(supplierId);
		if (sup == null) {
			throw new SupplierNotFoundException(supplierId);
		}
		return sup;
	}

	/**
	 * updated the supplier for the given supplierId
	 * @param id
	 * @param name
	 * @param email
	 * @param phone
	 * @param address
	 */
	public static void updateSupplierDetails(String supplierId, String name, String email, String phone, String address) throws SupplierNotFoundException{
		Supplier sup = getSupplier(supplierId);
		sup.updatedSupplier (name, email, phone, address);
	}
	
	// method to list supplier details (2)
	public static String listSupplierDetails(boolean includeProducts) {
		StringBuffer detailsSb = new StringBuffer();
		for (Supplier supplier : SupplierDataAccess.getSuppliers()) {
			detailsSb.append(supplier.getDetails(includeProducts));
			detailsSb.append("\n\n");
		}
		return detailsSb.toString();
	}

}
