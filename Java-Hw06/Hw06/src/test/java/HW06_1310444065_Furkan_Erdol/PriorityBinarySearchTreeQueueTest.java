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
public class PriorityBinarySearchTreeQueueTest {
    
    public PriorityBinarySearchTreeQueueTest() {
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
     * Test of enqueue method, of class PriorityBinarySearchTreeQueue.
     */
    @Test
    public void testEnqueue() {
        System.out.println("enqueue");
        Object addData = "furkan";
        PriorityBinarySearchTreeQueue instance = new PriorityBinarySearchTreeQueue();
        Object expResult = "furkan";
        Object result = instance.enqueue(addData);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of dequeue method, of class PriorityBinarySearchTreeQueue.
     */
    @Test
    public void testDequeue() {
        System.out.println("dequeue");
         Object addData = "furkan";
        PriorityBinarySearchTreeQueue instance = new PriorityBinarySearchTreeQueue();
        Object expResult = "furkan";
        instance.enqueue(addData);
        Object result = instance.dequeue();
        assertEquals(expResult, result);

    }

    /**
     * Test of isEmpty method, of class PriorityBinarySearchTreeQueue.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        PriorityBinarySearchTreeQueue instance = new PriorityBinarySearchTreeQueue();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);

    }

    /**
     * Test of size method, of class PriorityBinarySearchTreeQueue.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        PriorityBinarySearchTreeQueue instance = new PriorityBinarySearchTreeQueue();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
     
    }

  
    
}
