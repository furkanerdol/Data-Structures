package HW06_1310444065_Furkan_Erdol;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class to represent and build a Huffman tree.
 *
 * @author Koffman and Wolfgang
 *
 */
public class HuffmanTree implements Serializable {

    // Nested Classes
    /**
     * A datum in the Huffman tree.
     */
    public static class HuffData implements Serializable {
        // Data Fields

        /**
         * The weight or probability assigned to this HuffData.
         */
        private double weight;
        /**
         * The alphabet symbol if this is a leaf.
         */
        private Character symbol;

        /**
         *
         * @param weight
         * @param symbol
         */
        public HuffData(double weight, Character symbol) {
            this.weight = weight;
            this.symbol = symbol;
        }

        /**
         *
         * @return
         */
        public Character getSymbol() {
            return symbol;
        }
    }
    // Data Fields
    /**
     * A reference to the completed Huffman tree.
     */
    protected BinaryTree<HuffData> huffTree;

    /**
     * A Comparator for Huffman trees; nested class.
     */
    private static class CompareHuffmanTrees
            implements Comparator<BinaryTree<HuffData>> {

        /**
         * Compare two objects.
         *
         * @param treeLeft The left-hand object
         * @param treeRight The right-hand object
         * @return -1 if left less than right, 0 if left equals right, and +1 if
         * left greater than right
         */
        @Override
        public int compare(BinaryTree<HuffData> treeLeft,
                BinaryTree<HuffData> treeRight) {
            double wLeft = treeLeft.getData().weight;
            double wRight = treeRight.getData().weight;
            return Double.compare(wLeft, wRight);
        }
    }

    /**
     * Builds the Huffman tree using the given alphabet and weights.
     *
     * @post huffTree contains a reference to the Huffman tree.
     * @param symbols An array of HuffData objects
     */
    public void buildTree(HuffData[] symbols) {
        Queue<BinaryTree<HuffData>> theQueue
                = new PriorityQueue<BinaryTree<HuffData>>(symbols.length,
                        new CompareHuffmanTrees());
        // Load the queue with the leaves.
        for (HuffData nextSymbol : symbols) {
            BinaryTree<HuffData> aBinaryTree
                    = new BinaryTree<HuffData>(nextSymbol, null, null);
            theQueue.offer(aBinaryTree);
        }

        // Build the tree.
        while (theQueue.size() > 1) {
            BinaryTree<HuffData> left = theQueue.poll();
            BinaryTree<HuffData> right = theQueue.poll();
            double wl = left.getData().weight;
            double wr = right.getData().weight;
            HuffData sum = new HuffData(wl + wr, null);
            BinaryTree<HuffData> newTree
                    = new BinaryTree<HuffData>(sum, left, right);
            theQueue.offer(newTree);
        }

        // The queue should now contain only one item.
        huffTree = theQueue.poll();
    }

    /**
     * Outputs the resulting code.
     *
     * @param out A PrintStream to write the output to
     * @param code The code up to this node
     * @param tree The current node in the tree
     */
    private void printCode(PrintStream out, String code, BinaryTree<HuffData> tree) {
        HuffData theData = tree.getData();
        if (theData.symbol != null) {
            if (theData.symbol.equals(' ')) {
                out.println("space: " + code);
            } else {
                out.println(theData.symbol + ": " + code);
            }
        } else {
            printCode(out, code + "0", tree.getLeftSubtree());
            printCode(out, code + "1", tree.getRightSubtree());
        }
    }

    /**
     * Outputs the resulting code.
     *
     * @param out A PrintStream to write the output to
     */
    public void printCode(PrintStream out) {
        printCode(out, "", huffTree);
    }

    /**
     * Method to decode a message that is input as a string of digit characters
     * '0' and '1'.
     *
     * @param codedMessage The input message as a String of zeros and ones.
     * @return The decoded message as a String
     */
    public String decode(String codedMessage) {
        StringBuilder result = new StringBuilder();
        BinaryTree<HuffData> currentTree = huffTree;
        for (int i = 0; i < codedMessage.length(); i++) {
            if (codedMessage.charAt(i) == '1') {
                currentTree = currentTree.getRightSubtree();
            } else {
                currentTree = currentTree.getLeftSubtree();
            }
            if (currentTree.isLeaf()) {
                HuffData theData = currentTree.getData();
                result.append(theData.symbol);
                currentTree = huffTree;
            }
        }
        return result.toString();
    }

    /**
     * Method to encode string message into Huffman encodes.
     *
     * @param message The input message as a String which is composed on the
     * specified alphabet in the book
     * @param huffmanTree It’s created Huffman code for the alphabet
     * @return The encoded message as a String zero and ones.
     * @throws huffmantrees.HuffmanTree.IllegalMessageException input message is
     * not valid
     * @throws huffmantrees.HuffmanTree.EmptyTreeException tree is empty tree
     * (null)
     */
    public String encode(String message, BinaryTree huffmanTree) throws IllegalMessageException, EmptyTreeException {

        if (huffmanTree == null) {
            throw new EmptyTreeException();
        }

        StringBuilder encodeStringBuilder = new StringBuilder();

        for (int i = 0; i < message.length(); ++i) {

            StringBuilder tempStringBuilder = new StringBuilder();

            tempStringBuilder = searchLetter(message.charAt(i), huffmanTree, tempStringBuilder);

            if (tempStringBuilder == null) {
                throw new IllegalMessageException();
            }

            tempStringBuilder.reverse();

            encodeStringBuilder.append(tempStringBuilder);
        }

        return encodeStringBuilder.toString();
    }

    /**
     * Takes a letter. Search it in Huffman tree. Encode according to Huffman
     * tree rules and returns as a string builder. Encoded string builder is
     * reverse encoded If tree is null or letter is not in tree returns null
     *
     * @param letter letter to search
     * @param huffmanTree a builded Huffman tree
     * @param encodeStringBuilder encoded string builder
     * @return null or encoded string builder
     */
    private StringBuilder searchLetter(char letter, BinaryTree huffmanTree, StringBuilder encodeStringBuilder) {

        HuffData theData = (HuffData) huffmanTree.getData();

        StringBuilder tempStringBuilder;

        if (huffmanTree.isLeaf()) {
            if (theData.getSymbol().compareTo(new Character(letter)) == 0) {
                return encodeStringBuilder;
            } else {
                return null;
            }
        }

        tempStringBuilder = searchLetter(letter, huffmanTree.getLeftSubtree(), encodeStringBuilder);

        if (tempStringBuilder != null) {
            encodeStringBuilder.append('0');
            return encodeStringBuilder;
        }

        tempStringBuilder = searchLetter(letter, huffmanTree.getRightSubtree(), encodeStringBuilder);

        if (tempStringBuilder != null) {
            encodeStringBuilder.append('1');
            return encodeStringBuilder;
        }

        return null;
    }

    /**
     * Print codes and their weights as string
     */
    public String toString() {

        String encodedCodes = "";
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        this.printCode(ps);

        try {
            encodedCodes = os.toString("UTF8");
            System.out.println("Encoded Codes : \n" + encodedCodes);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(HuffmanTree.class.getName()).log(Level.SEVERE, null, ex);
        }

        return encodedCodes;
    }

    /**
     * IllegalMessageException class
     */
    public class IllegalMessageException extends Exception {

        /**
         * Constructor
         */
        public IllegalMessageException() {
            super();
        }
    }

    /**
     * EmptyTreeException class
     */
    public class EmptyTreeException extends Exception {

        /**
         * Constructor
         */
        public EmptyTreeException() {
            super();
        }
    }
}
