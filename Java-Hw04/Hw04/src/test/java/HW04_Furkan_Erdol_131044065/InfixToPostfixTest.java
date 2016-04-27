/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HW04_Furkan_Erdol_131044065;

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
public class InfixToPostfixTest {
    
    /**
     *
     */
    public InfixToPostfixTest() {
    }
    
    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
    }
    
    /**
     *
     */
    @AfterClass
    public static void tearDownClass() {
    }
    
    /**
     *
     */
    @Before
    public void setUp() {
    }
    
    /**
     *
     */
    @After
    public void tearDown() {
    }

    /**
     * Test of convertInfixToPostfix method, of class InfixToPostfix.
     * @throws java.lang.Exception
     */
    @Test
    public void testConvertInfixToPostfix() throws Exception {
        System.out.println("convertInfixToPostfix");
        String infixExpression = "5 = 8 + 4";
        InfixToPostfix instance = new InfixToPostfix();
        String expResult = "5 8 4 + =";
        String result = instance.convertInfixToPostfix(infixExpression);
        assertEquals(expResult, result);
    }
    
}
