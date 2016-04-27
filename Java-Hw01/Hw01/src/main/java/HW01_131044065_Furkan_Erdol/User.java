package HW01_131044065_Furkan_Erdol;

import java.util.ArrayList;

/**
 * User abstract class
 * User is administrator, teacher, student and tutor
 * @author furkan
 */
public abstract class User implements UserInterface {

    private String personName;
    private String userName;
    private String userPassword;

    private static ArrayList<User> userList = new ArrayList();
    private static ArrayList<Course> courseList = new ArrayList();
    private static ArrayList<Course> oldCourseList = new ArrayList();
    private static ArrayList<Student> requestStudentList = new ArrayList();

    /**
     * Takes three strings for name, username and password
     * @param newPersonName person name
     * @param newUserName user name
     * @param newUserPassword user password
     */
    public User(String newPersonName, String newUserName, String newUserPassword) {
        setPersonName(newPersonName);
        setUserName(newUserName);
        setUserPassword(newUserPassword);

    }

    /**
     * Returns person name
     * @return person name
     */
    public String getPersonName() {
        return personName;
    }

    /**
     * Returns user name
     * @return user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Returns user password
     * @return user password
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * Modify person name
     * @param newPersonName
     */
    public void setPersonName(String newPersonName) {
        personName = newPersonName;

    }

    /**
     * Modify user name 
     * @param newUserName
     */
    public void setUserName(String newUserName) {
        userName = newUserName;
    }

    /**
     * Modify user password
     * @param newUserPassword
     */
    public void setUserPassword(String newUserPassword) {
        userPassword = newUserPassword;
    }

    /**
     * Returns user list
     * @return user list
     */
    public ArrayList<User> getUserList() {
        return userList;

    }

    /**
     * Returns user from user list
     * @param index user's index
     * @return user
     */
    public User getUserInUserList(int index) {
        return userList.get(index);

    }

    /**
     * Returns course list
     * @return course list
     */
    public ArrayList<Course> getCourseList() {
        return courseList;

    }

    /**
     * Returns course from course list
     * @param index course index
     * @return course
     */
    public Course getCourseInCourseList(int index) {
        return courseList.get(index);

    }

    /**
     * Returns old course list
     * @return old course list
     */
    public ArrayList<Course> getOldCourseList() {
        return oldCourseList;

    }

    /**
     * Returns old course from old course list
     * @param index old course index
     * @return old course
     */
    public Course getCourseInOldCourseList(int index) {
        return oldCourseList.get(index);

    }

    /**
     * Returns student request list
     * @return student request list 
     */
    public ArrayList<Student> getRequestStudentList() {
        return requestStudentList;

    }

    /**
     *Returns student request from student request list
     * @param index student request index
     * @return student request
     */
    public Student getStudentInRequestStudentList(int index) {
        return requestStudentList.get(index);
    }

    /**
     * Search user in user list
     * If founded it returns true or otherwise returns false
     * @param targetUser target user
     * @return true or false
     */
    public boolean searchUser(User targetUser) {

        for (int i = 0; i < getUserList().size(); ++i) {
            if (getUserInUserList(i).getUserName() == targetUser.getUserName()) {
                return true;
            }
        }

        return false;
    }

    /**
     * Search course in course list
     * If founded it returns true or otherwise returns false
     * @param targetCourse target course
     * @return true or false
     */
    public boolean searchCourse(Course targetCourse) {

        for (int i = 0; i < getCourseList().size(); ++i) {
            if (getCourseInCourseList(i).getCourseName() == targetCourse.getCourseName()) {
                return true;
            }
        }

        return false;
    }
    
    /**
     * Prints the screen all registered courses
     */
    public void showRegisteredCourses() {

        System.out.printf("\n\n########## COURSES ##########");

        for (int i = 0; i < getCourseList().size(); ++i) {

            System.out.printf("\n\n|%s|", getCourseInCourseList(i).getCourseName());
            for (int j = 0; j < getCourseInCourseList(i).getUserListInCourse().size(); ++j) {
                if (getCourseInCourseList(i).getUserInUserCourseList(j) instanceof Teacher) {
                    System.out.printf("\nTeacher : %s", getCourseInCourseList(i).getUserInUserCourseList(j).getPersonName());
                } else if (getCourseInCourseList(i).getUserInUserCourseList(j) instanceof Tutor) {
                    System.out.printf("\nTutor   : %s", getCourseInCourseList(i).getUserInUserCourseList(j).getPersonName());
                } else if (getCourseInCourseList(i).getUserInUserCourseList(j) instanceof Student) {
                    System.out.printf("\nStudent : %s", getCourseInCourseList(i).getUserInUserCourseList(j).getPersonName());
                }
            }

        }

    }

