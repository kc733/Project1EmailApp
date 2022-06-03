package emailapp;

import java.util.Scanner;

// public stuff that is accessed in main
public class Email {

	// Build objects, will access through API
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private int defaultPasswordLength = 10;
	private String email;
	private String companySuffix = "company.com";
	private int mailboxCapacity = 500;
	private String alternateEmail;
	
	// Constructor to receive first name and last name (put names in main) + etc
	public Email(String firstName, String lastName) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		System.out.println("CREATING EMAIL FOR: " + this.firstName + " " + this.lastName);
		
		// Call a METHOD asking for the department - return the department
		this.department = setDepartment();
		
		// Call a METHOD that returns a random password
		this.password = randomPassword(defaultPasswordLength); // length determined in main
		System.out.println("Your password is: " + this.password);
		
		// Combine elements to generate email
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
	}
	
	// Ask for the department (METHOD)
	private String setDepartment() {
		
		System.out.print("Department codes:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code: ");
		Scanner in = new Scanner(System.in);
		int depChoice = in.nextInt();
		
		if(depChoice == 1) { return "Sales"; }
		else if(depChoice == 2) { return "Development"; }
		else if(depChoice == 3) { return "Accounting"; }
		else { return ""; }
				}
	
	// Generate a random password (METHOD)
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		char[] password = new char[length]; // has to be the default length
		
		for(int i=0; i<length; i++){
			int rand = (int) (Math.random() * passwordSet.length()); //gets value from char set and makes in random
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}
	
	
	// Set a mailbox capacity
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}
	
	// Set alternate email
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	
	// Change the password
	public void changePassword(String changedPassword) {
		this.password = changedPassword;
	}
	
	// access alt email, mailbox capacity and password(data encapsulation) using GET METHOD
	public int getMailboxCapacity() { return mailboxCapacity; }
	public String getAlternateEmail() { return alternateEmail; }
	public String getPassword() { return password; }
	
	public String showInfo() {
		return "DISPLAY NAME: " + firstName + " " + lastName +
				"\nCOMPANY EMAIL: " + email + " " +
				"\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
	}
	
}
