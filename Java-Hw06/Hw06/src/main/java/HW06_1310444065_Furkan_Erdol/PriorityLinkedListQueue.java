package HW06_1310444065_Furkan_Erdol;

import java.util.Comparator;
import java.util.LinkedList;

/**
 * Priority LinkedList Queue class
 *
 * @author Furkan
 * @param <E> generic data type
 */
public class PriorityLinkedListQueue<E> extends PriorityAbstractListQueue<E>{

    /**
     * Constructor Use data structure is LinkedList
     */
    public PriorityLinkedListQueue() {
        comp = new MyComparator();
        queue = new LinkedList();
        size = size();
    }

    /**
     * Constructor Use data structure is LinkedList
     *
     * @param newComparator comparator
     */
    public PriorityLinkedListQueue(Comparator newComparator) {
        comp = newComparator;
        queue = new LinkedList();
        size = size();
    }

}
