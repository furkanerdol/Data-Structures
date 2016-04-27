package HW01_131044065_Furkan_Erdol;

/**
 * Tutor class
 *
 * @author furkan
 */
public class Tutor extends Student {

    /**
     * Takes four strings for name, username, password and student id
     *
     * @param newPersonName person name
     * @param newUserName user name
     * @param newUserPassword user password
     * @param newStudentID student id
     */
    public Tutor(String newPersonName, String newUserName, String newUserPassword, String newStudentID) {
        super(newPersonName, newUserName, newUserPassword, newStudentID);
    }

    /**
     * Prints the screen old courses
     */
    public void showOldCourses() {
        System.out.printf("\n\n########## OLD COURSES ########## \n");

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
     * Override toString method
     *
     * @return the profile of administrator as a string
     */
    public String toString() {

        String formatted = new String();

        formatted += String.format("\n|Tutor|         Person's name: %-21s   Username: %-12s   Password: %s   Student ID: %s",
                getPersonName(), getUserName(), getUserPassword(), getStudentID());

        return formatted;
    }

}
