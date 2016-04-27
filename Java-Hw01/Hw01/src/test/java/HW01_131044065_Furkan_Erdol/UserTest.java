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
public class UserTest {

    public Administrator admin = new Administrator("Furkan Erdol", "furkanerdol", "458769");
    public Teacher teacherA = new Teacher("Erdogan Sevilgen", "esevilgen", "165432");
    public Teacher teacherB = new Teacher("Yusuf Sinan Akgul", "ysakgul", "253156");
    public Teacher teacherC = new Teacher("Sample2", "sample2", "485127");
    public Student studentA = new Student("Sefa Nadir Yildiz", "snyildiz", "456879", "131044001");
    public Student studentB = new Student("Salih Bektas", "sbektas", "132546", "131044002");
    public Tutor tutorA = new Tutor("Furkan Tektas", "ftektas", "653241", "121044020");
    public Tutor tutorB = new Tutor("Necmettin Carkaci", "ncarkaci", "852369", "121044021");

    public Course courseA = new Course("CSE 122");
    public Course courseB = new Course("CSE 222");
    public Course courseC = new Course("Sample course2");
    public Course courseD = new Course("Sample course4");
    public Assignment quizA = new Quiz("First quiz", "06 January 2016", "07 January 2016");
    public Assignment quizB = new Quiz("Second quiz", "10 February 2016", "01 February 2016");
    public Document fileA = new File("Lesson lectures I");
    public Document fileB = new File("Lesson lectures II");

    public ArrayList<User> userList = new ArrayList();
    public ArrayList<Course> courseList = new ArrayList();
    public ArrayList<Course> oldCourseList = new ArrayList();
    public ArrayList<Student> requestStudentList = new ArrayList();

    public UserTest() {
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

        admin.addCourse(courseC);
        admin.removeCourse(courseC);

        admin.addCourse(courseD);

        userList = admin.getUserList();
        courseList = admin.getCourseList();
        oldCourseList = admin.getOldCourseList();
        requestStudentList = admin.getRequestStudentList();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getPersonName method, of class User.
     */
    @Test
    public void testGetPersonName() {

        String expResult = "Furkan Erdol";
        String result = admin.getPersonName();
        assertEquals(expResult, result);

    }

    /**
     * Test of getUserName method, of class User.
     */
    @Test
    public void testGetUserName() {

        String expResult = "furkanerdol";
        String result = admin.getUserName();
        assertEquals(expResult, result);

    }

    /**
     * Test of getUserPassword method, of class User.
     */
    @Test
    public void testGetUserPassword() {

        String expResult = "458769";
        String result = admin.getUserPassword();
        assertEquals(expResult, result);

    }

    /**
     * Test of setPersonName method, of class User.
     */
    @Test
    public void testSetPersonName() {

        admin.setPersonName("Sample name");

    }

    /**
     * Test of setUserName method, of class User.
     */
    @Test
    public void testSetUserName() {

        admin.setUserName("Sample user name");

    }

    /**
     * Test of setUserPassword method, of class User.
     */
    @Test
    public void testSetUserPassword() {

        admin.setUserPassword("125463");

    }

    /**
     * Test of getUserList method, of class User.
     */
    @Test
    public void testGetUserList() {

        ArrayList<User> expResult = userList;
        ArrayList<User> result = admin.getUserList();
        assertEquals(expResult, result);

    }

    /**
     * Test of getUserInUserList method, of class User.
     */
    @Test
    public void testGetUserInUserList() {

        int index = 0;

        User expResult = userList.get(index);
        User result = admin.getUserInUserList(index);
        assertEquals(expResult, result);

    }

    /**
     * Test of getCourseList method, of class User.
     */
    @Test
    public void testGetCourseList() {

        ArrayList<Course> expResult = courseList;
        ArrayList<Course> result = admin.getCourseList();
        assertEquals(expResult, result);

    }

    /**
     * Test of getCourseInCourseList method, of class User.
     */
    @Test
    public void testGetCourseInCourseList() {

        int index = 0;

        Course expResult = courseList.get(index);
        Course result = admin.getCourseInCourseList(index);
        assertEquals(expResult, result);

    }

    /**
     * Test of getOldCourseList method, of class User.
     */
    @Test
    public void testGetOldCourseList() {

        ArrayList<Course> expResult = oldCourseList;
        ArrayList<Course> result = admin.getOldCourseList();
        assertEquals(expResult, result);

    }

    /**
     * Test of getCourseInOldCourseList method, of class User.
     */
    @Test
    public void testGetCourseInOldCourseList() {

        int index = 0;

        Course expResult = oldCourseList.get(index);
        Course result = admin.getCourseInOldCourseList(index);
        assertEquals(expResult, result);

    }

    /**
     * Test of getRequestStudentList method, of class User.
     */
    @Test
    public void testGetRequestStudentList() {

        ArrayList<Student> expResult = requestStudentList;
        ArrayList<Student> result = admin.getRequestStudentList();
        assertEquals(expResult, result);

    }

    /**
     * Test of getStudentInRequestStudentList method, of class User.
     */
    @Test
    public void testGetStudentInRequestStudentList() {

        int index = 0;

        Student expResult = requestStudentList.get(index);
        Student result = admin.getStudentInRequestStudentList(index);
        assertEquals(expResult, result);

    }

    /**
     * Test of searchUser method, of class User.
     */
    @Test
    public void testSearchUser() {

        boolean expResult = true;
        boolean result = admin.searchUser(teacherB);
        assertEquals(expResult, result);

    }

    /**
     * Test of searchCourse method, of class User.
     */
    @Test
    public void testSearchCourse() {

        boolean expResult = true;
        boolean result = admin.searchCourse(courseB);
        assertEquals(expResult, result);

    }

    /**
     * Test of showRegisteredCourses method, of class User.
     */
    @Test
    public void testShowRegisteredCourses() {

        admin.showRegisteredCourses();

    }

    /**
     * Test of showOldCourses method, of class User.
     */
    @Test
    public void testShowOldCourses() {

        admin.showOldCourses();

    }

    /**
     * Test of showCourseContent method, of class User.
     */
    @Test
    public void testShowCourseContent() {

        admin.showCourseContent(courseB);

    }


    /**
     * Test of addUser method, of class User.
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
        boolean result = admin.addDocumentToCourse(courseD, fileB);
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

    public class UserImpl extends User {

        public UserImpl() {
            super("", "", "");
        }

        public boolean addUser(User newUser) {
            return false;
        }

        public boolean addCourse(Course newCourse) {
            return false;
        }

        public boolean addDocumentToCourse(Course courseObject, Document newDocument) {
            return false;
        }

        public boolean addAssignmentToCourse(Course courseObject, Assignment newAssignment) {
            return false;
        }

        public boolean addUserToCourse(Course courseObject, User newUser) {
            return false;
        }

        public boolean removeUser(User willBeRemovedUser) {
            return false;
        }

        public boolean removeCourse(Course willBeRemovedCourse) {
            return false;
        }

        public boolean removeDocumantFromCourse(Course courseObject, Document willBeRemovedDocument) {
            return false;
        }

        public boolean removeAssignmentFromCourse(Course courseObject, Assignment willBeRemovedAssignment) {
            return false;
        }

        public boolean removeUserFromCourse(Course courseObject, User willBeRemovedUser) {
            return false;
        }
    }

}
