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
public class StudentTest {

    public Administrator admin = new Administrator("Furkan Erdol", "furkanerdol", "458769");
    public Student studentA = new Student("Sefa Nadir Yildiz", "snyildiz", "456879", "131044001");
    public Assignment quizA = new Quiz("First quiz", "06 January 2016", "07 January 2016");

    public StudentTest() {
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
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getStudentID method, of class Student.
     */
    @Test
    public void testGetStudentID() {

        String expResult = "131044001";
        String result = studentA.getStudentID();
        assertEquals(expResult, result);

    }

    /**
     * Test of setStudentID method, of class Student.
     */
    @Test
    public void testSetStudentID() {

        studentA.setStudentID("131044065");

    }

    /**
     * Test of uploadAssignment method, of class Student.
     */
    @Test
    public void testUploadAssignment() {

        boolean expResult = true;
        boolean result = studentA.uploadAssignment(quizA);
        assertEquals(expResult, result);

    }

    /**
     * Test of requestForRegister method, of class Student.
     */
    @Test
    public void testRequestForRegister() {

        boolean expResult = true;
        boolean result = studentA.requestForRegister();
        assertEquals(expResult, result);

    }

}
