package sets;

import java.util.*;

/**
 * Created by Krzysztof Chruściel.
 */
public class OwnSet<E> implements Set<E> {

    List<Integer> list = new ArrayList<Integer>();

    public OwnSet() {
    }

    public OwnSet(E... elements) {
    	if(elements!=null){
	        for (E element : elements) {
	            checkUnique(element);
	            list.add((Integer) element);
	
	        }
    	}
    }

    private void checkUnique(E element) {
        if (list.contains(element)) {
            throw new IllegalArgumentException("Only unique elements!");
        }
    }

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

    public OwnSet intersectionOfSets(OwnSet setToCheck) {
        OwnSet<Integer> intersection = new OwnSet<Integer>();
        for (Integer element : list) {
            if (setToCheck.contains(element)) {
                intersection.add(element);
            }
        }

        for (Object element : setToCheck) {
            if (list.contains(element)) {
                if (!intersection.contains(element)) {
                    intersection.add((Integer) element);
                }
            }
        }
        return intersection;
    }

    public OwnSet differenceOfSets(OwnSet setToCheck) {
        OwnSet<Integer> difference = new OwnSet<Integer>();
        for (Integer element : list) {
            if (!setToCheck.contains(element)) {
                difference.add(element);
            }
        }
        return difference;
    }


    public List<Integer> getList() {
        return list;
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public boolean contains(Object o) {
        return list.contains((Integer) o);
    }

    public Iterator<E> iterator() {
        return (Iterator<E>) list.iterator();
    }

    public Object[] toArray() {
        return list.toArray();
    }

    public <T> T[] toArray(T[] a) {
        return list.toArray(a);
    }

    public boolean add(E e) {
        checkUnique(e);
        return list.add((Integer) e);
    }

    public boolean remove(Object o) {
        return list.remove((Integer) o);
    }

    public boolean containsAll(Collection<?> c) {
        return list.containsAll(c);
    }

    public boolean addAll(Collection<? extends E> c) {
        return list.addAll((Collection<? extends Integer>) c);
    }

    public boolean retainAll(Collection<?> c) {
        return list.retainAll(c);
    }

    public boolean removeAll(Collection<?> c) {
        return list.removeAll(c);
    }

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
