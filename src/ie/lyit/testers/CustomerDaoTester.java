package ie.lyit.testers;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import ie.lyit.serialize.CustomerSerializer;
import ie.lyit.hotel.Customer;
import ie.lyit.DAO.CustomerDao;
import ie.lyit.DAO.CustomerDaoImpl;
import ie.lyit.files.Menu;


public class CustomerDaoTester {

public static void main(String[] args) {
		// Create an object of customerserializer
		CustomerDao customerDao = new CustomerDaoImpl();
		
		// Deserialize the ArrayList from the File,
		// i.e. read the customer ArrayList from the file back into the ArrayList
		customerDao.readRecordsFromFile();
		// We determine from which position the next customer has to start appearing
		Customer.setNextNumber(customerDao.topPosition() + 1);
		
	    //A control variable for the selection menu
		int selection=0;
		
		//As long as we don't select the Quit option the program will keep running.
		do{
			JTextField selection2 = new JTextField();
			
		    Object[] message = {
		    	"1: Add\n2: List\n3: View\n4: Edit\n5: Delete\n6: Exit", selection2,
		    };
		
		    int option = JOptionPane.showConfirmDialog(null, message, "Select an option please", JOptionPane.DEFAULT_OPTION);
		
		    if (option == JOptionPane.OK_OPTION){
		    	
			    selection = Integer.parseInt(selection2.getText());	
			    
			    //We call each different function of the CustomerSerializer depending
			    //	of what option we choose
				switch(selection){
				   case 1:
					   customerDao.add();
					   System.out.println("\n\n");
					   break;
				   case 2:
					   customerDao.list();
					   System.out.println("\n\n");
					   break;
				   case 3:
					   customerDao.view();
					   System.out.println("\n\n");
					   break;
				   case 4:
					   customerDao.edit();
					   System.out.println("\n\n");
					   break;
				   case 5:
					   customerDao.delete();
					   System.out.println("\n\n");
					   break;
				   case 6:				
					   // Serialize the ArrayList to the File
					   // before we exit the program.
					   customerDao.writeRecordsToFile();
					   break;				
				   default:
					   System.out.println("INVALID OPTION...");
				}
			}	
		}while(selection != 6);
	}
}