    /**
     * Prints the screen all old courses
     */
    public void showOldCourses() {
        System.out.printf("\n\n########## OLD COURSES ########## ");

        for (int i = 0; i < getOldCourseList().size(); ++i) {

            System.out.printf("\n\n|%s|", getCourseInOldCourseList(i).getCourseName());
            for (int j = 0; j < getCourseInOldCourseList(i).getUserListInCourse().size(); ++j) {
                if (getCourseInOldCourseList(i).getUserInUserCourseList(j) instanceof Teacher) {
                    System.out.printf("\nTeacher : %s", getCourseInOldCourseList(i).getUserInUserCourseList(j).getPersonName());
                } else if (getCourseInOldCourseList(i).getUserInUserCourseList(j) instanceof Tutor) {
                    System.out.printf("\nTutor   : %s", getCourseInOldCourseList(i).getUserInUserCourseList(j).getPersonName());
                } else if (getCourseInOldCourseList(i).getUserInUserCourseList(j) instanceof Student) {
                    System.out.printf("\nStudent : %s", getCourseInOldCourseList(i).getUserInUserCourseList(j).getPersonName());
                }
            }

        }
    }

    /**
     * Prints the screen course content
     * @param showCourse showed course
     */
    public void showCourseContent(Course showCourse) {

        System.out.printf("\n\n### %s CONTENT ###", showCourse.getCourseName());

        System.out.printf("\n\n-----DOCUMENTS:\n");
        for (int i = 0; i < showCourse.getDocumentListInCourse().size(); ++i) {
            if (showCourse.getDocumentInDocumantCourseList(i) instanceof Book) {
                Book tempBook = (Book) showCourse.getDocumentInDocumantCourseList(i);
                System.out.printf("\n-Book : %s", tempBook.getDocumentName());
            } else if (showCourse.getDocumentInDocumantCourseList(i) instanceof File) {
                File tempFile = (File) showCourse.getDocumentInDocumantCourseList(i);
                System.out.printf("\n-File : %s", tempFile.getDocumentName());
            } else if (showCourse.getDocumentInDocumantCourseList(i) instanceof Slide) {
                Slide tempSlide = (Slide) showCourse.getDocumentInDocumantCourseList(i);
                System.out.printf("\n-Slide : %s", tempSlide.getDocumentName());
            } else if (showCourse.getDocumentInDocumantCourseList(i) instanceof Url) {
                Url tempUrl = (Url) showCourse.getDocumentInDocumantCourseList(i);
                System.out.printf("\n-Url : %s", tempUrl.getDocumentName());
            } else if (showCourse.getDocumentInDocumantCourseList(i) instanceof WhiteBoardDescriptions) {
                WhiteBoardDescriptions tempWhiteBoardDescriptions = (WhiteBoardDescriptions) showCourse.getDocumentInDocumantCourseList(i);
                System.out.printf("\n-White Board Description : %s", tempWhiteBoardDescriptions.getDocumentName());
            }

        }

        System.out.printf("\n\n-----ASSINGMENTS:");
        for (int i = 0; i < showCourse.getAssignmentListInCourse().size(); ++i) {
            if (showCourse.getAssignmentInAssignmentCourseList(i) instanceof Quiz) {
                Quiz tempQuiz = (Quiz) showCourse.getAssignmentInAssignmentCourseList(i);
                System.out.printf("\n\n(Quiz)  %s", tempQuiz.getAssignmentName());
                System.out.printf("\nDeadline      : %s", tempQuiz.getDeadline());
                System.out.printf("\nLate deadline : %s", tempQuiz.getLateDeadLine());
            } else if (showCourse.getAssignmentInAssignmentCourseList(i) instanceof HomeWork) {
                HomeWork tempHomeWork = (HomeWork) showCourse.getAssignmentInAssignmentCourseList(i);
                System.out.printf("\n\n(Homework)  %s", tempHomeWork.getAssignmentName());
                System.out.printf("\nDeadline      : %s", tempHomeWork.getDeadline());
                System.out.printf("\nLate deadline : %s", tempHomeWork.getLateDeadLine());
            } else if (showCourse.getAssignmentInAssignmentCourseList(i) instanceof GroupProject) {
                GroupProject tempGroupProject = (GroupProject) showCourse.getAssignmentInAssignmentCourseList(i);
                System.out.printf("\n\n(Group Project)  %s", tempGroupProject.getAssignmentName());
                System.out.printf("\nDeadline      : %s", tempGroupProject.getDeadline());
                System.out.printf("\nLate deadline : %s", tempGroupProject.getLateDeadLine());
            }
        }
    }
    
    
    
