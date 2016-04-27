package HW06_1310444065_Furkan_Erdol;

import java.util.Comparator;
import java.util.List;

/**
 * Priority Abstract List Queue class
 *
 * @author Furkan
 * @param <E> generic data type
 */
public abstract class PriorityAbstractListQueue<E> implements PriorityQueue<E> {

    /**
     * Holds data (priority queue) on list structure
     */
    protected List queue;

    /**
     * Comparator to compare two object
     */
    protected Comparator comp;

    /**
     * Number of data in queue
     */
    protected int size;

    /**
     * Constructor
     */
    public PriorityAbstractListQueue() {

    }

    /**
     * Takes an generic data and enqueue in queue according to priority Finds
     * required index use binary search algorithm and add to index with
     * delegation
     *
     * @param addData added data
     * @return added data
     */
    @Override
    public E enqueue(E addData) {

        int firstIndex = 0;
        int lastIndex = size();
        int middleIndex = (firstIndex + lastIndex) / 2;

        while (lastIndex > firstIndex) {

            if (comp.compare(queue.get(middleIndex), addData) <= 0) {
                lastIndex = middleIndex;
            } else {
                firstIndex = middleIndex + 1;
            }
            middleIndex = (firstIndex + lastIndex) / 2;
        }

        queue.add(firstIndex, addData);

        return addData;
    }

    /**
     * One data dequeue from queue according to priority and returns it Remove
     * data is last data in queue
     *
     * @return removed data
     */
    @Override
    public E dequeue() {
        E tempData = (E) queue.remove(size() - 1);
        return tempData;
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
        return queue.size();
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
