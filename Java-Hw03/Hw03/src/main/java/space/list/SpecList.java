package space.list;

import java.util.LinkedList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Class space list is a list class, extends linked list. It has three methods.
 * addAllHead, getIntersectList and sortList.
 */
public class SpecList<E extends Comparable<E>> extends LinkedList<E> {

    /**
     * Constructor
     */
    public SpecList() {
        super();
    }

    /**
     * Takes a collection and appends all of the elements in the specified
     * collection to the head of the list
     *
     * @param c is a collection
     * @return true or false
     */
    @SuppressWarnings("unchecked")
    public boolean addAllAtHead(Collection<? extends E> c) {

        if (c.isEmpty()) {
            return false;
        }

        Object[] objectArr = c.toArray();

        for (int i = objectArr.length - 1; i >= 0; --i) {
            this.addFirst((E) objectArr[i]);
        }

        return true;
    }

    /**
     * Finds and returns intersection list (list of unique elements available in
     * both collections)
     *
     * @param c is a collection
     * @return a intersection List
     */
    @SuppressWarnings("unchecked")
    public List<E> getIntersectList(Collection<? extends E> c) {

        Object[] objectArr = c.toArray();
        SpecList intersectSpecList = new SpecList();

        for (int i = 0; i < objectArr.length; ++i) {

            if (this.contains(objectArr[i]) && !(intersectSpecList.contains(objectArr[i]))) {
                E temp = (E) objectArr[i];
                intersectSpecList.add(temp);
            }
        }

        return intersectSpecList;

    }

    /**
     * Takes an integer value and shorts intersection list according to integer
     * value And returns it as a List.
     *
     * @param decreasingIncreasing for short direction as a integer value
     * @return a sorted List
     * @throws TypeMismatchException
     */
    @SuppressWarnings("unchecked")
    public List<E> sortList(int decreasingIncreasing) throws TypeMismatchException {

        SpecList sortedSpecList = new SpecList();
        sortedSpecList.addAll(this);

        int firstIndex = 0;
        int lastIndex = this.size() - 1;

        boolean swap;

        try {

            if (decreasingIncreasing > 0) {

                do {
                    swap = false;

                    for (int i = 0; i < lastIndex; ++i) {

                        E compare1 = (E) sortedSpecList.get(i);
                        E compare2 = (E) sortedSpecList.get(i + 1);

                        if (compare1.compareTo(compare2) > 0) {
                            E tempElement = (E) sortedSpecList.get(i);
                            sortedSpecList.set(i, sortedSpecList.get(i + 1));
                            sortedSpecList.set(i + 1, tempElement);
                            swap = true;
                        }
                    }

                    if (!swap) {
                        break;
                    }

                    swap = false;

                    --lastIndex;

                    for (int i = lastIndex; i > firstIndex; --i) {

                        E compare1 = (E) sortedSpecList.get(i);
                        E compare2 = (E) sortedSpecList.get(i + 1);

                        if (compare1.compareTo(compare2) < 0) {
                            E tempElement = (E) sortedSpecList.get(i);
                            sortedSpecList.set(i, sortedSpecList.get(i - 1));
                            sortedSpecList.set(i - 1, tempElement);
                            swap = true;
                        }
                    }

                    ++firstIndex;

                } while (swap);
            } else {

                do {
                    swap = false;

                    for (int i = 0; i < lastIndex; ++i) {

                        E compare1 = (E) sortedSpecList.get(i);
                        E compare2 = (E) sortedSpecList.get(i + 1);

                        if (compare1.compareTo(compare2) < 0) {
                            E tempElement = (E) sortedSpecList.get(i);
                            sortedSpecList.set(i, sortedSpecList.get(i + 1));
                            sortedSpecList.set(i + 1, tempElement);
                            swap = true;
                        }
                    }

                    if (!swap) {
                        break;
                    }

                    swap = false;

                    --lastIndex;

                    for (int i = lastIndex; i > firstIndex; --i) {

                        E compare1 = (E) sortedSpecList.get(i);
                        E compare2 = (E) sortedSpecList.get(i + 1);

                        if (compare1.compareTo(compare2) > 0) {
                            E tempElement = (E) sortedSpecList.get(i);
                            sortedSpecList.set(i, sortedSpecList.get(i - 1));
                            sortedSpecList.set(i - 1, tempElement);
                            swap = true;
                        }
                    }

                    ++firstIndex;

                } while (swap);

            }
        } catch (ClassCastException exception) {
            throw new TypeMismatchException();
        }

        return sortedSpecList;
    }

}
