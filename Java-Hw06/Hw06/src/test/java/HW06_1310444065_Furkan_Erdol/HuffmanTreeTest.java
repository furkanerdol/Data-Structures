package HW06_1310444065_Furkan_Erdol;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Furkan
 */
public class HuffmanTreeTest {
    
    public HuffmanTreeTest() {
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
     * Test of encode method, of class HuffmanTree.
     */
    @Test
    public void testEncode() throws Exception {
        System.out.println("encode");
        String message = "furkan";
        
        HuffmanTree Htree = new HuffmanTree();

        HuffmanTree.HuffData[] symbols = {
            new HuffmanTree.HuffData(186, '_'),
            new HuffmanTree.HuffData(103, 'e'),
            new HuffmanTree.HuffData(80, 't'),
            new HuffmanTree.HuffData(64, 'a'),
            new HuffmanTree.HuffData(63, 'o'),
            new HuffmanTree.HuffData(57, 'i'),
            new HuffmanTree.HuffData(57, 'n'),
            new HuffmanTree.HuffData(51, 's'),
            new HuffmanTree.HuffData(48, 'r'),
            new HuffmanTree.HuffData(47, 'h'),
            new HuffmanTree.HuffData(32, 'b'),
            new HuffmanTree.HuffData(32, 'l'),
            new HuffmanTree.HuffData(23, 'u'),
            new HuffmanTree.HuffData(22, 'c'),
            new HuffmanTree.HuffData(21, 'f'),
            new HuffmanTree.HuffData(20, 'm'),
            new HuffmanTree.HuffData(18, 'w'),
            new HuffmanTree.HuffData(16, 'y'),
            new HuffmanTree.HuffData(15, 'g'),
            new HuffmanTree.HuffData(15, 'p'),
            new HuffmanTree.HuffData(13, 'd'),
            new HuffmanTree.HuffData(8, 'v'),
            new HuffmanTree.HuffData(5, 'k'),
            new HuffmanTree.HuffData(1, 'j'),
            new HuffmanTree.HuffData(1, 'q'),
            new HuffmanTree.HuffData(1, 'x'),
            new HuffmanTree.HuffData(1, 'z')
        };

        Htree.buildTree(symbols);
        
        String expResult = "1100110000100101100001110100111";
        String result = Htree.encode(message, Htree.huffTree);
        
        assertEquals(expResult, result);
        
    }

   
    
   
  
}
