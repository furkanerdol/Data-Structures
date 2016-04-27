package HW06_1310444065_Furkan_Erdol;

import java.util.Comparator;
import java.util.Vector;

/**
 * Priority Vector Queue class
 *
 * @author Furkan
 * @param <E> generic data type
 */
public class PriorityVectorQueue<E> extends PriorityAbstractListQueue<E>{

    /**
     * Constructor Use data structure is LinkedList
     */
    public PriorityVectorQueue() {
        comp = new MyComparator();
        queue = new Vector();
        size = size();
    }

    /**
     * Constructor Use data structure is Vector
     *
     * @param newComparator comparator
     */
    public PriorityVectorQueue(Comparator newComparator) {
        comp = newComparator;
        queue = new Vector();
        size = size();
    }

}
