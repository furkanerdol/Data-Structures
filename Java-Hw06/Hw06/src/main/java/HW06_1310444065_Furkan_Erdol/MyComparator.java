package HW06_1310444065_Furkan_Erdol;

import java.util.Comparator;

/**
 * MyComparator class for default comparison
 *
 * @author Furkan
 */
public class MyComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        return ((Comparable) o1).compareTo(o2);
    }
}
