package dataAccess;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

import model.Customer;
import model.Supplier;
import model.User;

public class UserDataAccess {

	public static Map<Integer, User> users = new HashMap<>();

	public static Collection<User> getUsers() {
		return Collections.unmodifiableCollection(users.values());
	}

	public static Set<Customer> getAllCustomers(){
		Set<Customer> customers = new HashSet<>();
		for (User user: users.values()) {
			if (user instanceof Customer) {
				customers.add((Customer)user);
			}
		}
		return customers;
	}
}
