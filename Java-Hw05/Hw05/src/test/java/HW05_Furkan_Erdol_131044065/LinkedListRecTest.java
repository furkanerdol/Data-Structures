/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HW05_Furkan_Erdol_131044065;

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
public class LinkedListRecTest {
    
    public LinkedListRecTest() {
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
     * Test of remove method, of class LinkedListRec.
     */
    @org.junit.Test
    public void testRemove() {
        System.out.println("remove");
        Object outData = 5;
        LinkedListRec instance = new LinkedListRec();
        
        instance.add(5);
        instance.add(5);
        instance.add(4);
        instance.add(6);
        instance.add(89);
        instance.add(-5);
        instance.add(4);
        instance.add(8);
        instance.add(5);
        instance.add(7);
        
        boolean expResult = false;
        
        boolean result = instance.remove(outData);
        
        assertEquals(expResult, result);
    }

    
}
