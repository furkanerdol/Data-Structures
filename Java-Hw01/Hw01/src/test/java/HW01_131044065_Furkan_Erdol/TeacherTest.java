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
public class TeacherTest {
    
    
    public Administrator admin = new Administrator("Furkan Erdol", "furkanerdol", "458769");
    public Teacher teacherA = new Teacher("Erdogan Sevilgen", "esevilgen", "165432");
    public Teacher teacherB = new Teacher("Yusuf Sinan Akgul", "ysakgul", "253156");
    public Student studentA = new Student("Sefa Nadir Yildiz", "snyildiz", "456879", "131044001");
    public Student studentB = new Student("Salih Bektas", "sbektas", "132546", "131044002");
    public Student studentC = new Student("Sample student", "sstudent", "456879", "100000000");    
    public Tutor tutorA = new Tutor("Furkan Tektas", "ftektas", "653241", "121044020");
    public Tutor tutorB = new Tutor("Necmettin Carkaci", "ncarkaci", "852369", "121044021");
    public Course courseA = new Course("CSE 122");
    public Course courseB = new Course("CSE 222");
    public Course courseC = new Course("Sample course3");
    public Assignment quizA = new Quiz("First quiz", "06 January 2016", "07 January 2016");
    public Assignment quizB = new Quiz("Second quiz", "10 February 2016", "01 February 2016");
    public Assignment quizC = new Quiz("Sample quiz", "15 February 2016", "16 February 2016");
    public Document fileA = new File("Lesson lectures I");
    public Document fileB = new File("Lesson lectures II");
    
    public TeacherTest() {
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
        admin.addUser(studentB);
        admin.addCourse(courseB);
        admin.addUserToCourse(courseB, teacherB);
        admin.addDocumentToCourse(courseB, fileB);
        admin.addAssignmentToCourse(courseB, quizB);
        studentB.requestForRegister();
        admin.addUser(tutorA);
        admin.addUser(studentC);
        admin.addCourse(courseC);
        admin.addUserToCourse(courseC, studentC);
    }
    
    @After
    public void tearDown() {
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
        boolean result = admin.addAssignmentToCourse(courseB, quizC);
        assertEquals(expResult, result);

    }

    /**
     * Test of addUserToCourse method, of class Administrator.
     */
    @Test
    public void testAddUserToCourse() {

        boolean expResult = true;
        boolean result = admin.addUserToCourse(courseB, studentB);
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
        boolean result = admin.removeUserFromCourse(courseC, studentC);
        assertEquals(expResult, result);

    }
    
}
