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
public class TowersOfHanoiTest {
    
    public TowersOfHanoiTest() {
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
     * Test of towersOfHanoi method, of class TowersOfHanoi.
     */
    @Test
    public void testTowersOfHanoi() {
        System.out.println("towersOfHanoi");
        
        int diskSize = 5;
        
        String nameSrc = "src";
        String nameAux = "aux";
        String nameDst = "dst";
        
        TowersOfHanoi instance = new TowersOfHanoi();
        boolean expResult = true;
        boolean result = instance.towersOfHanoi(diskSize, nameSrc, nameAux, nameDst);
        
        assertEquals(expResult, result);
        
    }
    
}
