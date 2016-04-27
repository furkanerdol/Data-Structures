/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HW01_131044065_Furkan_Erdol;

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
public class AdministratorTest {

    public Administrator admin = new Administrator("Furkan Erdol", "furkanerdol", "458769");
    public Teacher teacherA = new Teacher("Erdogan Sevilgen", "esevilgen", "165432");
    public Teacher teacherB = new Teacher("Yusuf Sinan Akgul", "ysakgul", "253156");
    public Teacher teacherC = new Teacher("Sample", "sample", "485127");
    public Student studentA = new Student("Sefa Nadir Yildiz", "snyildiz", "456879", "131044001");
    public Student studentB = new Student("Salih Bektas", "sbektas", "132546", "131044002");
    public Tutor tutorA = new Tutor("Furkan Tektas", "ftektas", "653241", "121044020");
    public Tutor tutorB = new Tutor("Necmettin Carkaci", "ncarkaci", "852369", "121044021");

    public Course courseA = new Course("CSE 122");
    public Course courseB = new Course("CSE 222");
    public Course courseC = new Course("Sample course");
    public Assignment quizA = new Quiz("First quiz", "06 January 2016", "07 January 2016");
    public Assignment quizB = new Quiz("Second quiz", "10 February 2016", "01 February 2016");
    public Document fileA = new File("Lesson lectures I");
    public Document fileB = new File("Lesson lectures II");

    public AdministratorTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        admin.addUser(teacherB);
        admin.addCourse(courseB);
        admin.addUserToCourse(courseB, teacherB);
        admin.addDocumentToCourse(courseB, fileB);
        admin.addAssignmentToCourse(courseB, quizB);
        studentB.requestForRegister();
        admin.addUser(tutorA);

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addUser method, of class Administrator.
     */
    @Test
    public void testAddUser() {

        boolean expResult = true;
        boolean result = admin.addUser(teacherC);
        assertEquals(expResult, result);

    }

    /**
     * Test of addCourse method, of class Administrator.
     */
    @Test
    public void testAddCourse() {

        boolean expResult = true;
        boolean result = admin.addCourse(courseC);
        assertEquals(expResult, result);

    }

    /**
     * Test of addDocumentToCourse method, of class Administrator.
     */
    @Test
    public void testAddDocumentToCourse() {

        boolean expResult = true;
        boolean result = admin.addDocumentToCourse(courseB, fileA);
        assertEquals(expResult, result);

    }

    /**
     * Test of addAssignmentToCourse method, of class Administrator.
     */
    @Test
    public void testAddAssignmentToCourse() {

        boolean expResult = true;
        boolean result = admin.addAssignmentToCourse(courseB, quizA);
        assertEquals(expResult, result);

    }

    /**
     * Test of addUserToCourse method, of class Administrator.
     */
    @Test
    public void testAddUserToCourse() {

        boolean expResult = true;
        boolean result = admin.addUserToCourse(courseB, teacherA);
        assertEquals(expResult, result);

    }

    /**
     * Test of removeUser method, of class Administrator.
     */
    @Test
    public void testRemoveUser() {

        boolean expResult = true;
        boolean result = admin.removeUser(teacherB);
        assertEquals(expResult, result);

    }

    /**
     * Test of removeCourse method, of class Administrator.
     */
    @Test
    public void testRemoveCourse() {

        boolean expResult = true;
        boolean result = admin.removeCourse(courseB);
        assertEquals(expResult, result);

    }

    /**
     * Test of removeDocumantFromCourse method, of class Administrator.
     */
    @Test
    public void testRemoveDocumantFromCourse() {

        boolean expResult = true;
        boolean result = admin.removeDocumantFromCourse(courseB, fileB);
        assertEquals(expResult, result);

    }

    /**
     * Test of removeAssignmentFromCourse method, of class Administrator.
     */
    @Test
    public void testRemoveAssignmentFromCourse() {

        boolean expResult = true;
        boolean result = admin.removeAssignmentFromCourse(courseB, quizB);
        assertEquals(expResult, result);

    }

    /**
     * Test of removeUserFromCourse method, of class Administrator.
     */
    @Test
    public void testRemoveUserFromCourse() {

        boolean expResult = true;
        boolean result = admin.removeUserFromCourse(courseB, teacherB);
        assertEquals(expResult, result);

    }

    /**
     * Test of addTutorADiffrentCourseAsAStudent method, of class Administrator.
     */
    @Test
    public void testAddTutorADiffrentCourseAsAStudent() {

        boolean expResult = true;
        boolean result = admin.addTutorADiffrentCourseAsAStudent(courseB, tutorA);
        assertEquals(expResult, result);

    }

    /**
     * Test of confirmRequests method, of class Administrator.
     */
    @Test
    public void testConfirmRequests() {

        boolean expResult = true;
        boolean result = admin.confirmRequests();
        assertEquals(expResult, result);

    }

    /**
     * Test of showRegisteredUsers method, of class Administrator.
     */
    @Test
    public void testShowRegisteredUsers() {

        admin.showRegisteredUsers();

    }

}
