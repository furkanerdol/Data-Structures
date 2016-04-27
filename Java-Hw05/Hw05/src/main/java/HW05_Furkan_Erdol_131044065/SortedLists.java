package HW05_Furkan_Erdol_131044065;

import java.util.ArrayList;
import java.util.List;

/**
 * SortedLists class have two sorted lists. There are three methods process on
 * these lists.
 *
 * - intersection of lists 
 * - union of list 
 * - is subset
 *
 * @author Furkan
 * @param <E>
 */
public class SortedLists<E extends Comparable<E>> {

    private final List<E> sortedListOne;
    private final List<E> sortedListTwo;

    /**
     * Constructor
     *
     * @param newListOne
     * @param newListTwo
     * @throws TypeMismatchException
     */
    public SortedLists(List<E> newListOne, List<E> newListTwo) throws TypeMismatchException {
        sortedListOne = (ArrayList) sortList(newListOne, 1);
        sortedListTwo = (ArrayList) sortList(newListTwo, 1);
    }

    /**
     * Getter for list one
     *
     * @return list one
     */
    public List<E> getSortedListOne() {
        return sortedListOne;
    }

    /**
     * Getter for list two
     *
     * @return list two
     */
    public List<E> getSortedListTwo() {
        return sortedListTwo;
    }

    /**
     * Finds and returns intersection list (list of unique elements available in
     * both list)
     *
     * @return intersection list
     */
    public List intersectionOfLists() {
        return intersectionOfLists(0);
    }

    /**
     * Finds and returns union of two lists
     *
     * @return union list
     */
    public List unionOfLists() {
        return unionOflists(0, 0);
    }

    /**
     * If list two is subset list one returns true otherwise returns false
     *
     * @return true or false
     */
    public boolean isSubset() {
        return isSubset(0);
    }

    private List intersectionOfLists(int index) {

        List<E> intersectList = new ArrayList<E>();

        if (getSortedListOne().size() == index) {
            return intersectList;
        }

        intersectList = intersectionOfLists(index + 1);

        if (getSortedListTwo().contains(getSortedListOne().get(index)) && !(intersectList.contains(getSortedListOne().get(index)))) {
            intersectList.add(getSortedListOne().get(index));
        }

        return intersectList;
    }

    private List unionOflists(int index1, int index2) {

        List<E> unionList = new ArrayList<E>();

        if (getSortedListOne().size() == index1 && getSortedListTwo().size() == index2) {
            return unionList;
        }

        if (getSortedListOne().size() == index1 && index2 < getSortedListTwo().size()) {
            unionList = unionOflists(index1, index2 + 1);
            unionList.add(getSortedListTwo().get(index2));

        } else if (getSortedListTwo().size() == index2 && index1 < getSortedListOne().size()) {
            unionList = unionOflists(index1 + 1, index2);
            unionList.add(getSortedListOne().get(index1));

        } else if (index2 < getSortedListTwo().size() && index1 < getSortedListOne().size()) {
            unionList = unionOflists(index1 + 1, index2 + 1);
            unionList.add(getSortedListOne().get(index1));
            unionList.add(getSortedListTwo().get(index2));
        }

        return unionList;
    }

    private boolean isSubset(int index2) {

        if (index2 == getSortedListTwo().size()) {
            return true;
        } else if (getSortedListTwo().size() > getSortedListOne().size()) {
            return false;
        } else if (!getSortedListOne().contains(getSortedListTwo().get(index2))) {
            return false;
        } else {
            return isSubset(index2 + 1);
        }

    }

    /**
     * Takes an integer value and shorts intersection list according to integer
     * value. And returns it as a List.
     *
     * @param list
     * @param decreasingIncreasing for short direction as a integer value
     * @return a sorted List
     * @throws TypeMismatchException
     */
    @SuppressWarnings("unchecked")
    public List<E> sortList(List list, int decreasingIncreasing) throws TypeMismatchException {

        ArrayList sortedArrayList = new ArrayList();
        sortedArrayList.addAll(list);

        int firstIndex = 0;
        int lastIndex = list.size() - 1;

        boolean swap;

        try {

            if (decreasingIncreasing > 0) {

                do {
                    swap = false;
                    for (int i = 0; i < lastIndex; ++i) {
                        E compare1 = (E) sortedArrayList.get(i);
                        E compare2 = (E) sortedArrayList.get(i + 1);
                        if (compare1.compareTo(compare2) > 0) {
                            E tempElement = (E) sortedArrayList.get(i);
                            sortedArrayList.set(i, sortedArrayList.get(i + 1));
                            sortedArrayList.set(i + 1, tempElement);
                            swap = true;
                        }
                    }
                    if (!swap) {
                        break;
                    }
                    swap = false;

                    --lastIndex;

                    for (int i = lastIndex; i > firstIndex; --i) {
                        E compare1 = (E) sortedArrayList.get(i);
                        E compare2 = (E) sortedArrayList.get(i + 1);
                        if (compare1.compareTo(compare2) < 0) {
                            E tempElement = (E) sortedArrayList.get(i);
                            sortedArrayList.set(i, sortedArrayList.get(i - 1));
                            sortedArrayList.set(i - 1, tempElement);
                            swap = true;
                        }
                    }

                    ++firstIndex;

                } while (swap);

            } else {

                do {
                    swap = false;
                    for (int i = 0; i < lastIndex; ++i) {
                        E compare1 = (E) sortedArrayList.get(i);
                        E compare2 = (E) sortedArrayList.get(i + 1);
                        if (compare1.compareTo(compare2) < 0) {
                            E tempElement = (E) sortedArrayList.get(i);
                            sortedArrayList.set(i, sortedArrayList.get(i + 1));
                            sortedArrayList.set(i + 1, tempElement);
                            swap = true;
                        }
                    }

                    if (!swap) {
                        break;
                    }

                    swap = false;

                    --lastIndex;

                    for (int i = lastIndex; i > firstIndex; --i) {
                        E compare1 = (E) sortedArrayList.get(i);
                        E compare2 = (E) sortedArrayList.get(i + 1);
                        if (compare1.compareTo(compare2) > 0) {
                            E tempElement = (E) sortedArrayList.get(i);
                            sortedArrayList.set(i, sortedArrayList.get(i - 1));
                            sortedArrayList.set(i - 1, tempElement);
                            swap = true;
                        }
                    }

                    ++firstIndex;

                } while (swap);
            }
        } catch (ClassCastException exception) {
            throw new TypeMismatchException();
        }

        return sortedArrayList;
    }
}
