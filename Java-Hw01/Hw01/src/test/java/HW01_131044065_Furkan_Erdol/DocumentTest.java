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
public class DocumentTest {

    public Document fileA = new File("Lesson lectures I");

    public DocumentTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getDocumentName method, of class Document.
     */
    @Test
    public void testGetDocumentName() {

        String expResult = "Lesson lectures I";
        String result = fileA.getDocumentName();
        assertEquals(expResult, result);

    }

    /**
     * Test of setDocumentName method, of class Document.
     */
    @Test
    public void testSetDocumentName() {

        fileA.setDocumentName("Sample");

    }

    /**
     * Test of toString method, of class Document.
     */
    @Test
    public void testToString() {

        String expResult = "\n-File : Lesson lectures I";
        String result = fileA.toString();
        assertEquals(expResult, result);

    }

    public class DocumentImpl extends Document {

        public DocumentImpl() {
            super("");
        }
    }

}
