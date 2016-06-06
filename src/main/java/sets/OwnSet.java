package sets;


import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collection;

/**
 * <h1>Sets</h1>
 * Our set implementation
 * <p>The Sets program implements an application that
 * does operations on sets and Prints
 * the output on the screen.</p>
 * @param <E> This is type o class
 * @author Krzysztof Chrusciel
 * @author Marcin Slota
 * @author Radoslaw Bednarczyk
 * @version 0.1.0
 * @since 2016-06-05
 */
public class OwnSet<E> implements Set<E> {

    /**
     * List for elements.
     */
    private List<Integer> list = new ArrayList<>();

    /**
     * Empty constructor.
     */
    public OwnSet() {
    }

    /**
     * Creates list with elements.
     * @param elements This is a parameter with elements
     */
    public OwnSet(final E... elements) {
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
    public final boolean checkUnique(final E element) {
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
    public final OwnSet unionOfSets(final OwnSet setToCheck) {
        final OwnSet<Integer> unionSet = new OwnSet<Integer>();
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
    public final OwnSet symmetricDifferenceOfSets(final OwnSet setToCheck) {
        final OwnSet<Integer> symmetricDifference = new OwnSet<Integer>();

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
     * @param setToCheck This is the first parameter
     *                   to intersectionOfSets method
     * @return Set: This returns intersection of Sets.
     */
    public final OwnSet intersectionOfSets(final OwnSet setToCheck) {
        final OwnSet<Integer> intersection = new OwnSet<Integer>();
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
    public final OwnSet differenceOfSets(final OwnSet setToCheck) {
        final OwnSet<Integer> difference = new OwnSet<Integer>();
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
     * @return List: This returns list.
     */
    public final List<Integer> getList() {
        return list;
    }

    /**
     * This method is used to set List.
     * @param listToSet This is the parameter for set list
     */
    public final void setList(final List<Integer> listToSet) {
        this.list = listToSet;
    }

    /**
     * This method is used to get size.
     *
     * @return int: This returns size of list.
     */
    public final int size() {
        return list.size();
    }

    /**
     * This method is used to check if list is empty.
     *
     * @return boolean: This returns true if list is empty.
     */
    public final boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * This method is used to check if list contains object.
     *
     * @param o This is the first parameter to contains method
     * @return boolean: This returns true if list contains object o.
     */
    public final boolean contains(final Object o) {
        return list.contains((Integer) o);
    }

    /**
     * This method is used to iterate through list objects.
     *
     * @return Iterator: This returns list objects.
     */
    public final Iterator<E> iterator() {
        return (Iterator<E>) list.iterator();
    }

    /**
     * This method is used to store objects in Array.
     *
     * @return Object[]: This returns list as an Array.
     */
    public final Object[] toArray() {
        return list.toArray();
    }

    /**
     * This method is used to store object a in Array.
     *
     * @param a This is the first parameter to toArray method
     * @param <T> This is the type parameter
     * @return T[]: This returns object a as an Array object.
     */
    public final <T> T[] toArray(final T[] a) {
        return list.toArray(a);
    }

    /**
     * This method is used to add e to list.
     *
     * @param e This is the first parameter to add method
     * @return boolean: This adds object e to list.
     */
    public final boolean add(final E e) {
        checkUnique(e);
        return list.add((Integer) e);
    }

    /**
     * This method is used to remove object o from list.
     *
     * @param o This is the first parameter to remove method
     * @return boolean: This removes object o from list.
     */
    public final boolean remove(final Object o) {
        return list.remove((Integer) o);
    }

    /**
     * This method is used to check if list contains collection of objects.
     *
     * @param c This is the first parameter to containsAll method
     * @return boolean: This returns object c from list.
     */
    public final boolean containsAll(final Collection<?> c) {
        return list.containsAll(c);
    }

    /**
     * This method is used to add all objects from collection to list.
     *
     * @param c This is the first parameter to addAll method
     * @return boolean: This adds collection to list.
     */
    public final boolean addAll(final Collection<? extends E> c) {
        return list.addAll((Collection<? extends Integer>) c);
    }

    /**
     * This method is used to retain all objects from collection in list.
     *
     * @param c This is the first parameter to retainAll method
     * @return boolean: This retains collection in list.
     */
    public final boolean retainAll(final Collection<?> c) {
        return list.retainAll(c);
    }

    /**
     * This method is used to remove all collection objects from list.
     *
     * @param c This is the first parameter to removeAll method
     * @return boolean: This removes collection from list.
     */
    public final boolean removeAll(final Collection<?> c) {
        return list.removeAll(c);
    }

    /**
     * This method is used to clear list.
     *
     */
    public final void clear() {
        list = new ArrayList<Integer>();
    }

    @Override
    public final String toString() {
        return "OwnSet{" + "list=" + list + '}';
    }
}
