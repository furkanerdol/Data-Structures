package HW01_131044065_Furkan_Erdol;

/**
 * Administrator has all authority to system
 *
 * @author furkan
 */
public class Administrator extends User {

    /**
     * Takes three strings for name, username and password
     * @param newPersonName person name
     * @param newUserName user name
     * @param newUserPassword user password
     */
    public Administrator(String newPersonName, String newUserName, String newUserPassword) {
        super(newPersonName, newUserName, newUserPassword);

        addUser(this);
    }

    /**
     * Takes user and add to system
     * Returns true if operation is successful otherwise returns false
     * @param newUser added user
     * @return true or false
     */
    public boolean addUser(User newUser) {

        try {
            if (searchUser(newUser)) {
                throw new Exception();
            }
        } catch (Exception exception) {
            System.err.println("It was already registered with this username!");
            return false;
        }

        getUserList().add(newUser);

        return true;
    }

    /**
     * Takes course and add to system
     * Returns true if operation is successful otherwise returns false
     * @param newCourse added course
     * @return true or false
     */
    public boolean addCourse(Course newCourse) {

        try {
            if (searchCourse(newCourse)) {
                throw new Exception();
            }
        } catch (Exception exception) {
            System.err.println("It was already created with this course name!");
            return false;

        }

        getCourseList().add(newCourse);

        return true;
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
     * Takes user and removes it
     * Returns true if operation is successful otherwise returns false
     * @param willBeRemovedUser removed user
     * @return true or false
     */
    public boolean removeUser(User willBeRemovedUser) {

        try {
            for (int i = 0; i < getUserList().size(); ++i) {
                if (getUserInUserList(i).getUserName() == willBeRemovedUser.getUserName()) {
                    getUserList().remove(i);
                    return true;
                }

            }
            throw new Exception();
        } catch (Exception exception) {
            System.err.println("This user (" + willBeRemovedUser.getUserName() + ") is not registered!");
            return false;
        }

    }

    /**
     * Takes course and removes it
     * Returns true if operation is successful otherwise returns false
     * @param willBeRemovedCourse removed course
     * @return true or false
     */
    public boolean removeCourse(Course willBeRemovedCourse) {
        try {
            for (int i = 0; i < getCourseList().size(); ++i) {
                if (getCourseInCourseList(i).getCourseName() == willBeRemovedCourse.getCourseName()) {
                    getOldCourseList().add(willBeRemovedCourse);
                    getCourseList().remove(i);
                    return true;
                }

            }
            throw new Exception();
        } catch (Exception exception) {
            System.err.println("This course (" + willBeRemovedCourse.getCourseName() + ") is not registered!");
            return false;
        }
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
     * Takes course and tutor adds tutor to inside course as a student
     * Returns true if operation is successful otherwise returns false
     * @param courseObject target course
     * @param addAsAStudent added tutor (as a Student)
     * @return true or false
     */
    public boolean addTutorADiffrentCourseAsAStudent(Course courseObject, Tutor addAsAStudent) {

        Student studentRef = new Student(addAsAStudent.getPersonName(), addAsAStudent.getUserName(),
                addAsAStudent.getUserPassword(), addAsAStudent.getStudentID());

        try {
            if (!searchUser(studentRef)) {
                throw new MyException();
            } else if (!searchCourse(courseObject)) {
                throw new Exception();
            } else if (courseObject.addUser(studentRef)) {
                return true;
            } else {
                return false;
            }
        } catch (MyException exception) {
            System.err.println("This user (" + studentRef.getUserName() + ") is not registered to course automation system!");
            return false;

        } catch (Exception exception) {
            System.err.println("This course (" + courseObject.getCourseName() + ") is not registered!");
            return false;
        }
    }

    /**
     * Administrator confirms all requests
     * Adds them to inside system
     * Returns true if operation is successful otherwise returns false
     * @return true or false
     */
    public boolean confirmRequests() {

        int counterConfirm = 0;

        try {
            for (int i = 0; i < getRequestStudentList().size(); ++i) {
                addUser(getStudentInRequestStudentList(i));
                System.out.printf("%s added!", getStudentInRequestStudentList(i));
                ++counterConfirm;
            }

            if (counterConfirm != 0) {
                System.out.println("\nAdded complete!");
                return true;
            }

            throw new Exception();
        } catch (Exception exception) {
            System.out.println("No request for register!");
            return false;
        }

    }

    /**
     * Prints the screen all registered users in the system 
     * Here it is used polymorphic call
     */
    public void showRegisteredUsers() {

        System.out.printf("\n\n########## REGISTERED USERS ##########\n");

        for (int i = 0; i < getUserList().size(); ++i) {

            System.out.printf("%s", getUserInUserList(i));

        }
    }

    /**
     * Override toString method
     * @return the profile of administrator as a string
     */
    public String toString() {

        String formatted = new String();

        formatted += String.format("\n|Administator|  Person's name: %-21s   Username: %-12s   Password: %s",
                getPersonName(), getUserName(), getUserPassword());

        return formatted;
    }

}
