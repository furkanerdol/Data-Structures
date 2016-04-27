package space.list;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
/**
 * Test class for space list
 * @author Furkan
 */
public class Test {

    public static void main(String[] args) {

        // INTEGER TEST
        SpecList myIntegerSpecList = new SpecList();
        myIntegerSpecList.add(5);
        myIntegerSpecList.add(9);
        myIntegerSpecList.add(54);
        myIntegerSpecList.add(65);
        myIntegerSpecList.add(-8);
        myIntegerSpecList.add(7);
        myIntegerSpecList.add(74);
        myIntegerSpecList.add(63);
        myIntegerSpecList.add(0);

        Collection integerLinkedListA = new LinkedList();
        integerLinkedListA.add(15);
        integerLinkedListA.add(25);
        integerLinkedListA.add(35);
        integerLinkedListA.add(45);
        integerLinkedListA.add(55);

        Collection integerLinkedListB = new LinkedList();
        integerLinkedListB.add(54);
        integerLinkedListB.add(-8);
        integerLinkedListB.add(64);
        integerLinkedListB.add(7);
        integerLinkedListB.add(15);
        integerLinkedListB.add(44);
        integerLinkedListB.add(54);
        integerLinkedListB.add(23);
        integerLinkedListB.add(-8);

        System.out.println("\n################################  TEST FOR INTEGER  ################################n");

        System.out.println("My integer space list     > > > " + myIntegerSpecList);
        System.out.println("Integer linked list A     > > > " + integerLinkedListA);
        System.out.println("Integer linked list B     > > > " + integerLinkedListB);

        // Function addAllHead sample for integer
        myIntegerSpecList.addAllAtHead(integerLinkedListA);
        System.out.println("\n* * * * * * * Function addAllHead sample ( myIntegerSpecList.addAllAtHead(integerLinkedListA) )\n");
        System.out.println("My integer space list     > > > " + myIntegerSpecList);

        List intersectionListInteger;

        // Function getIntersectList sample for integer
        intersectionListInteger = myIntegerSpecList.getIntersectList(integerLinkedListB);
        System.out.println("\n* * * * * * * Function getIntersectList sample ( myIntegerSpecList.getIntersectList(integerLinkedListB) )\n");
        System.out.println("Intersection list         > > > " + intersectionListInteger);

        // Function sortList sample for integer
        try {
            System.out.println("\n* * * * * * * Function sortList sample ( myIntegerSpecList.sortList() )\n");
            System.out.println("Sorted list ( increasing )              > > > " + myIntegerSpecList.sortList(1));
        } catch (TypeMismatchException exception) {
            System.err.println("Type mismatch in myIntegerSpecList!");
        }

        
        // CHARACTER TEST
        SpecList myCharSpecList = new SpecList();
        myCharSpecList.add('B');
        myCharSpecList.add('F');
        myCharSpecList.add('G');
        myCharSpecList.add('E');
        myCharSpecList.add('H');
        myCharSpecList.add('Y');
        myCharSpecList.add('S');
        myCharSpecList.add('N');
        myCharSpecList.add('P');

        Collection charLinkedListA = new LinkedList();
        charLinkedListA.add('I');
        charLinkedListA.add('D');
        charLinkedListA.add('Q');
        charLinkedListA.add('T');
        charLinkedListA.add('O');

        Collection charLinkedListB = new LinkedList();
        charLinkedListB.add('U');
        charLinkedListB.add('B');
        charLinkedListB.add('M');
        charLinkedListB.add('F');
        charLinkedListB.add('F');
        charLinkedListB.add('R');
        charLinkedListB.add('L');
        charLinkedListB.add('C');
        charLinkedListB.add('E');

        System.out.println("\n\n################################  TEST FOR CHARACTER  ################################n");

        System.out.println("My char space list        > > > " + myCharSpecList);
        System.out.println("Char linked list A        > > > " + charLinkedListA);
        System.out.println("Char linked list B        > > > " + charLinkedListB);

        // Function addAllHead sample for character
        myCharSpecList.addAllAtHead(charLinkedListA);
        System.out.println("\n* * * * * * * Function addAllHead sample ( myIntegerSpecList.addAllAtHead(charLinkedListA) )\n");
        System.out.println("My char space list        > > > " + myCharSpecList);

        List intersectionListChar;

        // Function getIntersectList sample for character
        intersectionListChar = myCharSpecList.getIntersectList(charLinkedListB);
        System.out.println("\n* * * * * * * Function getIntersectList sample ( myIntegerSpecList.getIntersectList(charLinkedListB) )\n");
        System.out.println("Intersection list         > > > " + intersectionListChar);

        // Function sortList sample for character
        try {
            System.out.println("\n* * * * * * * Function sortList sample ( myIntegerSpecList.sortList() )\n");
            System.out.println("Sorted list ( increasing )              > > > " + myCharSpecList.sortList(1));
        } catch (TypeMismatchException exception) {
            System.err.println("Type mismatch in myCharSpecList!");
        }

        // DOUBLE TEST
        SpecList myDoubleSpecList = new SpecList();
        myDoubleSpecList.add(4.2);
        myDoubleSpecList.add(-3.4);
        myDoubleSpecList.add(8.4);
        myDoubleSpecList.add(6.4);
        myDoubleSpecList.add(-8.8);
        myDoubleSpecList.add(7.6);
        myDoubleSpecList.add(45.6);
        myDoubleSpecList.add(-65.9);
        myDoubleSpecList.add(5.7);

        Collection doubleLinkedListA = new LinkedList();
        doubleLinkedListA.add(8.7);
        doubleLinkedListA.add(6.5);
        doubleLinkedListA.add(-7.5);
        doubleLinkedListA.add(8.5);
        doubleLinkedListA.add(3.4);

        Collection doubleLinkedListB = new LinkedList();
        doubleLinkedListB.add(6.4);
        doubleLinkedListB.add(-5.3);
        doubleLinkedListB.add(1.8);
        doubleLinkedListB.add(-1.5);
        doubleLinkedListB.add(4.7);
        doubleLinkedListB.add(99.9);
        doubleLinkedListB.add(8.5);
        doubleLinkedListB.add(-3.8);
        doubleLinkedListB.add(-8.8);

        System.out.println("\n\n################################  TEST FOR DOUBLE  ################################n");

        System.out.println("My double space list      > > > " + myDoubleSpecList);
        System.out.println("Double linked list A      > > > " + doubleLinkedListA);
        System.out.println("Double linked list B      > > > " + doubleLinkedListB);

        // Function addAllHead sample for double
        myDoubleSpecList.addAllAtHead(doubleLinkedListA);
        System.out.println("\n* * * * * * * Function addAllHead sample ( myIntegerSpecList.addAllAtHead(doubleLinkedListA) )\n");
        System.out.println("My double space list      > > > " + myDoubleSpecList);

        List intersectionListDouble;

        // Function getIntersectList sample for double
        intersectionListDouble = myDoubleSpecList.getIntersectList(doubleLinkedListB);
        System.out.println("\n* * * * * * * Function getIntersectList sample ( myIntegerSpecList.getIntersectList(doubleLinkedListB) )\n");
        System.out.println("Intersection list         > > > " + intersectionListDouble);

        // Function sortList sample for double
        try {
            System.out.println("\n* * * * * * * Function sortList sample ( myIntegerSpecList.sortList() )\n");
            System.out.println("Sorted list ( decreasing )              > > > " + myDoubleSpecList.sortList(-1));
        } catch (TypeMismatchException exception) {
            System.err.println("Type mismatch in myDoubleSpecList!");
        }
    }
}
