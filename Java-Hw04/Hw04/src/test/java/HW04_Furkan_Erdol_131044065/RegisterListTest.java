package HW04_Furkan_Erdol_131044065;

import HW04_Furkan_Erdol_131044065.AbstractConvertToAssembly.Register;
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
public class RegisterListTest {
    
    /**
     *
     */
    public RegisterListTest() {
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
     * Test of addRegister method, of class RegisterList.
     */
    @Test
    public void testAddRegister() {
        System.out.println("addRegister");
        Object newRegister = new Register();
        RegisterList instance = new RegisterList();
        boolean expResult = true;
        boolean result = instance.addRegister(newRegister);
        assertEquals(expResult, result);
        
    }
    
}
