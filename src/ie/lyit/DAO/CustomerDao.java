package ie.lyit.DAO;

import ie.lyit.hotel.Customer;

public interface CustomerDao {

	// Method Name : add()	
	/* (non-Javadoc)
	 * @see ie.lyit.DAO.CustomerDao#add()
	 */
	public abstract void add();

	// Method Name : list()							      
	/* (non-Javadoc)
	 * @see ie.lyit.DAO.CustomerDao#list()
	 */
	public abstract void list();

	// Method Name : view()									  
	/* (non-Javadoc)
	 * @see ie.lyit.DAO.CustomerDao#view()
	 */
	public abstract Customer view();

	// Method Name : delete()								
	/* (non-Javadoc)
	 * @see ie.lyit.DAO.CustomerDao#delete()
	 */
	public abstract void delete();

	// Method Name : edit()			  					     
	/* (non-Javadoc)
	 * @see ie.lyit.DAO.CustomerDao#edit()
	 */
	public abstract void edit();

	// Method Name : writeRecordsToFile()    			
	/* (non-Javadoc)
	 * @see ie.lyit.DAO.CustomerDao#writeRecordsToFile()
	 */
	public abstract void writeRecordsToFile();

	public abstract int topPosition();

	public abstract void readRecordsFromFile();

}