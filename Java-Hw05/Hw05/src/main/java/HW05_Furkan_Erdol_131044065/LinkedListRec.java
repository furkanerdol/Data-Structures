package HW05_Furkan_Erdol_131044065;

/**
 * This class implementation taken from Data Structures: Abstraction and Design
 * Using Java 2e.(With comments) Except for remove methods.
 *
 * A recursive linked list class with recursive methods.
 *
 * @author Furkan
 * @param <E>
 *
 */
public class LinkedListRec<E> {

    /**
     * The list head
     */
    private Node<E> head;

    /**
     * A Node is the building block for a single-linked list.
     */
    private static class Node<E> {

        /**
         * The reference to the data.
         */
        private E data;
        /**
         * The reference to the next node.
         */
        private Node<E> next;

        /**
         * Creates a new node with a null next field.
         *
         * @param dataItem The data stored
         */
        private Node(E dataItem) {
            data = dataItem;
            next = null;
        }

        /**
         * Creates a new node that references another node.
         *
         * @param dataItem The data stored
         * @param nodeRef The node referenced by new node
         */
        private Node(E dataItem, Node<E> nodeRef) {
            data = dataItem;
            next = nodeRef;
        }
    }

    /**
     * Finds the size of a list.
     *
     * @param head The head of the current list
     * @return The Size of the Current List
     */
    private int size(Node<E> head) {
        if (head == null) {
            return 0;
        } else {
            return 1 + size(head.next);
        }
    }

    /**
     * Wrapper method for finding the size of a list.
     *
     * @return The size of the list
     */
    public int size() {
        return size(head);
    }

    /**
     * Returns the string representation of a list.
     *
     * @param head The head of the current list
     * @return The state of the current list
     */
    private String toString(Node<E> head) {
        if (head == null) {
            return "";
        } else {
            return "[" + head.data + "] " + toString(head.next);
        }
    }

    /**
     * Wrapper method for returning the string representation of a list.
     *
     * @return The string representation of the list
     */
    @Override
    public String toString() {
        return toString(head);
    }

    /**
     * Adds a new node to the end of a list.
     *
     * @param head The head of the current list
     * @param data The data for the new node
     */
    private void add(Node<E> head, E data) {

        if (head.next == null) {
            head.next = new Node<E>(data);
        } else {
            add(head.next, data);
        }
    }

    /**
     * Wrapper method for adding a new node to the end of a list.
     *
     * @param data The data for the new node
     */
    public void add(E data) {

        if (head == null) {
            head = new Node<E>(data);
        } else {
            add(head, data);
        }
    }

    private boolean remove(Node<E> head, Node<E> pred, E outData) {

        if (head == null) {
            return false;
        }

        if (head.data.equals(outData)) {
            pred.next = head.next; // To remove
        }

        return remove(head.next, head, outData); // Recursive call
    }

    /**
     * Takes an data and searches in linked list. If found it, remove it from
     * linked list. And returns true , otherwise returns false
     *
     * @param outData removed data
     * @return true or false
     */
    public boolean remove(E outData) {

        if (head == null) {
            return false;
        }

        if (head.data.equals(outData)) { // If removed data in head
            head = head.next; // To remove
            return remove(outData);
        }
        // If removed data not in head
        return remove(head.next, head, outData);
    }
}
