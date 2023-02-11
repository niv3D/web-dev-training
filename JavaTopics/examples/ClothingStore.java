package examples;

import java.util.Scanner;

public class ClothingStore {
	
	private Customer currentCustomer;
	
	public void userLogin() {
		
		Scanner input = new Scanner(System.in);

		System.out.println("Enter user name : ");

		String username = input.next("[a-z][a-z]*");

		System.out.println("Enter password : ");
		
		String password = input.next("[a-z][a-z]*");
		
		
		this.currentCustomer = Customer.getCustomer(username, password);
		
		if (this.currentCustomer == null) {
			
			System.out.println("incorrect username or password");
			
		}
		
		
	}

	public static void main(String[] args) {
		
		
		
	}

}