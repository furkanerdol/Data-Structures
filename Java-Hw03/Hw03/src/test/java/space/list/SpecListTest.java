/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space.list;


import java.util.Collection;
import java.util.LinkedList;
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
public class SpecListTest {
    
    public SpecListTest() {
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
     * Test of addAllAtHead method, of class SpecList.
     */
    @org.junit.Test
    public void testAddAllAtHead() {
        System.out.println("addAllAtHead");
        
        Collection c = new LinkedList();
        c.add("F");
        c.add("U");
        c.add("R");
        c.add("K");
        c.add("A");
        c.add("N");
               
        SpecList instance = new SpecList();
        instance.add('I');
        instance.add('D');
        instance.add('Q');
        instance.add('T');
        instance.add('O');
               
        
        boolean expResult = true;
        boolean result = instance.addAllAtHead(c);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getIntersectList method, of class SpecList.
     */
    @org.junit.Test
    public void testGetIntersectList() {
        System.out.println("getIntersectList");
        
        Collection c = new LinkedList();
        c.add('B');
        c.add('U');
        c.add('R');
        c.add('A');
        c.add('K');
        
               
        SpecList instance = new SpecList();
        instance.add('F');
        instance.add('U');
        instance.add('R');
        instance.add('K');
        instance.add('A');
        instance.add('N');
               
        List expResult = new SpecList();
        expResult.add('U');
        expResult.add('R');
        expResult.add('A');
        expResult.add('K');
        
        
        List result = instance.getIntersectList(c);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of sortList method, of class SpecList.
     */
    @org.junit.Test
    public void testSortList() throws Exception {
        System.out.println("sortList");
        int decreasingIncreasing = 1;
        
        SpecList instance = new SpecList();
        instance.add(5);
        instance.add(9);
        instance.add(54);
        instance.add(65);
        instance.add(-8);
        instance.add(7);
        instance.add(74);
        instance.add(63);
        instance.add(0);
        
        List expResult = new SpecList();
        expResult.add(-8);
        expResult.add(0);
        expResult.add(5);
        expResult.add(7);
        expResult.add(9);
        expResult.add(54);
        expResult.add(63);
        expResult.add(65);
        expResult.add(74);
        
        List result = instance.sortList(decreasingIncreasing);
        assertEquals(expResult, result);
        
    }
    
}
