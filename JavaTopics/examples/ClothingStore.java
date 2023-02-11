package examples;

import java.util.Scanner;

public class ClothingStore {
	
	
	private static Customer currentCustomer;
	
	
	public static void createUser(String username, String password) {
		
		
		if(Customer.verifyCustomer(username)) {
			
			System.out.println("user already exists !");
			
		}else {
			
			currentCustomer = new Customer(username, password);
			
		}
		
	}
	
	public static void userLogin(String username, String password) {
		
		currentCustomer = Customer.getCustomer(username, password);
		
		if (currentCustomer == null) {
			
			System.out.println("incorrect username or password !");
			
		}
		
	}
	
	public static void userLogout() {
		currentCustomer  = null;
	}
	
	public static void displayCurrentCustomer() {
		
		if (currentCustomer != null){
			
			System.out.println("current user : "+ currentCustomer.getCustomerName());
			
		}else {
			
			System.out.println("current user : not logged in !");
		}
	}

	public static void main(String[] args) {
		
		createUser("nived","password");
		
		displayCurrentCustomer();
		
		userLogout();
		
		createUser("eldho","helloWorld");
		
		displayCurrentCustomer();
		
		userLogin("nived","incorrect");
		
		displayCurrentCustomer();
		
		userLogin("nived","password");
		
		displayCurrentCustomer();
		
		userLogout();
		
		displayCurrentCustomer();
		
		userLogin("eldho","helloWorld");
		
		displayCurrentCustomer();
		
	}

}