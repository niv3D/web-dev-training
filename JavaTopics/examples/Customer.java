package examples;

import java.util.HashMap;

public class Customer {
	
	private static HashMap<String, Customer> customerMap = new HashMap<>();
	
	private String customerName;
	private String customerPassword;
	
	public Customer(String name, String password) {
		
		this.customerName = name;
		this.customerPassword = password;
		customerMap.put(name, this);
		
	}
	
	public void removeCustomer() {
		
		customerMap.remove(this.customerName);
		
	}
	
	public String getCustomerName() {
		return this.customerName;
	}
	
	public static Customer getCustomer(String name, String password) {
		
		Customer customer = customerMap.get(name);
		
		if (customer != null && customer.customerPassword.equals(password)) {
			return customer;
		}
		else {
			return null;
		}
		
	}
}
