package HW06_1310444065_Furkan_Erdol;

import java.util.Comparator;
import java.util.Iterator;

/**
 * Priority Binary Search Tree Queue class
 *
 * @author Furkan
 * @param <E> generic data type
 */
public class PriorityBinarySearchTreeQueue<E> implements PriorityQueue<E> {

    private BinarySearchTree queue;
    private Comparator comp;
    private int size;

    /**
     * Constructor Use data structure is BinarySearchTree
     */
    public PriorityBinarySearchTreeQueue() {
        comp = new MyComparator();
        queue = new BinarySearchTree();
        size = 0;
    }

    /**
     * Constructor Use data structure is BinarySearchTree
     *
     * @param newComparator comparator
     */
    public PriorityBinarySearchTreeQueue(Comparator newComparator) {
        comp = newComparator;
        queue = new BinarySearchTree();
        size = 0;
    }

    /**
     * Takes an generic data and enqueue in queue according to priority Add to
     * queue with delegation
     *
     * @param addData added data
     * @return added data
     */
    @Override
    public E enqueue(E addData) {

        queue.add((Comparable) addData);

        ++size;

        return addData;
    }

    /**
     * One data dequeue from queue according to priority and returns it Get
     * iterator for priority data
     *
     * @return removed data
     */
    @Override
    public E dequeue() {

        Iterator<E> iter = queue.getAscendingOrderIterator();

        if (iter.hasNext()) {
            E tempData = iter.next();
            iter.remove();
            --size;
            return tempData;
        }

        return null;
    }

    /**
     * If queue is empty returns true otherwise returns false
     *
     * @return true or false
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns number of data in queue
     *
     * @return number of data in queue
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Override toString method
     *
     * @return string format queue
     */
    public String toString() {
        return queue.toString();
    }

}
