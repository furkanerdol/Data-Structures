package HW01_131044065_Furkan_Erdol;

/**
 * Student class
 * @author furkan
 */
public class Student extends User {

    private String studentID;

    /**
     * Takes four strings for name, username, password and student id
     * @param newPersonName person name
     * @param newUserName user name
     * @param newUserPassword user password
     * @param newStudentID student id
     */
    public Student(String newPersonName, String newUserName, String newUserPassword, String newStudentID) {
        super(newPersonName, newUserName, newUserPassword);
        setStudentID(newStudentID);
    }

    /**
     * Returns student id
     * @return student id
     */
    public String getStudentID() {
        return studentID;
    }

    /**
     * Modify student id
     * @param newStudentID student id
     */
    public void setStudentID(String newStudentID) {
        studentID = newStudentID;
    }

    /**
     * Illegal operation
     * @param newUser
     * @return false
     */
    public boolean addUser(User newUser) {

        System.out.println("You are not authorized for this transaction!");

        return false;
    }

    /**
     * Illegal operation
     * @param newCourse
     * @return false
     */
    public boolean addCourse(Course newCourse) {

        System.err.println("You are not authorized for this transaction!");

        return false;
    }

    /**
     * Illegal operation
     * @param courseObject
     * @param newDocument
     * @return false
     */
    public boolean addDocumentToCourse(Course courseObject, Document newDocument) {

        System.err.println("You are not authorized for this transaction!");

        return false;
    }

    /**
     * Illegal operation
     * @param courseObject
     * @param newAssignment
     * @return false
     */
    public boolean addAssignmentToCourse(Course courseObject, Assignment newAssignment) {

        System.err.println("You are not authorized for this transaction!");

        return false;
    }

    /**
     * Illegal operation
     * @param courseObject
     * @param newUser
     * @return false
     */
    public boolean addUserToCourse(Course courseObject, User newUser) {

        System.err.println("You are not authorized for this transaction!");

        return false;
    }

    /**
     * Illegal operation
     * @param willBeRemovedUser
     * @return false
     */
    public boolean removeUser(User willBeRemovedUser) {

        System.err.println("You are not authorized for this transaction!");

        return false;

    }

    /**
     * Illegal operation
     * @param willBeRemovedCourse
     * @return false
     */
    public boolean removeCourse(Course willBeRemovedCourse) {

        System.err.println("You are not authorized for this transaction!");

        return false;

    }

    /**
     * Illegal operation
     * @param courseObject
     * @param willBeRemovedDocument
     * @return false
     */
    public boolean removeDocumantFromCourse(Course courseObject, Document willBeRemovedDocument) {

        System.err.println("You are not authorized for this transaction!");

        return false;

    }

    /**
     * Illegal operation
     * @param courseObject
     * @param willBeRemovedAssignment
     * @return false
     */
    public boolean removeAssignmentFromCourse(Course courseObject, Assignment willBeRemovedAssignment) {

        System.err.println("You are not authorized for this transaction!");

        return false;

    }

    /**
     * Illegal operation
     * @param courseObject
     * @param willBeRemovedUser
     * @return false
     */
    public boolean removeUserFromCourse(Course courseObject, User willBeRemovedUser) {

        System.err.println("You are not authorized for this transaction!");

        return false;

    }

    /**
     * Student uploads assignment 
     * Returns true if operation is successful otherwise returns false
     * @param assignmentName assignment name
     * @return true or false
     */
    public boolean uploadAssignment(Assignment assignmentName) {

        if (assignmentName.addStudentToAssignment(this)) {
            return true;
        }

        return false;

    }

    /**
     * Student requests for register to administrator
     * Returns true if operation is successful otherwise returns false
     * @return true or false
     */
    public boolean requestForRegister() {

        try {
            for (int i = 0; i < getRequestStudentList().size(); ++i) {
                if (getStudentInRequestStudentList(i).getUserName() == this.getUserName()) {
                    throw new Exception();
                }
            }

            getRequestStudentList().add(this);
            return true;

        } catch (Exception exception) {
            System.err.println("You have already submitted requests!");
            return false;
        }

    }

    /**
     * Illegal operation
     */
    public void showOldCourses() {

        System.err.println("You are not authorized for this transaction!");

    }

    /**
     * Shows student's assignments and grades
     */
    public void showGrades() {

        for (int i = 0; i < getCourseList().size(); ++i) {
            for (int j = 0; j < getCourseInCourseList(i).getAssignmentListInCourse().size(); ++j) {
                for (int k = 0; k < getCourseInCourseList(i).getAssignmentInAssignmentCourseList(j).getStudentListInAssignment().size(); ++k) {
                    if (getCourseInCourseList(i).getAssignmentInAssignmentCourseList(j).getStudentInStudentListInAssignment(k).getUserName() == this.getUserName()) {
                        System.out.println(getCourseInCourseList(i).getAssignmentInAssignmentCourseList(j));
                        System.out.println("Grade   :" + getCourseInCourseList(i).getAssignmentInAssignmentCourseList(j).getGradeInGradeListInAssignment(k));
                    }
                }
            }
        }
    }
    
    /**
     * Override toString method
     * @return the profile of administrator as a string
     */
    public String toString() {

        String formatted = new String();
        
        formatted += String.format("\n|Student|       Person's name: %-21s   Username: %-12s   Password: %s   Student ID: %s",
                        getPersonName(), getUserName(), getUserPassword(), getStudentID());
        
        return formatted;
    }
}
