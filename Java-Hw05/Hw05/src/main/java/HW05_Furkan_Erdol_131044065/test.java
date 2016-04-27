package HW05_Furkan_Erdol_131044065;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Test class
 *
 * @author Furkan
 */
public class test {

    /**
     * Main for testing
     *
     * @param args
     */
    public static void main(String[] args) {

        TowersOfHanoi honoiGameOne = new TowersOfHanoi();
        TowersOfHanoi honoiGameTwo = new TowersOfHanoi();

        System.out.println("########## Test Towers Of Hanoi Game ##########\n");

        // Test game for 3 disks
        System.out.println("<><><>  For 3 Disks  <><><>");
        honoiGameOne.towersOfHanoi(3, "Src", "Aux", "Dst");

        // Test Game for 4 disks
        System.out.println("\n<><><>  For 4 Disks  <><><>");
        honoiGameTwo.towersOfHanoi(4, "Src", "Aux", "Dst");

        LinkedListRec testLinkedListRecOne = new LinkedListRec();

        testLinkedListRecOne.add("Furkan");
        testLinkedListRecOne.add("Sefa");
        testLinkedListRecOne.add("Serhat");
        testLinkedListRecOne.add("Osman");
        testLinkedListRecOne.add("Salih");
        testLinkedListRecOne.add("Ahmet");
        testLinkedListRecOne.add("Burak");
        testLinkedListRecOne.add("Selim");
        testLinkedListRecOne.add("Mehmet");
        testLinkedListRecOne.add("Mustafa");
        testLinkedListRecOne.add("Ferhat");
        testLinkedListRecOne.add("Furkan");

        // Test recursive remove method for LinkedListRec class
        System.out.println("\n########## Test recursive remove method for LinkedListRec class ##########\n");
        System.out.println("<><><>    List One   <><><> " + testLinkedListRecOne);
        testLinkedListRecOne.remove("Furkan");
        System.out.println("<><><> Remove Furkan <><><> " + testLinkedListRecOne);

        LinkedListRec testLinkedListRecTwo = new LinkedListRec();

        testLinkedListRecTwo.add(2);
        testLinkedListRecTwo.add(5);
        testLinkedListRecTwo.add(10);
        testLinkedListRecTwo.add(7);
        testLinkedListRecTwo.add(9);
        testLinkedListRecTwo.add(2);
        testLinkedListRecTwo.add(35);
        testLinkedListRecTwo.add(2);
        testLinkedListRecTwo.add(7);
        testLinkedListRecTwo.add(82);
        testLinkedListRecTwo.add(25);
        testLinkedListRecTwo.add(5);

        System.out.println("\n<><><>   List two   <><><> " + testLinkedListRecTwo);
        testLinkedListRecTwo.remove(2);
        System.out.println("<><><>   Remove 2   <><><> " + testLinkedListRecTwo);

        ArrayList arraylistOne = new ArrayList();
        arraylistOne.add(10);
        arraylistOne.add(8);
        arraylistOne.add(7);
        arraylistOne.add(-5);
        arraylistOne.add(11);
        arraylistOne.add(-3);
        arraylistOne.add(72);
        arraylistOne.add(19);
        arraylistOne.add(13);
        arraylistOne.add(85);

        ArrayList arraylistTwo = new ArrayList();
        arraylistTwo.add(15);
        arraylistTwo.add(8);
        arraylistTwo.add(-7);
        arraylistTwo.add(85);
        arraylistTwo.add(10);
        arraylistTwo.add(7);
        arraylistTwo.add(11);
        arraylistTwo.add(93);
        arraylistTwo.add(13);

        ArrayList arraylistThree = new ArrayList();
        arraylistThree.add('A');
        arraylistThree.add('C');
        arraylistThree.add('D');
        arraylistThree.add('B');
        arraylistThree.add('K');
        arraylistThree.add('L');
        arraylistThree.add('S');
        arraylistThree.add('V');
        arraylistThree.add('Q');
        arraylistThree.add('L');

        ArrayList arraylistFour = new ArrayList();
        arraylistFour.add('C');
        arraylistFour.add('D');
        arraylistFour.add('V');
        arraylistFour.add('K');

        try {

            SortedLists testSortedListOne = new SortedLists(arraylistOne, arraylistTwo);

            System.out.println("\n########## Test recursive intersectionOfLists() method for SortedLists class ##########\n");
            System.out.println("<><><>      List One     <><><> " + testSortedListOne.getSortedListOne());
            System.out.println("<><><>      List Two     <><><> " + testSortedListOne.getSortedListTwo());

            // Intersection list
            List intercestList = testSortedListOne.intersectionOfLists();
            System.out.println("<><><> Intersection list <><><> " + intercestList);

            System.out.println("\n########## Test recursive unionOfLists() method for SortedLists class ##########\n");
            System.out.println("<><><>      List One     <><><> " + testSortedListOne.getSortedListOne());
            System.out.println("<><><>      List Two     <><><> " + testSortedListOne.getSortedListTwo());

            // Union list
            List unionList = testSortedListOne.unionOfLists();
            System.out.println("<><><>     Union list    <><><> " + unionList);

            System.out.println("\n########## Test recursive isSubset() method for SortedLists class ##########\n");
            System.out.println("<><><>      List One     <><><> " + testSortedListOne.getSortedListOne());
            System.out.println("<><><>      List Two     <><><> " + testSortedListOne.getSortedListTwo());

            // Is Subset?    
            System.out.println("<><><>     Is Subset?    <><><> " + testSortedListOne.isSubset());

            SortedLists testSortedListTwo = new SortedLists(arraylistThree, arraylistFour);

            System.out.println("\n########## Test recursive intersectionOfLists() method for SortedLists class ##########\n");
            System.out.println("<><><>      List One     <><><> " + testSortedListTwo.getSortedListOne());
            System.out.println("<><><>      List Two     <><><> " + testSortedListTwo.getSortedListTwo());

            // Intersection list
            List intercestListTwo = testSortedListTwo.intersectionOfLists();
            System.out.println("<><><> Intersection list <><><> " + intercestListTwo);

            System.out.println("\n########## Test recursive unionOfLists() method for SortedLists class ##########\n");
            System.out.println("<><><>      List One     <><><> " + testSortedListTwo.getSortedListOne());
            System.out.println("<><><>      List Two     <><><> " + testSortedListTwo.getSortedListTwo());

            // Union list
            List unionListTwo = testSortedListTwo.unionOfLists();
            System.out.println("<><><>     Union list    <><><> " + unionListTwo);

            System.out.println("\n########## Test recursive isSubset() method for SortedLists class ##########\n");
            System.out.println("<><><>      List One     <><><> " + testSortedListTwo.getSortedListOne());
            System.out.println("<><><>      List Two     <><><> " + testSortedListTwo.getSortedListTwo());

            // Is Subset?    
            System.out.println("<><><>     Is Subset?    <><><> " + testSortedListTwo.isSubset());

        } catch (TypeMismatchException exception) {
            System.err.println("Types mismatch !!!");
        }
    }

}
