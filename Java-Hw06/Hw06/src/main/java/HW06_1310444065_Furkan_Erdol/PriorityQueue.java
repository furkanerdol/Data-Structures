package HW06_1310444065_Furkan_Erdol;

/**
 * Priority Queue interface
 *
 * @author Furkan
 * @param <E> generic data type
 */
public interface PriorityQueue<E> {

    /**
     * Takes an generic data and enqueue in queue according to priority Finds
     * required index use binary search algorithm and add to index with
     * delegation
     *
     * @param addData added data
     * @return added data
     */
    public E enqueue(E addData);

    /**
     * One data dequeue from queue and returns it Remove data is last data in
     * queue
     *
     * @return removed data
     */
    public E dequeue();

    /**
     * If queue is empty returns true otherwise returns false
     *
     * @return true or false
     */
    public boolean isEmpty();

    /**
     * Returns number of data in queue
     *
     * @return number of data in queue
     */
    public int size();

}
