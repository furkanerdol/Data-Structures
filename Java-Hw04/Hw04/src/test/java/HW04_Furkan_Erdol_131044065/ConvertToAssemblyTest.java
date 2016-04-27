package HW04_Furkan_Erdol_131044065;

import java.util.ArrayList;
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
public class ConvertToAssemblyTest {

    /**
     *
     */
    public ConvertToAssemblyTest() {
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
     * Test of convertInfixFileTOAssemblyFile method, of class ConvertToAssembly.
     * @throws java.lang.Exception
     */
    @Test
    public void testConvertInfixFileTOAssemblyFile() throws Exception {
        System.out.println("convertInfixFileTOAssemblyFile");
        String inputFileName = "testInput.txt";
        String outputFileName = "testOutput.asm";
        ConvertToAssembly instance = new ConvertToAssembly();
        ArrayList<String> expResult = new ArrayList<String>();

        expResult.add("li	$t0,4");
        expResult.add("li	$t1,3");
        expResult.add("li	$t2,12");
        expResult.add("li	$t3,3");
        expResult.add("mult	$t1,$t3");
        expResult.add("mflo	$t3");
        expResult.add("sub	$t4,$t0,$t3");
        expResult.add("move	$t1,$t4");
        expResult.add("li	$t3,3");
        expResult.add("div	$t0,$t3");
        expResult.add("mflo	$t3");
        expResult.add("mult	$t3,$t1");
        expResult.add("mflo	$t3");
        expResult.add("li	$t4,21");
        expResult.add("add	$t5,$t3,$t4");
        expResult.add("move	$t2,$t5");
        expResult.add("move	$a0,$t2");
        expResult.add("li	$v0,1");
        expResult.add("syscall");
            
        ArrayList<String> result = instance.convertInfixFileTOAssemblyFile(inputFileName, outputFileName);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of evaluate method, of class ConvertToAssembly.
     * @throws java.lang.Exception
     */
    @Test
    public void testEvaluate() throws Exception {
        System.out.println("evaluate");
        String postfixExpressionToConvert = "a 5 =";
        ConvertToAssembly instance = new ConvertToAssembly();
        instance.evaluate(postfixExpressionToConvert);
    }
}