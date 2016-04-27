package HW06_1310444065_Furkan_Erdol;

import java.util.Comparator;
import java.util.ArrayList;

/**
 * Priority ArrayList Queue class
 *
 * @author Furkan
 * @param <E> generic data type
 */
public class PriorityArrayListQueue<E> extends PriorityAbstractListQueue<E>{

    /**
     * Constructor Use data structure is ArrayList
     */
    public PriorityArrayListQueue() {
        queue = new ArrayList();
        comp = new MyComparator();
        size = size();
    }

    /**
     * Constructor Use data structure is ArrayList
     *
     * @param newComparator comparator
     */
    public PriorityArrayListQueue(Comparator newComparator) {
        queue = new ArrayList();
        comp = newComparator;
        size = size();
    }

}
