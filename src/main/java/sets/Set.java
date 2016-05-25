package sets;


import java.util.ArrayList;
import java.util.List;

public class Set {

    private List<Integer> set;

    public Set() {
        set = new ArrayList<Integer>(100);
    }

    public List<Integer> getSet() {
        return set;
    }

    public Set intersectionOfSets(Set setToCheck) {
        Set intersectionSet = new Set();
        for (Integer numberFromSet : set) {
            if (setToCheck.getSet().contains(numberFromSet)) {
                intersectionSet.addNumber(numberFromSet);
            }
        }
        return intersectionSet;
    }

    public Set unionOfSets(Set setToCheck) {
        Set unionSet = new Set();
        addAllNumbersToSet(setToCheck, unionSet);
        addAllUniqueNumbersToSet(unionSet);
        return unionSet;
    }

    private void addAllUniqueNumbersToSet(Set unionSet) {
        for (Integer numberFromSet : set) {
            if (!unionSet.getSet().contains(numberFromSet)) {
                unionSet.addNumber(numberFromSet);
            }
        }
    }

    private void addAllNumbersToSet(Set setToCheck, Set unionSet) {
        for (Integer numberFromSet : setToCheck.getSet()) {
            unionSet.addNumber(numberFromSet);
        }
    }

    public Set relativeComplementsOfSets(Set setToCheck) {
        Set relativeComplementsSet = new Set();
        for (Integer numberFromSet : set) {
            if (!setToCheck.getSet().contains(numberFromSet)) {
                relativeComplementsSet.addNumber(numberFromSet);
            }
        }
        return relativeComplementsSet;
    }

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

    private void getComplementsNumbers(Set setToCheck, Set symmetricDifferenceSet) {
        for (Integer numberFromSet : setToCheck.getSet()) {
            if (!set.contains(numberFromSet)) {
                symmetricDifferenceSet.addNumber(numberFromSet);
            }
        }
    }

    public void addNumber(int newNumber) {
        if (set.contains(newNumber)) {
            throw new IllegalArgumentException("Element exists in set");
        }
        set.add(newNumber);
    }

    public void removeNumber(int numberToRemove) {
        set.remove(numberToRemove);
    }

    @Override
    public String toString() {
        return "Set: " + set;
    }
}
