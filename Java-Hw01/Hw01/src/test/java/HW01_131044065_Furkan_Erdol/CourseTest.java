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
public class CourseTest {

    public Student studentA = new Student("Sefa Nadir Yildiz", "snyildiz", "456879", "131044001");
    Student studentB = new Student("Salih Bektas", "sbektas", "132546", "131044002");

    public Course courseA = new Course("CSE 122");
    public Document fileA = new File("Lesson lectures I");
    public Document fileB = new File("Lesson lectures II");
    public Assignment quizA = new Quiz("First quiz", "06 January 2016", "07 January 2016");
    public Assignment quizB = new Quiz("Second quiz", "10 February 2016", "01 February 2016");
    private ArrayList<User> userListInCourse = new ArrayList();
    private ArrayList<Document> documentListInCourse = new ArrayList();
    private ArrayList<Assignment> assignmentListInCourse = new ArrayList();

    public CourseTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        courseA.addUser(studentA);
        courseA.addDocument(fileA);
        courseA.addAssignment(quizA);

        userListInCourse.add(studentA);
        documentListInCourse.add(fileA);
        assignmentListInCourse.add(quizA);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getCourseName method, of class Course.
     */
    @Test
    public void testGetCourseName() {

        String expResult = "CSE 122";
        String result = courseA.getCourseName();
        assertEquals(expResult, result);

    }

    /**
     * Test of setCourseName method, of class Course.
     */
    @Test
    public void testSetCourseName() {

        courseA.setCourseName("Sample");

    }

    /**
     * Test of getUserListInCourse method, of class Course.
     */
    @Test
    public void testGetUserListInCourse() {

        ArrayList<User> expResult = userListInCourse;
        ArrayList<User> result = courseA.getUserListInCourse();
        assertEquals(expResult, result);

    }

    /**
     * Test of getUserInUserCourseList method, of class Course.
     */
    @Test
    public void testGetUserInUserCourseList() {

        int index = 0;

        User expResult = studentA;
        User result = courseA.getUserInUserCourseList(index);
        assertEquals(expResult, result);

    }

    /**
     * Test of getDocumentListInCourse method, of class Course.
     */
    @Test
    public void testGetDocumentListInCourse() {

        ArrayList<Document> expResult = documentListInCourse;
        ArrayList<Document> result = courseA.getDocumentListInCourse();
        assertEquals(expResult, result);

    }

    /**
     * Test of getDocumentInDocumantCourseList method, of class Course.
     */
    @Test
    public void testGetDocumentInDocumantCourseList() {

        int index = 0;

        Document expResult = fileA;
        Document result = courseA.getDocumentInDocumantCourseList(index);
        assertEquals(expResult, result);

    }

    /**
     * Test of getAssignmentListInCourse method, of class Course.
     */
    @Test
    public void testGetAssignmentListInCourse() {

        ArrayList<Assignment> expResult = assignmentListInCourse;
        ArrayList<Assignment> result = courseA.getAssignmentListInCourse();
        assertEquals(expResult, result);

    }

    /**
     * Test of getAssignmentInAssignmentCourseList method, of class Course.
     */
    @Test
    public void testGetAssignmentInAssignmentCourseList() {

        int index = 0;

        Assignment expResult = quizA;
        Assignment result = courseA.getAssignmentInAssignmentCourseList(index);
        assertEquals(expResult, result);

    }

    /**
     * Test of addUser method, of class Course.
     */
    @Test
    public void testAddUser() {

        boolean expResult = true;
        boolean result = courseA.addUser(studentB);
        assertEquals(expResult, result);

    }

    /**
     * Test of removeUser method, of class Course.
     */
    @Test
    public void testRemoveUser() {

        boolean expResult = true;
        boolean result = courseA.removeUser(studentA);
        assertEquals(expResult, result);

    }

    /**
     * Test of addDocument method, of class Course.
     */
    @Test
    public void testAddDocument() {

        boolean expResult = true;
        boolean result = courseA.addDocument(fileB);
        assertEquals(expResult, result);

    }

    /**
     * Test of removeDocument method, of class Course.
     */
    @Test
    public void testRemoveDocument() {

        boolean expResult = true;
        boolean result = courseA.removeDocument(fileA);
        assertEquals(expResult, result);

    }

    /**
     * Test of addAssignment method, of class Course.
     */
    @Test
    public void testAddAssignment() {

        boolean expResult = true;
        boolean result = courseA.addAssignment(quizB);
        assertEquals(expResult, result);

    }

    /**
     * Test of removeAssignment method, of class Course.
     */
    @Test
    public void testRemoveAssignment() {

        boolean expResult = true;
        boolean result = courseA.removeAssignment(quizA);
        assertEquals(expResult, result);

    }

    /**
     * Test of searchDocumentInCourse method, of class Course.
     */
    @Test
    public void testSearchDocumentInCourse() {

        boolean expResult = true;
        boolean result = courseA.searchDocumentInCourse(fileA);
        assertEquals(expResult, result);

    }

    /**
     * Test of searchAssignmentInCourse method, of class Course.
     */
    @Test
    public void testSearchAssignmentInCourse() {

        boolean expResult = true;
        boolean result = courseA.searchAssignmentInCourse(quizA);
        assertEquals(expResult, result);

    }

    /**
     * Test of searchUserInCourse method, of class Course.
     */
    @Test
    public void testSearchUserInCourse() {

        boolean expResult = true;
        boolean result = courseA.searchUserInCourse(studentA);
        assertEquals(expResult, result);

    }

    /**
     * Test of toString method, of class Course.
     */
    @Test
    public void testToString() {

        String expResult = courseA.toString();
        String result = courseA.toString();
        assertEquals(expResult, result);

    }

}
