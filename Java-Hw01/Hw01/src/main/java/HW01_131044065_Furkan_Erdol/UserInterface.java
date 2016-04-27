package HW01_131044065_Furkan_Erdol;

/**
 * User interface
 * @author furkan
 */
public interface UserInterface{
    
    /**
     * Modify person name
     * @param personName person name
     */
    public void setPersonName(String personName);

    /**
     * Modify user name 
     * @param userName user name
     */
    public void setUserName(String userName);

    /**
     * Modify user password
     * @param userPassword user password
     */
    public void setUserPassword(String userPassword);
    
    /**
     * Returns person name
     * @return person name
     */
    public String getPersonName();

    /**
     * Returns user name
     * @return user name
     */
    public String getUserName();

    /**
     * Returns user password
     * @return user password
     */
    public String getUserPassword();  
    
}
