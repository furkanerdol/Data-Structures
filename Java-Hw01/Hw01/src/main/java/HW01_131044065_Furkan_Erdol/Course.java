package HW01_131044065_Furkan_Erdol;

import java.util.ArrayList;

/**
 * Course keeps users, documents and assignments 
 * @author furkan
 */
public class Course {

    private ArrayList<User> userListInCourse = new ArrayList();
    private ArrayList<Document> documentListInCourse = new ArrayList();
    private ArrayList<Assignment> assignmentListInCourse = new ArrayList();

    private String courseName;

    /**
     * Takes course name
     * @param newCourseName
     */
    public Course(String newCourseName) {
        setCourseName(newCourseName);
    }

    /**
     * Returns course name
     * @return course name
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Modify course name
     * @param newCourseName course name
     */
    public void setCourseName(String newCourseName) {
        courseName = newCourseName;
    }

    /**
     * Returns user list
     * @return user list
     */
    public ArrayList<User> getUserListInCourse() {
        return userListInCourse;
    }

    /**
     * Returns user from user list
     * @param index user's index
     * @return user
     */
    public User getUserInUserCourseList(int index) {
        return userListInCourse.get(index);
    }

    /**
     * Returns document list
     * @return document list
     */
    public ArrayList<Document> getDocumentListInCourse() {
        return documentListInCourse;
    }

    /**
     * Returns document from document list
     * @param index document index
     * @return document
     */
    public Document getDocumentInDocumantCourseList(int index) {
        return documentListInCourse.get(index);
    }

    /**
     * Returns assignment list
     * @return assignment list
     */
    public ArrayList<Assignment> getAssignmentListInCourse() {
        return assignmentListInCourse;
    }

    /**
     * Return assignment form assignment list
     * @param index assignment index
     * @return assignment
     */
    public Assignment getAssignmentInAssignmentCourseList(int index) {
        return assignmentListInCourse.get(index);
    }
    
    /**
     * Takes user and add to inside course
     * Returns true if operation is successful otherwise returns false
     * @param newUser added user
     * @return true or false
     */
    public boolean addUser(User newUser){
        try {
            if (searchUserInCourse(newUser)) {
                throw new Exception();
            }

            getUserListInCourse().add(newUser);
            return true;
        } catch (Exception exception) {
            System.err.println("This user already exists!");
            return false;

        }

    }
    
    /**
     * Takes user and removes from inside course
     * Returns true if operation is successful otherwise returns false
     * @param willBeRemovedUser removed user
     * @return true or false
     */
    public boolean removeUser(User willBeRemovedUser){
        
        try {
            for (int i = 0; i < getUserListInCourse().size(); ++i) {
                if (getUserInUserCourseList(i).getUserName() == willBeRemovedUser.getUserName()) {
                    getUserListInCourse().remove(i);
                    return true;
                }
            }
            throw new Exception();
        } catch (Exception exception) {
            System.err.println(willBeRemovedUser.getUserName() + "is not registered!");
            return false;

        }
    }

    /**
     * Takes document and adds to inside course
     * Returns true if operation is successful otherwise returns false
     * @param newDocument added document
     * @return true or false
     */
    public boolean addDocument(Document newDocument) {
        try {
            if (searchDocumentInCourse(newDocument)) {
                throw new Exception();
            }

            getDocumentListInCourse().add(newDocument);
            return true;
        } catch (Exception exception) {
            System.err.println("This document already exists!");
            return false;

        }

    }

    /**
     * Takes document and removes from inside course
     * Returns true if operation is successful otherwise returns false
     * @param willBeRemovedDocument removed document
     * @return true or false
     */
    public boolean removeDocument(Document willBeRemovedDocument) {

        try {
            for (int i = 0; i < getDocumentListInCourse().size(); ++i) {
                if (getDocumentInDocumantCourseList(i).getDocumentName() == willBeRemovedDocument.getDocumentName()) {
                    getDocumentListInCourse().remove(i);
                    return true;
                }
            }
            throw new Exception();
        } catch (Exception exception) {
            System.err.println(willBeRemovedDocument.getDocumentName() + "is not registered!");
            return false;

        }

    }

    /**
     * Takes assignment and adds to inside course
     * Returns true if operation is successful otherwise returns false
     * @param newAssignment added assignment
     * @return true or false
     */
    public boolean addAssignment(Assignment newAssignment) {
        try {
            if (searchAssignmentInCourse(newAssignment)) {
                throw new Exception();
            }
            getAssignmentListInCourse().add(newAssignment);

            return true;
        } catch (Exception exception) {
            System.err.println("This assignment already exists!");
            return false;
        }

    }

