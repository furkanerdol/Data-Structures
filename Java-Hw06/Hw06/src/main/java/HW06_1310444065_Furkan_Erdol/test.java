package HW06_1310444065_Furkan_Erdol;

import java.util.Iterator;

/**
 * Test class
 *
 * @author Furkan
 */
public class test {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {

        HuffmanTree Htree = new HuffmanTree();

        // Create symbol array
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

        // Build hufffman tree 
        Htree.buildTree(symbols);
        

        // Encode huffman code
        System.out.println("########## Test encode method ##########");
        try {
            System.out.println("\n### Encode");
            System.out.println("Message : furkan");
            String encode = Htree.encode("furkan", Htree.huffTree);
            System.out.println("Encoded : " + encode);
            
            // Decode huffman codes to symbols
            System.out.println("### Decode");
            String decodedCode = Htree.decode(encode);
            System.out.println("Code to Message : \n" + encode + " : " + decodedCode);
            
            
            System.out.println("\n### Encode");
            System.out.println("Message : data_structures");
            String encodeTwo = Htree.encode("data_structures", Htree.huffTree);
            System.out.println("Encoded : " + encodeTwo);
            
            // Decode huffman codes to symbols
            System.out.println("### Decode");
            String decodedCodeTwo = Htree.decode(encodeTwo);
            System.out.println("Code to Message : \n" + encodeTwo + " : " + decodedCodeTwo);
        
        } catch (HuffmanTree.EmptyTreeException exception) {
            System.err.println("tree bos");

        } catch (HuffmanTree.IllegalMessageException exception) {
            System.err.println("message is not legal");
        }

        
        System.out.println("\n\n########## Test binary search tree iterator ##########");
        System.out.println("\n### Binary search tree");
        BinarySearchTree<Integer> Btree = new BinarySearchTree<>();
       
        Btree.add(2);
        Btree.add(1);
        Btree.add(12);
        Btree.add(20);
        Btree.add(11);
        Btree.add(325);
        Btree.add(150);
        Btree.add(15);
        Btree.add(6);
        Btree.add(0);
        Btree.add(7);

        System.out.println(Btree.toString());
        
        Iterator iter = Btree.getAscendingOrderIterator();

        System.out.println("### Next method");
        while (iter.hasNext()) {        
            System.out.println("Next item -> " + iter.next() + "(remove)");
            iter.remove();
        }

        System.out.println("\n### Binary search tree (After all next and remove operations)");
        System.out.println(Btree.toString());
        
        
        System.out.println("########## Test enqueue and dequeue methods ##########");
        
        PriorityVectorQueue testVectorQueue = new PriorityVectorQueue();
        
        testVectorQueue.enqueue("Furkan");
        testVectorQueue.enqueue("Osman");
        testVectorQueue.enqueue("Salih");
        testVectorQueue.enqueue("Sefa");
        testVectorQueue.enqueue("Serhat");
        testVectorQueue.enqueue("Yasin");
        testVectorQueue.enqueue("Burak");
        
        System.out.println("\n<---> Test enqueue <--->\n");
        System.out.println("Add -> Furkan\nAdd -> Osman\nAdd -> Salih\n"
                + "Add -> Sefa\nAdd -> Serhar\nAdd -> Yasin\nAdd -> Burak\n");
        
        System.out.println("Queue");
        System.err.println(testVectorQueue);
        
        System.out.println("\n<---> Test dequeue (After two dequeue) <--->\n");
        
        testVectorQueue.dequeue();
        testVectorQueue.dequeue();

        System.out.println("Queue");
        System.err.println(testVectorQueue);

        
        
        System.out.println("\n\n########## Runtime performance tests ##########");
        
        long startTime;
        long stopTime;
        int numberOFRepetition = 1000;

        /**
         * *********************** PriorityVectorQueue ***********************
         */
        PriorityVectorQueue vectorQueue = new PriorityVectorQueue();

        startTime = System.currentTimeMillis();
        for (int i = numberOFRepetition; i > 0; --i) {
            vectorQueue.enqueue(i);
        }
        stopTime = System.currentTimeMillis();
        
        System.out.println("\n##### Priority vector queue runtime performance");
        System.out.println("Enqueue time = " + (stopTime - startTime) + " ms\t(" + numberOFRepetition + " data)");

        startTime = System.currentTimeMillis();
        for (int i = numberOFRepetition; i > 0; --i) {
            vectorQueue.dequeue();
        }
        stopTime = System.currentTimeMillis();

        System.out.println("Dequeue time = " + (stopTime - startTime) + " ms\t(" + numberOFRepetition + " data)");

        /**
         * ********************* PriorityArrayListQueue **********************
         */
        PriorityArrayListQueue arrayQueue = new PriorityArrayListQueue();

        startTime = System.currentTimeMillis();
        for (int i = numberOFRepetition; i > 0; --i) {
            arrayQueue.enqueue(i);
        }
        stopTime = System.currentTimeMillis();

        System.out.println("\n##### Priority array list queue runtime performance");
        System.out.println("Enqueue time = " + (stopTime - startTime) + " ms\t(" + numberOFRepetition + " data)");

        startTime = System.currentTimeMillis();
        for (int i = numberOFRepetition; i > 0; --i) {
            arrayQueue.dequeue();
        }
        stopTime = System.currentTimeMillis();

        System.out.println("Dequeue time = " + (stopTime - startTime) + " ms\t(" + numberOFRepetition + " data)");

        /**
         * ******************** PriorityLinkedListQueue **********************
         */
        PriorityLinkedListQueue linkedListQueue = new PriorityLinkedListQueue();

        startTime = System.currentTimeMillis();
        for (int i = numberOFRepetition; i > 0; --i) {
            linkedListQueue.enqueue(i);
        }
        stopTime = System.currentTimeMillis();

        System.out.println("\n##### Priority linked list queue runtime performance");
        System.out.println("Enqueue time = " + (stopTime - startTime) + " ms\t(" + numberOFRepetition + " data)");

        startTime = System.currentTimeMillis();
        for (int i = numberOFRepetition; i > 0; --i) {
            linkedListQueue.dequeue();
        }
        stopTime = System.currentTimeMillis();

        System.out.println("Dequeue time = " + (stopTime - startTime) + " ms\t(" + numberOFRepetition + " data)");

        /**
         * **************** PriorityBinarySearchTreeQueue *******************
         */
        PriorityBinarySearchTreeQueue binarySearchTreeQueue = new PriorityBinarySearchTreeQueue();

        startTime = System.currentTimeMillis();
        for (int i = numberOFRepetition; i > 0; --i) {
            binarySearchTreeQueue.enqueue(i);
        }
        stopTime = System.currentTimeMillis();
        
        System.out.println("\n##### Priority binary search tree queue runtime performance");
        System.out.println("Enqueue time = " + (stopTime - startTime) + " ms\t(" + numberOFRepetition + " data)");
        
        
        startTime = System.currentTimeMillis();
        for (int i = numberOFRepetition; i > 0; --i) {
            binarySearchTreeQueue.dequeue();
        }
        stopTime = System.currentTimeMillis();
        
        System.out.println("Dequeue time = " + (stopTime - startTime) + " ms\t(" + numberOFRepetition + " data)");
    }
}