     /**
     * Override toString method
     * @return the profile of user as a string
     */
    public String toString(){
        
        String formatted = new String();
        
        if (this instanceof Administrator) {
                Administrator tempAdmin = (Administrator) this;
                formatted += String.format("\n|Administator|  Person's name: %s   Username: %s   Password: %s",
                        tempAdmin.getPersonName(), tempAdmin.getUserName(), tempAdmin.getUserPassword());
            } else if (this instanceof Teacher) {
                Teacher tempTeacher = (Teacher) this;
                formatted += String.format("\n|Teacher|       Person's name: %s   Username: %s   Password: %s",
                        tempTeacher.getPersonName(), tempTeacher.getUserName(), tempTeacher.getUserPassword());
            } else if (this instanceof Tutor) {
                Tutor tempTutor = (Tutor) this;
                formatted += String.format("\n|Tutor|         Person's name: %s   Username: %s   Password: %s   Student ID: %s",
                        tempTutor.getPersonName(), tempTutor.getUserName(), tempTutor.getUserPassword(), tempTutor.getStudentID());
            } else if (this instanceof Student) {
                Student tempStudent = (Student) this;
                formatted += String.format("\n|Student|       Person's name: %s   Username: %s   Password: %s   Student ID: %s",
                        tempStudent.getPersonName(), tempStudent.getUserName(), tempStudent.getUserPassword(), tempStudent.getStudentID());
            }
        
        return formatted;
    }

    /**
     * Takes user and add to system
     * Returns true if operation is successful otherwise returns false
     * @param newUser added user
     * @return true or false
     */
    public abstract boolean addUser(User newUser);

    /**
     * Takes course and add to system
     * Returns true if operation is successful otherwise returns false
     * @param newCourse added course
     * @return true or false
     */
    public abstract boolean addCourse(Course newCourse);

    /**
     * Takes course and document and adds document to inside course
     * Returns true if operation is successful otherwise returns false
     * @param courseObject target course
     * @param newDocument added document
     * @return true or false
     */
    public abstract boolean addDocumentToCourse(Course courseObject, Document newDocument);

    /**
     * Takes course and assignment and adds assignment to inside course
     * Returns true if operation is successful otherwise returns false
     * @param courseObject target course
     * @param newAssignment added assignment
     * @return true or false
     */
    public abstract boolean addAssignmentToCourse(Course courseObject, Assignment newAssignment);

    /**
     * Takes course and user and adds user to inside course
     * Returns true if operation is successful otherwise returns false
     * @param courseObject
     * @param newUser
     * @return 
     */
    public abstract boolean addUserToCourse(Course courseObject, User newUser);

    /**
     * Takes user and removes it
     * Returns true if operation is successful otherwise returns false
     * @param willBeRemovedUser removed user
     * @return true or false
     */
    public abstract boolean removeUser(User willBeRemovedUser);

    /**
     * Takes course and removes it
     * Returns true if operation is successful otherwise returns false
     * @param willBeRemovedCourse removed course
     * @return true or false
     */
    public abstract boolean removeCourse(Course willBeRemovedCourse);

    /**
     * Takes course and document removes document from inside course
     * Returns true if operation is successful otherwise returns false
     * @param courseObject target course
     * @param willBeRemovedDocument removed document
     * @return true or false
     */
    public abstract boolean removeDocumantFromCourse(Course courseObject, Document willBeRemovedDocument);

    /**
     * Takes course and assignment removes assignment from inside course
     * Returns true if operation is successful otherwise returns false
     * @param courseObject target course
     * @param willBeRemovedAssignment  removed assignment
     * @return true or false
     */
    public abstract boolean removeAssignmentFromCourse(Course courseObject, Assignment willBeRemovedAssignment);

    /**
     * Takes course and user removes user from inside course
     * Returns true if operation is successful otherwise returns false
     * @param courseObject target course
     * @param willBeRemovedUser removed user
     * @return true or false
     */
    public abstract boolean removeUserFromCourse(Course courseObject, User willBeRemovedUser);
}
