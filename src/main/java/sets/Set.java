package sets;


import java.util.ArrayList;
import java.util.List;

/**
* <h1>Sets!</h1>
* The Sets program implements an application that
* does operations on sets and Prints
* the output on the screen.
* <p>
* <b>Note:</b> Giving proper comments in your program makes it more
* user friendly and it is assumed as a high quality code.
*
* @author  Wolverine111
* @version 1.0
* @since   2016-06-05
*/

public class Set {

    private List<Integer> set;

    public Set() {
        set = new ArrayList<Integer>(100);
    }

    public List<Integer> getSet() {
        return set;
    }

    /**
     * This method is used to make an intersections of sets. 
     * @param setToCheck This is the first parameter to intersectionOfSets method
     * @return Set: This returns intersection of Set
     */
    public Set intersectionOfSets(Set setToCheck) {
        Set intersectionSet = new Set();
        for (Integer numberFromSet : set) {
            if (setToCheck.getSet().contains(numberFromSet)) {
                intersectionSet.addNumber(numberFromSet);
            }
        }
        return intersectionSet;
    }

    /**
     * This method is used to make an union of sets. 
     * @param setToCheck This is the first parameter to unionOfSets method
     * @return Set: This returns union of Sets
     */
    public Set unionOfSets(Set setToCheck) {
        Set unionSet = new Set();
        addAllNumbersToSet(setToCheck, unionSet);
        addAllUniqueNumbersToSet(unionSet);
        return unionSet;
    }

    /**
     * This method is used to add all unique numbers to set. 
     * @param unionSet This is the first paramter to addAllUniqueNumbersToSet method
     */
    private void addAllUniqueNumbersToSet(Set unionSet) {
        for (Integer numberFromSet : set) {
            if (!unionSet.getSet().contains(numberFromSet)) {
                unionSet.addNumber(numberFromSet);
            }
        }
    }

    /**
     * This method is used to add all numbers to set. 
     * @param setToCheck This is the first paramter to addAllNumbersToSet method
     * @param unionSet This is the second paramter to addAllNumbersToSet method
     */
    private void addAllNumbersToSet(Set setToCheck, Set unionSet) {
        for (Integer numberFromSet : setToCheck.getSet()) {
            unionSet.addNumber(numberFromSet);
        }
    }

    /**
     * This method is used to make a relative complements of sets. 
     * @param setToCheck This is the first parameter to relativeComplementsOfSets method
     * @return Set: This returns relative complements of Sets
     */
    public Set relativeComplementsOfSets(Set setToCheck) {
        Set relativeComplementsSet = new Set();
        for (Integer numberFromSet : set) {
            if (!setToCheck.getSet().contains(numberFromSet)) {
                relativeComplementsSet.addNumber(numberFromSet);
            }
        }
        return relativeComplementsSet;
    }

    /**
     * This method is used to make a symmetric difference of sets. 
     * @param setToCheck This is the first parameter to symmetricDifference method
     * @return Set: This returns symmetric difference of Sets
     */
    public Set symmetricDifference(Set setToCheck) {
        Set symmetricDifferenceSet = new Set();
        for (Integer numberFromSet : set) {
            if (!setToCheck.getSet().contains(numberFromSet)) {
                symmetricDifferenceSet.addNumber(numberFromSet);
            }
        }
        getComplementsNumbers(setToCheck, symmetricDifferenceSet);
        return symmetricDifferenceSet;
    }

    /**
     * This method is used to get complements numbers. 
     * @param setToCheck This is the first parameter to symmetricDifference method
     * @param symmetricDifferenceSet This is the second parameter to symmetricDifference method
     */
    private void getComplementsNumbers(Set setToCheck, Set symmetricDifferenceSet) {
        for (Integer numberFromSet : setToCheck.getSet()) {
            if (!set.contains(numberFromSet)) {
                symmetricDifferenceSet.addNumber(numberFromSet);
            }
        }
    }

    /**
     * This method is used to add number. 
     * @param newNumber This is the first parameter to addNumber method
     */
    public void addNumber(int newNumber) {
        if (set.contains(newNumber)) {
            throw new IllegalArgumentException("Element exists in set");
        }
        set.add(newNumber);
    }

    /**
     * This method is used to remove number. 
     * @param numberToRemove This is the first parameter to removeNumber method
     */
    public void removeNumber(int numberToRemove) {
        set.remove(numberToRemove);
    }

    @Override
    public String toString() {
        return "Set: " + set;
    }
}
