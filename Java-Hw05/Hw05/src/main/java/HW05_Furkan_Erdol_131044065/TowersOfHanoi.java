package HW05_Furkan_Erdol_131044065;

import static java.lang.Math.pow;
import java.util.Stack;

/**
 * Towers of Hanoi Game implements iteratively
 *
 * @author Furkan
 */
public class TowersOfHanoi {

    private Pole src;
    private Pole aux;
    private Pole dst;

    /**
     * Constructor
     */
    public TowersOfHanoi() {
        src = new Pole("src");
        aux = new Pole("aux");
        dst = new Pole("dst");
    }

    /**
     * Implements iteratively Towers of Hanoi Game
     *
     * @param diskSize disk size
     * @param nameSrc src pole name
     * @param nameAux aux pole name
     * @param nameDst dst pole name
     * @return true if disk size higher than zero otherwise returns false
     */
    public boolean towersOfHanoi(int diskSize, String nameSrc, String nameAux, String nameDst) {

        if (diskSize <= 0) {
            return false;
        }

        int totalMove;

        src.setPoleName(nameSrc);
        aux.setPoleName(nameAux);
        dst.setPoleName(nameDst);

        createPoles(diskSize);

        totalMove = (int) pow(2, diskSize) - 1;

        if (diskSize % 2 != 0) { // If disk size is a odd number
            for (int i = 1; i <= totalMove; ++i) {
                if (i % 3 == 0) { // Third step
                    moveBetweenTwoPoles(aux, dst);
                } else if (i % 3 == 1) { // First step 
                    moveBetweenTwoPoles(src, dst);
                } else if (i % 3 == 2) { // Second step
                    moveBetweenTwoPoles(src, aux);
                }
            }
        } else if (diskSize % 2 == 0) { // If disk size is a even number
            for (int i = 1; i <= totalMove; ++i) {
                if (i % 3 == 0) { // Third step
                    moveBetweenTwoPoles(aux, dst);
                } else if (i % 3 == 1) { // First step 
                    moveBetweenTwoPoles(src, aux);
                } else if (i % 3 == 2) { // Second step
                    moveBetweenTwoPoles(src, dst);
                }
            }
        }

        return true;
    }

    /**
     * Makes the handling between the two discs
     *
     * @param poleOne first pole
     * @param poleTwo second pole
     * @return returns true
     */
    private boolean moveBetweenTwoPoles(Pole poleOne, Pole poleTwo) {

        Integer firstDisk = new Integer(0);
        Integer secondDisk = new Integer(0);

        if (!poleOne.getPoleStack().empty()) {
            firstDisk = poleOne.getPoleStack().peek();
        }
        if (!poleTwo.getPoleStack().empty()) {
            secondDisk = poleTwo.getPoleStack().peek();
        }

        if (secondDisk.intValue() == 0) {
            firstDisk = poleOne.getPoleStack().pop();
            poleTwo.getPoleStack().push(firstDisk);
            System.out.println("Move disk " + firstDisk + " from " + poleOne.getPoleName() + " to " + poleTwo.getPoleName());
        } else if (firstDisk.intValue() == 0) {
            secondDisk = poleTwo.getPoleStack().pop();
            poleOne.getPoleStack().push(secondDisk);
            System.out.println("Move disk " + secondDisk + " from " + poleTwo.getPoleName() + " to " + poleOne.getPoleName());
        } else if (firstDisk.intValue() < secondDisk.intValue()) {
            firstDisk = poleOne.getPoleStack().pop();
            poleTwo.getPoleStack().push(firstDisk);
            System.out.println("Move disk " + firstDisk + " from " + poleOne.getPoleName() + " to " + poleTwo.getPoleName());
        } else if (firstDisk.intValue() > secondDisk.intValue()) {
            secondDisk = poleTwo.getPoleStack().pop();
            poleOne.getPoleStack().push(secondDisk);
            System.out.println("Move disk " + secondDisk + " from " + poleTwo.getPoleName() + " to " + poleOne.getPoleName());
        }

        return true;
    }

    private void createPoles(int newDiskSize) {
        for (int i = newDiskSize; i > 0; --i) {
            src.poleStack.push(new Integer(i));
        }
    }

    /**
     * Inner pole class
     */
    protected static class Pole {

        protected String poleName; // Pole name
        protected Stack<Integer> poleStack; // Pole stack

        protected Pole(String newPoleName) {
            poleName = newPoleName;
            poleStack = new Stack<Integer>();
        }

        protected String getPoleName() {
            return poleName;
        }

        protected void setPoleName(String newPoleName) {
            poleName = newPoleName;
        }

        protected Stack<Integer> getPoleStack() {
            return poleStack;
        }
    }
}
