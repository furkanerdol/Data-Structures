package HW01_131044065_Furkan_Erdol;

import java.util.ArrayList;

/**
 * Keeps data of assignment
 *
 * @author furkan
 */
public class Assignment implements AssignmentInterface {

    private String assignmentName;
    private String deadline;
    private String lateDeadline;
    private ArrayList<Student> studentListInAssignment = new ArrayList();
    private ArrayList<Integer> gradeListInAssignment = new ArrayList();

    /**
     * Takes three strings for assignment name, deadline and late deadline
     *
     * @param newAssignmentName
     * @param newDeadLine
     * @param newLateDeadLine
     */
    public Assignment(String newAssignmentName, String newDeadLine, String newLateDeadLine) {
        setAssignmentName(newAssignmentName);
        setDeadline(newDeadLine);
        setLateDeadLine(newLateDeadLine);
    }

    /**
     * Returns assignment name
     *
     * @return assignment name
     */
    public String getAssignmentName() {
        return assignmentName;
    }

    /**
     * Returns deadline
     *
     * @return deadline
     */
    public String getDeadline() {
        return deadline;
    }

    /**
     * Returns late deadline
     *
     * @return late deadline
     */
    public String getLateDeadLine() {
        return lateDeadline;
    }

    /**
     * Modify assignment name
     *
     * @param newAssignmentName assignment name
     */
    public void setAssignmentName(String newAssignmentName) {
        assignmentName = newAssignmentName;
    }

    /**
     * Modify deadline
     *
     * @param newDeadLine deadline
     */
    public void setDeadline(String newDeadLine) {
        deadline = newDeadLine;
    }

    /**
     * Modify late deadline
     *
     * @param newLateDeadLine late deadline
     */
    public void setLateDeadLine(String newLateDeadLine) {
        lateDeadline = newLateDeadLine;
    }

    /**
     * Returns student list
     *
     * @return student list
     */
    public ArrayList<Student> getStudentListInAssignment() {
        return studentListInAssignment;
    }

    /**
     * Returns student from student list
     *
     * @param index student's index
     * @return student
     */
    public Student getStudentInStudentListInAssignment(int index) {
        return studentListInAssignment.get(index);
    }

    /**
     * Returns grade list
     *
     * @return grade list
     */
    public ArrayList<Integer> getGradeListInAssignment() {
        return gradeListInAssignment;
    }

    /**
     * Returns grade from grade list
     *
     * @param index grade index
     * @return grade
     */
    public Integer getGradeInGradeListInAssignment(int index) {
        return gradeListInAssignment.get(index);
    }

    /**
     * Adds student to inside assignment Returns true if operation is successful
     * otherwise returns false
     *
     * @param studentName student name
     * @return true or false
     */
    public boolean addStudentToAssignment(Student studentName) {

        try {

            if (!studentName.searchUser(studentName)) {
                throw new MyException();
            } else {
                for (int i = 0; i < getStudentListInAssignment().size(); ++i) {
                    if (getStudentInStudentListInAssignment(i).getUserName() == studentName.getUserName()) {
                        throw new Exception();
                    }
                }
                getStudentListInAssignment().add(studentName);
                getGradeListInAssignment().add(90);

                return true;

            }
        } catch (MyException exception) {
            System.err.println("You are not registered system!");
            return false;
        } catch (Exception exception) {
            System.err.println("Your assignment already uploaded!");
            return false;
        }

    }

    /**
     * Override toString method
     *
     * @return the information of assignment as a string
     */
    public String toString() {

        String formatted = new String();

        if (this instanceof Quiz) {
            Quiz tempQuiz = (Quiz) this;
            formatted += String.format("\n\n(Quiz)  %s", tempQuiz.getAssignmentName());
            formatted += String.format("\n-Deadline      : %s", tempQuiz.getDeadline());
            formatted += String.format("\n-Late deadline : %s", tempQuiz.getLateDeadLine());
        } else if (this instanceof HomeWork) {
            HomeWork tempHomeWork = (HomeWork) this;
            formatted += String.format("\n\n(Homework)  %s", tempHomeWork.getAssignmentName());
            formatted += String.format("\nDeadline      : %s", tempHomeWork.getDeadline());
            formatted += String.format("\nLate deadline : %s", tempHomeWork.getLateDeadLine());
        } else if (this instanceof GroupProject) {
            GroupProject tempGroupProject = (GroupProject) this;
            formatted += String.format("\n\n(Group Project)  %s", tempGroupProject.getAssignmentName());
            formatted += String.format("\nDeadline      : %s", tempGroupProject.getDeadline());
            formatted += String.format("\nLate deadline : %s", tempGroupProject.getLateDeadLine());

        }
        return formatted;
    }

}
