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
	
}
