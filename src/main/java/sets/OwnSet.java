package sets;

import java.util.*;

/**
 * <h1>Sets</h1>
 * The Sets program implements an application that
 * does operations on sets and Prints
 * the output on the screen.
 *
 * @author Krzysztof Chrusciel
 * @author Marcin Slota
 * @author Radoslaw Bednarczyk
 * @version 0.1.0
 * @since 2016-06-05
 */
public class OwnSet<E> implements Set<E> {

    List<Integer> list = new ArrayList<Integer>();

    public OwnSet() {
    }

    public OwnSet(E... elements) {
        if (elements != null) {
            for (E element : elements) {
                checkUnique(element);
                list.add((Integer) element);

            }
        }
    }

    /**
     * This method is used to check unique elements.
     *
     * @param element This is the first parameter to checkUnique method
     * @return True when is unique else throw exception.
     * @exception IllegalArgumentException when element exists in list.
     * @see IllegalArgumentException
     */
    public boolean checkUnique(E element) {
        if (list.contains(element)) {
            throw new IllegalArgumentException("Only unique elements!");
        }
        return true;
    }

    /**
     * This method is used to make an union of sets.
     *
     * @param setToCheck This is the first parameter to unionOfSets method
     * @return Set: This returns union of Sets
     */
    public OwnSet unionOfSets(OwnSet setToCheck) {
        OwnSet<Integer> unionSet = new OwnSet<Integer>();
        unionSet.addAll(setToCheck.getList());
        for (Integer element : list) {
            if (!setToCheck.contains(element)) {
                unionSet.add(element);
            }
        }
        return unionSet;
    }


    /**
     * This method is used to do a symmetric difference of sets.
     *
     * @param setToCheck This is the first parameter to checkUnique method
     * @return OwnSet: This returns symmetricDifference
     */
    public OwnSet symmetricDifferenceOfSets(OwnSet setToCheck) {
        OwnSet<Integer> symmetricDifference = new OwnSet<Integer>();

        for (Integer element : list) {
            if (!setToCheck.contains(element)) {
                symmetricDifference.add(element);
            }
        }

        for (Object element : setToCheck) {
            if (!list.contains(element)) {
                symmetricDifference.add((Integer) element);
            }
        }


        return symmetricDifference;
    }

    /**
     * This method is used to make an intersections of sets.
     *
     * @param setToCheck This is the first parameter to intersectionOfSets method
     * @return Set: This returns intersection of Sets.
     */
    public OwnSet intersectionOfSets(OwnSet setToCheck) {
        OwnSet<Integer> intersection = new OwnSet<Integer>();
        for (Integer element : list) {
            if (setToCheck.contains(element)) {
                intersection.add(element);
            }
        }

        for (Object element : setToCheck) {
            if (list.contains(element) && !intersection.contains(element)) {
                intersection.add((Integer) element);
            }
        }
        return intersection;
    }

    /**
     * This method is used to do a difference of sets.
     *
     * @param setToCheck This is the first parameter to differenceOfSets method
     * @return OwnSet: This returns difference.
     */
    public OwnSet differenceOfSets(OwnSet setToCheck) {
        OwnSet<Integer> difference = new OwnSet<Integer>();
        for (Integer element : list) {
            if (!setToCheck.contains(element)) {
                difference.add(element);
            }
        }
        return difference;
    }


    /**
     * This method is used to get List.
     *
     * @return List<Integer>: This returns list.
     */
    public List<Integer> getList() {
        return list;
    }

    /**
     * This method is used to get size.
     *
     * @return int: This returns size of list.
     */
    public int size() {
        return list.size();
    }

    /**
     * This method is used to check if list is empty.
     *
     * @return boolean: This returns true if list is empty.
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * This method is used to check if list contains object.
     *
     * @param o This is the first parameter to contains method
     * @return boolean: This returns true if list contains object o.
     */
    public boolean contains(Object o) {
        return list.contains((Integer) o);
    }

    /**
     * This method is used to iterate through list objects.
     *
     * @return Iterator<E>: This returns list objects.
     */
    public Iterator<E> iterator() {
        return (Iterator<E>) list.iterator();
    }

    /**
     * This method is used to store objects in Array.
     *
     * @return Object[]: This returns list as an Array.
     */
    public Object[] toArray() {
        return list.toArray();
    }

    /**
     * This method is used to store object a in Array.
     *
     * @param a This is the first parameter to toArray method
     * @return <T> T[]: This returns object a as an Array object.
     */
    public <T> T[] toArray(T[] a) {
        return list.toArray(a);
    }

    /**
     * This method is used to add e to list.
     *
     * @param e This is the first parameter to add method
     * @return boolean: This adds object e to list.
     */
    public boolean add(E e) {
        checkUnique(e);
        return list.add((Integer) e);
    }

    /**
     * This method is used to remove object o from list.
     *
     * @param o This is the first parameter to remove method
     * @return boolean: This removes object o from list.
     */
    public boolean remove(Object o) {
        return list.remove((Integer) o);
    }

    /**
     * This method is used to check if list contains collection of objects.
     *
     * @param c This is the first parameter to containsAll method
     * @return boolean: This returns object c from list.
     */
    public boolean containsAll(Collection<?> c) {
        return list.containsAll(c);
    }

    /**
     * This method is used to add all objects from collection to list.
     *
     * @param c This is the first parameter to addAll method
     * @return boolean: This adds collection to list.
     */
    public boolean addAll(Collection<? extends E> c) {
        return list.addAll((Collection<? extends Integer>) c);
    }

    /**
     * This method is used to retain all objects from collection in list.
     *
     * @param c This is the first parameter to retainAll method
     * @return boolean: This retains collection in list.
     */
    public boolean retainAll(Collection<?> c) {
        return list.retainAll(c);
    }

    /**
     * This method is used to remove all collection objects from list.
     *
     * @param c This is the first parameter to removeAll method
     * @return boolean: This removes collection from list.
     */
    public boolean removeAll(Collection<?> c) {
        return list.removeAll(c);
    }

    /**
     * This method is used to clear list.
     *
     * @return Nothing.
     */
    public void clear() {
        list = new ArrayList<Integer>();
    }

    @Override
    public String toString() {
        return "OwnSet{" +
                "list=" + list +
                '}';
    }
}
