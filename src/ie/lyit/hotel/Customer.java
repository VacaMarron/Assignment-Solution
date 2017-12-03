package ie.lyit.hotel;

import java.io.Serializable;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Customer extends Person{// INHERITANCE - Customer IS-A Person
	// Customer has name, address, & phoneNumber from Person
	private String emailAddress;    // AND emailAddress
	private int number;			    // AND number

	private static int nextNumber=1;// static for unique number - starts off at 1
	
	// Default Constructor
	public Customer(){
		emailAddress=null;
		// Set number to static nextNumber before incrementing nextNumber
		number=nextNumber++;
	}
	
	// Initialization Constructor
	public Customer(String t, String fN, String sn, String address, 
			        String pNo, String email){
		// Call super class constructor - Passing parameters required by Person ONLY!
		super(t, fN, sn, address, pNo);
		// And then initialise Customers own instance variables
		emailAddress=email;
		// And finally set number to static nextNumber before incrementing nextNumber
		number=nextNumber++;
	}

	// Calling Persons toString() method, and adding extra things to make it look more 
	//	appealing to the view
	public String toString(){
		return  "Number: " + number + " /// Name: " + name + " /// Address: " + address 
				+ " /// Phone Number: " + phoneNumber + " /// Email Address: " + emailAddress;
	}

	// set() and get() methods
	public int getNumber(){
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public static void setNextNumber(int nextNumber){
		Customer.nextNumber = nextNumber;
	}
	//With this method we will be able to open a console and write each value of the customer
	public void write(){						
		JTextField t = new JTextField();
		JTextField fN = new JTextField();
		JTextField sn = new JTextField();
		JTextField address = new JTextField();
		JTextField pNo = new JTextField();
		JTextField email = new JTextField();

	    Object[] message = {
	    	"Title:", t,
	    	"Firstname:", fN,
	    	"Surname:", sn,
	    	"Address:", address,
	    	"Phone number:", pNo,
	    	"E-Mail:", email,
	     };
	
	    int option = JOptionPane.showConfirmDialog(null, message, "Enter customer details", 
	    		JOptionPane.DEFAULT_OPTION);
	
	    if (option == JOptionPane.OK_OPTION){
	    	this.name = new Name(t.getText(), fN.getText(), sn.getText());
	    	this.address = address.getText();
	    	this.phoneNumber = pNo.getText();
	    	this.emailAddress = email.getText();
	    }   
	}
}