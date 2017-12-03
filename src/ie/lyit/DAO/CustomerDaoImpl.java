package ie.lyit.DAO;

import ie.lyit.hotel.Customer;

import java.util.ArrayList;
import java.io.*;
import java.util.*;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CustomerDaoImpl implements CustomerDao{
	// Constant FILENAME for the file to be created
		final String FILENAME = "customers.bin";

		// Declare ArrayList called customers - for storing a list of customers
		public ArrayList<Customer> customers;
		

		// Default Constructor
		public CustomerDaoImpl(){
			// Construct customers ArrayList
			customers = new ArrayList<Customer>();
		}

		// Method Name : add()	
		/* (non-Javadoc)
		 * @see ie.lyit.DAO.CustomerDao#add()
		 */
		/* (non-Javadoc)
		 * @see ie.lyit.DAO.CustomerDao#add()
		 */
		@Override
		
		public void add(){
			// Create a Customer object
			Customer customer = new Customer();
			// Write/Read its details
			customer.write();	
			System.out.print(customer);
			// And add it to the customers ArrayList
			customers.add(customer);
		}

		// Method Name : list()							      
		/* (non-Javadoc)
		 * @see ie.lyit.DAO.CustomerDao#list()
		 */
		/* (non-Javadoc)
		 * @see ie.lyit.DAO.CustomerDao#list()
		 */
		
		@Override
		public void list(){
			// for every Customer object in customers
			for(Customer tmpCustomer:customers)
				// display it
				System.out.println(tmpCustomer);
		}
		
		//We create a function which allow us to select which customer
		//	we want to use in the function from where is called.
		public static int whichCustomer(){
			JTextField number = new JTextField();
			
		    Object[] message = {
		    	"Please introduce the number of the\nconsumer you want to select ", number
		    };
		
		    int option = JOptionPane.showConfirmDialog(null, message, "Select Consumer", JOptionPane.DEFAULT_OPTION);
		
		    if (option == JOptionPane.OK_OPTION){
		    	return Integer.parseInt(number.getText());	
		    }
		    else return 0;
		}
		
		
		// Method Name : view()									  
		/* (non-Javadoc)
		 * @see ie.lyit.DAO.CustomerDao#view()
		 */
		/* (non-Javadoc)
		 * @see ie.lyit.DAO.CustomerDao#view()
		 */
		@Override
		
		public Customer view(){
			// Read the number of the customer to be viewed from the whichCustomer() function
			int customerToView=whichCustomer();
			
			// for every Customer object in customers
		    for(Customer tmpCustomer:customers){
			   // if it's number equals the number of the customerToView
			   if(tmpCustomer.getNumber() == customerToView){
			      // display it
				  System.out.print(tmpCustomer);
				  return tmpCustomer;
			   }
			}
		    // if we reach this code the customer was not found so return null
		    return null;		
		}

		// Method Name : delete()								
		/* (non-Javadoc)
		 * @see ie.lyit.DAO.CustomerDao#delete()
		 */
		/* (non-Javadoc)
		 * @see ie.lyit.DAO.CustomerDao#delete()
		 */
		@Override
		
		public void delete(){	
			// Call view() to find, display, & return the customer to delete
			Customer tempCustomer = view();
			// If the customer != null, i.e. it was found then...
		    if(tempCustomer != null)
			   // ...remove it from customers
		       customers.remove(tempCustomer);
		}
		
		// Method Name : edit()			  					     
		/* (non-Javadoc)
		 * @see ie.lyit.DAO.CustomerDao#edit()
		 */
		/* (non-Javadoc)
		 * @see ie.lyit.DAO.CustomerDao#edit()
		 */
		@Override
		
		public void edit(){	
			// Call view() to find, display, & return the customer to edit
			Customer tempCustomer = view();
			// If the customer != null, i.e. it was found then...
		    if(tempCustomer != null){
			   // get it's index
			   int index=customers.indexOf(tempCustomer);
			   // read in a new customer and...
			   tempCustomer.write();
		    }
		}
		
		// Method Name : writeRecordsToFile()    			
		/* (non-Javadoc)
		 * @see ie.lyit.DAO.CustomerDao#writeRecordsToFile()
		 */
		/* (non-Javadoc)
		 * @see ie.lyit.DAO.CustomerDao#writeRecordsToFile()
		 */
		@Override
		public void writeRecordsToFile(){
			ObjectOutputStream os=null;
			try {
				// Serialize the ArrayList...
				FileOutputStream fileStream = new FileOutputStream(FILENAME);
			
				os = new ObjectOutputStream(fileStream);
					
				os.writeObject(customers);
			}
			catch(FileNotFoundException fNFE){
				System.out.println("Cannot create file to store books.");
			}
			catch(IOException ioE){
				System.out.println(ioE.getMessage());
			}
		}
		
		/* (non-Javadoc)
		 * @see ie.lyit.DAO.CustomerDao#topPosition()
		 */
		@Override
		public int topPosition(){							
			int nTopPosition = 0;
			for(Customer tempCustomer:customers){
				if (tempCustomer.getNumber() > nTopPosition){
					nTopPosition = tempCustomer.getNumber();
				}
			}
			return nTopPosition;
		}
		
		// Method Name : readRecordsFromFile()    			 
		/* (non-Javadoc)
		 * @see ie.lyit.DAO.CustomerDao#readRecordsFromFile()
		 */
		
		/* (non-Javadoc)
		 * @see ie.lyit.DAO.CustomerDao#readRecordsFromFile()
		 */
		@Override
		public void readRecordsFromFile(){
				ObjectInputStream is=null;
			
			try {
				// Deserialize the ArrayList...
				FileInputStream fileStream = new FileInputStream(FILENAME);
			
				is = new ObjectInputStream(fileStream);
					
				customers = (ArrayList<Customer>)is.readObject();	
				is.close();
			}
			catch(FileNotFoundException fNFE){
				System.out.println("Cannot create file to store customers.");
			}
			catch(IOException ioE){
				System.out.println(ioE.getMessage());
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		}			
	}