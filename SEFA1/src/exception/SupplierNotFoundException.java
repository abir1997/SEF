package exception;

public class SupplierNotFoundException extends Exception {

	private static final long serialVersionUID = 1105045175631879877L;

	public SupplierNotFoundException(String supplierId) {
		super("Supplier  '" + supplierId +"' not found");
	}
}
