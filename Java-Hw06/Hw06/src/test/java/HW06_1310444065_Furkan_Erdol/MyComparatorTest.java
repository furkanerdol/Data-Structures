package HW06_1310444065_Furkan_Erdol;

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
public class MyComparatorTest {
    
    public MyComparatorTest() {
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
     * Test of compare method, of class MyComparator.
     */
    @Test
    public void testCompare() {
        System.out.println("compare");
        Object o1 = 1;
        Object o2 = 1;
        MyComparator instance = new MyComparator();
        int expResult = 0;
        int result = instance.compare(o1, o2);
        assertEquals(expResult, result);
       
    }
    
}
