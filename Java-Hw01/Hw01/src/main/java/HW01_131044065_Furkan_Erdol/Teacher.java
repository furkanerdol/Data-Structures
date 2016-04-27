package HW01_131044065_Furkan_Erdol;

/**
 * Teacher class
 * @author furkan
 */
public class Teacher extends User {

    /**
     * Takes three strings for name, username and password
     * @param newPersonName person name
     * @param newUserName user name
     * @param newUserPassword user password
     */
    public Teacher(String newPersonName, String newUserName, String newUserPassword) {
        super(newPersonName, newUserName, newUserPassword);
    }

    /**
     *
     * @param newUser
     * @return false
     */
    public boolean addUser(User newUser) {

        System.err.println("You are not authorized for this transaction!");

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
     * Takes course and document and adds document to inside course
     * Returns true if operation is successful otherwise returns false
     * @param courseObject target course
     * @param newDocument added document
     * @return true or false
     */
    public boolean addDocumentToCourse(Course courseObject, Document newDocument) {

        try {
            for (int i = 0; i < getCourseList().size(); ++i) {
                if (getCourseInCourseList(i).getCourseName() == courseObject.getCourseName()) {
                    if (getCourseInCourseList(i).addDocument(newDocument)) {
                        return true;
                    } else {
                        return false;
                    }

                }
            }

            throw new Exception();
        } catch (Exception exception) {
            System.err.println("This course (" + courseObject.getCourseName() + ") is not registered!");
            return false;
        }

    }

    /**
     * Takes course and assignment and adds assignment to inside course
     * Returns true if operation is successful otherwise returns false
     * @param courseObject target course
     * @param newAssignment added assignment
     * @return true or false
     */
    public boolean addAssignmentToCourse(Course courseObject, Assignment newAssignment) {

        try {
            for (int i = 0; i < getCourseList().size(); ++i) {
                if (getCourseInCourseList(i).getCourseName() == courseObject.getCourseName()) {
                    if (getCourseInCourseList(i).addAssignment(newAssignment)) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }

            throw new Exception();
        } catch (Exception exception) {
            System.err.println("This course (" + courseObject.getCourseName() + ") is not registered!");

            return false;
        }

    }
    
    
    /**
     * Takes course and user and adds user to inside course
     * Returns true if operation is successful otherwise returns false
     * @param courseObject
     * @param newUser
     * @return 
     */
    public boolean addUserToCourse(Course courseObject, User newUser) {

        try {
            if (!searchUser(newUser)) {
                throw new MyException();
            } else if (!searchCourse(courseObject)) {
                throw new Exception();
            } else if (courseObject.addUser(newUser)) {
                return true;
            } else {
                return false;
            }
        } catch (MyException exception) {
            System.err.println("This user (" + newUser.getUserName() + ") is not registered to course automation system!");
            return false;

        } catch (Exception exception) {
            System.err.println("This course (" + courseObject.getCourseName() + ") is not registered!");
            return false;
        }

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
     * Takes course and document removes document from inside course
     * Returns true if operation is successful otherwise returns false
     * @param courseObject target course
     * @param willBeRemovedDocument removed document
     * @return true or false
     */
    public boolean removeDocumantFromCourse(Course courseObject, Document willBeRemovedDocument) {

        try {

            if (!searchCourse(courseObject)) {
                throw new MyException();
            } else {

                for (int i = 0; i < getCourseList().size(); ++i) {
                    if (getCourseInCourseList(i).getCourseName() == courseObject.getCourseName()) {

                        if (getCourseInCourseList(i).removeDocument(willBeRemovedDocument)) {
                            return true;
                        } else {
                            return false;
                        }

                    }

                }
            }
            throw new Exception();
        } catch (MyException exception) {
            System.err.println("This course (" + courseObject.getCourseName() + ") is not registered!");
            return false;
        } catch (Exception exception) {
            System.err.println("This document (" + willBeRemovedDocument.getDocumentName() + ") is not registered!");
            return false;

        }

    }

    /**
     * Takes course and assignment removes assignment from inside course
     * Returns true if operation is successful otherwise returns false
     * @param courseObject target course
     * @param willBeRemovedAssignment  removed assignment
     * @return true or false
     */
    public boolean removeAssignmentFromCourse(Course courseObject, Assignment willBeRemovedAssignment) {

        try {

            if (!searchCourse(courseObject)) {
                throw new MyException();
            } else {

                for (int i = 0; i < getCourseList().size(); ++i) {
                    if (getCourseInCourseList(i).getCourseName() == courseObject.getCourseName()) {

                        if (getCourseInCourseList(i).removeAssignment(willBeRemovedAssignment)) {
                            return true;
                        } else {
                            return false;
                        }

                    }

                }
            }
            throw new Exception();
        } catch (MyException exception) {
            System.err.println("This course (" + courseObject.getCourseName() + ") is not registered!");
            return false;
        } catch (Exception exception) {
            System.err.println("This assignment (" + willBeRemovedAssignment.getAssignmentName() + ") is not registered!");
            return false;

        }

    }

    /**
     * Takes course and user removes user from inside course
     * Returns true if operation is successful otherwise returns false
     * @param courseObject target course
     * @param willBeRemovedUser removed user
     * @return true or false
     */
    public boolean removeUserFromCourse(Course courseObject, User willBeRemovedUser) {

        try {

            if (!searchCourse(courseObject)) {
                throw new MyException();
            } else {

                for (int i = 0; i < getCourseList().size(); ++i) {
                    if (getCourseInCourseList(i).getCourseName() == courseObject.getCourseName()) {

                        if (getCourseInCourseList(i).removeUser(willBeRemovedUser)) {
                            return true;
                        } else {
                            return false;
                        }

                    }

                }
            }
            throw new Exception();
        } catch (MyException exception) {
            System.err.println("This course (" + courseObject.getCourseName() + ") is not registered!");
            return false;
        } catch (Exception exception) {
            System.err.println("This user (" + willBeRemovedUser.getUserName() + ") is not registered!");
            return false;

        }

    }
    
    
    /**
     * Override toString method
     * @return the profile of administrator as a string
     */
    public String toString() {

        String formatted = new String();
        
        formatted += String.format("\n|Teacher|       Person's name: %-21s   Username: %-12s   Password: %s",
                        getPersonName(), getUserName(), getUserPassword());
        
        return formatted;
    }

}
