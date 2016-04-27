package HW05_Furkan_Erdol_131044065;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Furkan
 */
public class SortedListsTest {

    public SortedListsTest() {

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
     * Test of intersectionOfLists method, of class SortedLists.
     */
    @Test
    public void testIntersectionOfLists() {
        System.out.println("intersectionOfLists");

        try {

            ArrayList arraylistOne = new ArrayList();
            arraylistOne.add(9);
            arraylistOne.add(10);
            arraylistOne.add(85);
            arraylistOne.add(-5);
            arraylistOne.add(-10);
            arraylistOne.add(-3);
            arraylistOne.add(7);
            arraylistOne.add(-10);
            arraylistOne.add(0);
            arraylistOne.add(73);

            ArrayList arraylistTwo = new ArrayList();
            arraylistTwo.add(93);
            arraylistTwo.add(25);
            arraylistTwo.add(-7);
            arraylistTwo.add(85);
            arraylistTwo.add(-10);
            arraylistTwo.add(77);
            arraylistTwo.add(10);
            arraylistTwo.add(-10);
            arraylistTwo.add(10);

            SortedLists instance = new SortedLists(arraylistOne, arraylistTwo);

            ArrayList resultList = new ArrayList();
            resultList.add(85);
            resultList.add(10);
            resultList.add(-10);
           
            List expResult = resultList;
            List result = instance.intersectionOfLists();
            assertEquals(expResult, result);

        } catch (TypeMismatchException exception) {
            System.err.println("Type mismatch !!!");
        }

    }

    /**
     * Test of unionOfLists method, of class SortedLists.
     */
    @Test
    public void testUnionOfLists() {
        System.out.println("unionOfLists");
     
        try {

            ArrayList arraylistOne = new ArrayList();
            arraylistOne.add(9);
            arraylistOne.add(10);
            arraylistOne.add(85);
            arraylistOne.add(-5);
            arraylistOne.add(-10);
            arraylistOne.add(-3);
            arraylistOne.add(7);
            arraylistOne.add(0);

            ArrayList arraylistTwo = new ArrayList();
            arraylistTwo.add(93);
            arraylistTwo.add(25);
            arraylistTwo.add(-7);
            arraylistTwo.add(85);
            arraylistTwo.add(77);
            arraylistTwo.add(10);

            SortedLists instance = new SortedLists(arraylistOne, arraylistTwo);

            ArrayList resultList = new ArrayList();
            resultList.add(85);
            resultList.add(10);
            resultList.add(9);
            resultList.add(93);
            resultList.add(7);
            resultList.add(85);
            resultList.add(0);
            resultList.add(77);
            resultList.add(-5);
            resultList.add(25);
            resultList.add(-3);
            resultList.add(10);
            resultList.add(-10);
            resultList.add(-7);
         
            List expResult = resultList;
            List result = instance.unionOfLists();
            assertEquals(expResult, result);

        } catch (TypeMismatchException exception) {
            System.err.println("Type mismatch !!!");
        }
 
        
    }

    /**
     * Test of isSubset method, of class SortedLists.
     */
    @Test
    public void testIsSubset() {
        System.out.println("isSubset");
       
        try {

            ArrayList arraylistOne = new ArrayList();
            arraylistOne.add(9);
            arraylistOne.add(10);
            arraylistOne.add(85);
            arraylistOne.add(-5);
            arraylistOne.add(-10);
            arraylistOne.add(-3);
            arraylistOne.add(7);
            arraylistOne.add(0);

            ArrayList arraylistTwo = new ArrayList();
            arraylistTwo.add(0);
            arraylistTwo.add(85);
            arraylistTwo.add(-3);
            arraylistTwo.add(9);

            SortedLists instance = new SortedLists(arraylistOne, arraylistTwo);
           
            boolean expResult = true;
            boolean result = instance.isSubset();
            assertEquals(expResult, result);

        } catch (TypeMismatchException exception) {
            System.err.println("Type mismatch !!!");
        }
       
    }
}