    /**
     * Takes assignment and removes from inside course
     * Returns true if operation is successful otherwise returns false
     * @param willBeRemovedAssignment assignment
     * @return true or false
     */
    public boolean removeAssignment(Assignment willBeRemovedAssignment) {

        try {
            for (int i = 0; i < getAssignmentListInCourse().size(); ++i) {
                if (getAssignmentInAssignmentCourseList(i).getAssignmentName() == willBeRemovedAssignment.getAssignmentName()) {
                    getAssignmentListInCourse().remove(i);
                    return true;
                }
            }
            throw new Exception();
        } catch (Exception exception) {
            System.err.println(willBeRemovedAssignment.getAssignmentName() + "is not registered!");
            return false;

        }

    }

    /**
     * Search document in course
     * If founded it returns true or otherwise returns false
     * @param targetDocument target document
     * @return true or false
     */
    public boolean searchDocumentInCourse(Document targetDocument) {

        for (int i = 0; i < getDocumentListInCourse().size(); ++i) {
            if (getDocumentInDocumantCourseList(i).getDocumentName() == targetDocument.getDocumentName()) {
                return true;
            }
        }

        return false;
    }

    /**
     * Search assignment in course
     * If founded it returns true or otherwise returns false
     * @param targetAssignment target assignment
     * @return true or false
     */
    public boolean searchAssignmentInCourse(Assignment targetAssignment) {

        for (int i = 0; i < getAssignmentListInCourse().size(); ++i) {
            if (getAssignmentInAssignmentCourseList(i).getAssignmentName() == targetAssignment.getAssignmentName()) {
                return true;
            }
        }

        return false;
    }

    /**
     * Search user in course
     * If founded it returns true or otherwise returns false
     * @param targetUser target user
     * @return true or false
     */
    public boolean searchUserInCourse(User targetUser) {

        for (int i = 0; i < getUserListInCourse().size(); ++i) {
            if (getUserInUserCourseList(i).getUserName() == targetUser.getUserName()) {
                return true;
            }
        }

        return false;
    }

    
    /**
     * Override toString method
     * @return course content as a string
     */
    public String toString() {

        String formatted = new String();

        formatted += String.format("\n|%s|", getCourseName());

        formatted += String.format("\n\n**Documents:\n");
        for (int i = 0; i < getDocumentListInCourse().size(); ++i) {
            if (getDocumentInDocumantCourseList(i) instanceof Book) {
                Book tempBook = (Book) getDocumentInDocumantCourseList(i);
                formatted += String.format("\n-Book : %s", tempBook.getDocumentName());
            } else if (getDocumentInDocumantCourseList(i) instanceof File) {
                File tempFile = (File) getDocumentInDocumantCourseList(i);
                formatted += String.format("\n-File : %s", tempFile.getDocumentName());
            } else if (getDocumentInDocumantCourseList(i) instanceof Slide) {
                Slide tempSlide = (Slide) getDocumentInDocumantCourseList(i);
                formatted += String.format("\n-Slide : %s", tempSlide.getDocumentName());
            } else if (getDocumentInDocumantCourseList(i) instanceof Url) {
                Url tempUrl = (Url) getDocumentInDocumantCourseList(i);
                formatted += String.format("\n-Url : %s", tempUrl.getDocumentName());
            } else if (getDocumentInDocumantCourseList(i) instanceof WhiteBoardDescriptions) {
                WhiteBoardDescriptions tempWhiteBoardDescriptions = (WhiteBoardDescriptions) getDocumentInDocumantCourseList(i);
                formatted += String.format("\n-White Board Description : %s", tempWhiteBoardDescriptions.getDocumentName());
            }

        }

        formatted += String.format("\n\n**Assignments:");
        for (int i = 0; i < getAssignmentListInCourse().size(); ++i) {
            if (getAssignmentInAssignmentCourseList(i) instanceof Quiz) {
                Quiz tempQuiz = (Quiz) getAssignmentInAssignmentCourseList(i);
                formatted += String.format("\n\n(Quiz)  %s", tempQuiz.getAssignmentName());
                formatted += String.format("\n-Deadline      : %s", tempQuiz.getDeadline());
                formatted += String.format("\n-Late deadline : %s", tempQuiz.getLateDeadLine());
            } else if (getAssignmentInAssignmentCourseList(i) instanceof HomeWork) {
                HomeWork tempHomeWork = (HomeWork) getAssignmentInAssignmentCourseList(i);
                formatted += String.format("\n\n(Homework)  %s", tempHomeWork.getAssignmentName());
                formatted += String.format("\nDeadline      : %s", tempHomeWork.getDeadline());
                formatted += String.format("\nLate deadline : %s", tempHomeWork.getLateDeadLine());
            } else if (getAssignmentInAssignmentCourseList(i) instanceof GroupProject) {
                GroupProject tempGroupProject = (GroupProject) getAssignmentInAssignmentCourseList(i);
                formatted += String.format("\n\n(Group Project)  %s", tempGroupProject.getAssignmentName());
                formatted += String.format("\nDeadline      : %s", tempGroupProject.getDeadline());
                formatted += String.format("\nLate deadline : %s", tempGroupProject.getLateDeadLine());

            }
        }

        return formatted;
    }
}
