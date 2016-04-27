/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HW01_131044065_Furkan_Erdol;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author furkan
 */
public class AssignmentTest {

    public Administrator admin = new Administrator("Furkan Erdol", "furkanerdol", "458769");
    public Assignment quizA = new Quiz("First quiz", "06 January 2016", "07 January 2016");
    public Assignment quizB = new Quiz("Second quiz", "10 February 2016", "01 February 2016");
    public Student studentA = new Student("Sefa Nadir Yildiz", "snyildiz", "456879", "131044001");
    public Course courseA = new Course("CSE 122");
    public String assignmentName = "First quiz";
    public String deadline = "06 January 2016";
    public String lateDeadline = "07 January 2016";
    public ArrayList<Student> studentListInAssignment = new ArrayList();
    public ArrayList<Integer> gradeListInAssignment = new ArrayList();

    public AssignmentTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        admin.addUser(studentA);
        admin.addAssignmentToCourse(courseA, quizB);
        admin.addUserToCourse(courseA, studentA);
        studentA.uploadAssignment(quizB);
    }

    @After
    public void tearDown() {

    }

    /**
     * Test of getAssignmentName method, of class Assignment.
     */
    @Test
    public void testGetAssignmentName() {

        String expResult = "First quiz";
        String result = quizA.getAssignmentName();
        assertEquals(expResult, result);

    }

    /**
     * Test of getDeadline method, of class Assignment.
     */
    @Test
    public void testGetDeadline() {

        String expResult = "06 January 2016";
        String result = quizA.getDeadline();
        assertEquals(expResult, result);

    }

    /**
     * Test of getLateDeadLine method, of class Assignment.
     */
    @Test
    public void testGetLateDeadLine() {

        String expResult = "07 January 2016";
        String result = quizA.getLateDeadLine();
        assertEquals(expResult, result);

    }

    /**
     * Test of setAssignmentName method, of class Assignment.
     */
    @Test
    public void testSetAssignmentName() {

        quizA.setAssignmentName("Sample");

    }

    /**
     * Test of setDeadline method, of class Assignment.
     */
    @Test
    public void testSetDeadline() {

        quizA.setDeadline("11 April 2016");

    }

    /**
     * Test of setLateDeadLine method, of class Assignment.
     */
    @Test
    public void testSetLateDeadLine() {

        quizA.setLateDeadLine("11 April 2016");

    }

    /**
     * Test of getStudentListInAssignment method, of class Assignment.
     */
    @Test
    public void testGetStudentListInAssignment() {

        ArrayList<Student> expResult = studentListInAssignment;
        ArrayList<Student> result = quizA.getStudentListInAssignment();
        assertEquals(expResult, result);

    }

    /**
     * Test of getStudentInStudentListInAssignment method, of class Assignment.
     */
    @Test
    public void testGetStudentInStudentListInAssignment() {

        int index = 0;

        Student expResult = studentA;
        Student result = quizB.getStudentInStudentListInAssignment(index);
        assertEquals(expResult, result);

    }

    /**
     * Test of getGradeListInAssignment method, of class Assignment.
     */
    @Test
    public void testGetGradeListInAssignment() {

        ArrayList<Integer> expResult = gradeListInAssignment;
        ArrayList<Integer> result = quizA.getGradeListInAssignment();
        assertEquals(expResult, result);

    }

    /**
     * Test of getGradeInGradeListInAssignment method, of class Assignment.
     */
    @Test
    public void testGetGradeInGradeListInAssignment() {

        int index = 0;

        Integer expResult = 90;
        Integer result = quizB.getGradeInGradeListInAssignment(index);
        assertEquals(expResult, result);

    }

    /**
     * Test of addStudentToAssignment method, of class Assignment.
     */
    @Test
    public void testAddStudentToAssignment() {

        boolean expResult = false;
        boolean result = quizB.addStudentToAssignment(studentA);
        assertEquals(expResult, result);

    }

    /**
     * Test of toString method, of class Assignment.
     */
    @Test
    public void testToString() {

        String expResult = quizA.toString();
        String result = quizA.toString();
        assertEquals(expResult, result);

    }

}
