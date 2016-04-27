package HW01_131044065_Furkan_Erdol;

/**
 * Assignment interface
 * @author furkan
 */
public interface AssignmentInterface {
    
    /**
     * Returns assignment name
     *
     * @return assignment name
     */
    public String getAssignmentName();

    /**
     * Returns deadline
     *
     * @return deadline
     */
    public String getDeadline();

    /**
     * Returns late deadline
     *
     * @return late deadline
     */
    public String getLateDeadLine();
    
    /**
     * Modify assignment name
     *
     * @param newAssignmentName assignment name
     */
    public void setAssignmentName(String newAssignmentName);

    /**
     * Modify deadline
     *
     * @param newDeadLine deadline
     */
    public void setDeadline(String newDeadLine);

    /**
     * Modify late deadline
     *
     * @param newLateDeadLine late deadline
     */
    public void setLateDeadLine(String newLateDeadLine);
}
