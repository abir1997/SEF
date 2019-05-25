package dataAccess;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import model.Customer;
import model.User;

public class UserDataAccess {

	public static Map<Integer, User> users = new HashMap<>();

	public Set<Customer> getAllCustomers(){
		Set<Customer> customers = new TreeSet<>();
		for (User user: users.values()) {
			if (user instanceof Customer) {
				customers.add((Customer)user);
			}
		}
		return customers;
	}
}
