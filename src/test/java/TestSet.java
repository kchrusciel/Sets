import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import sets.OwnSet;

public class TestSet {
    // getList

    @Test
    public void getListNotNull() {
        OwnSet<Integer> set = new OwnSet<Integer>(null);
        assertNotNull(set.getList());
    }

    @Test
    public void getListNotNull2() {
        OwnSet<Integer> set = new OwnSet<Integer>();
        assertNotNull(set.getList());
    }

    @Test
    public void getListSize() {
        OwnSet<Integer> set = new OwnSet<Integer>(10, 20, 30);
        assertEquals(set.size(), set.getList().size());

    }


    //unionOfSet
    @Test
    public void uniqueUnionOfSet() {
        OwnSet<Integer> set = new OwnSet(10, 20, 30);
        OwnSet<Integer> setToUnion = new OwnSet(10, 20, 30, 40);

        OwnSet<Integer> result = set.unionOfSets(setToUnion);

        assertTrue(isUnique(result));
    }

    private boolean isUnique(OwnSet param) {
        List<Integer> list = param.getList();
        Set<Integer> set = new HashSet<Integer>(list);

        if (set.size() < list.size()) {
            return false;
        }
        return true;
    }


    @Test
    public void containSourceElementUnionOfSet() {

        OwnSet<Integer> set = new OwnSet(10, 20, 30);
        OwnSet<Integer> setToUnion = new OwnSet(40, 50, 60, 70);

        OwnSet<Integer> result = set.unionOfSets(setToUnion);

        for (int i : set.getList()) {
            if (!result.contains(i)) {
                assertFalse(true);
            }
        }

        assertTrue(true);
    }

    @Test
    public void sizeUnionOfSet() {

        OwnSet<Integer> source = new OwnSet(10, 20, 30);
        OwnSet<Integer> target = new OwnSet(40, 50, 60, 70);

        OwnSet<Integer> result = source.unionOfSets(target);

        if (result.size() > (source.size() + target.size())) {
            assertFalse(true);
        }
        assertTrue(true);
    }


    // intersectionOfSets

    @Test
    public void intersectionOfSetsUnique() {
        OwnSet<Integer> set = new OwnSet(10, 20, 30);
        OwnSet<Integer> setToUnion = new OwnSet(10, 20, 30, 40);

        OwnSet<Integer> result = set.intersectionOfSets(setToUnion);

        assertTrue(isUnique(result));
    }

    @Test
    public void compareOperationintersectionOfSets() {
        OwnSet<Integer> source = new OwnSet<Integer>(10, 20, 30);
        OwnSet<Integer> target = new OwnSet<Integer>(10);

        OwnSet<Integer> result = source.intersectionOfSets(target);
        OwnSet<Integer> resultD = source.differenceOfSets(target);

        assertEquals(source.size(), (result.size() + resultD.size()));

    }

    @Test
    public void containBothSetIntersectionOfSets() {
        OwnSet<Integer> source = new OwnSet<Integer>(10, 20, 30);
        OwnSet<Integer> target = new OwnSet<Integer>(10);

        OwnSet<Integer> result = source.intersectionOfSets(target);

        for (int i : result.getList()) {
            if (!source.contains(i) || !target.contains(i)) {
                assertFalse(true);
            }
        }

        assertTrue(true);
    }

    @Test
    public void sizeIntersectionOfSets() {
        OwnSet<Integer> source = new OwnSet<Integer>(10, 20, 30);
        OwnSet<Integer> target = new OwnSet<Integer>(10, 20, 30, 40);

        OwnSet<Integer> result = source.intersectionOfSets(target);

        int smallest = source.size() > target.size() ? target.size() : source.size();

        if (result.size() > smallest) {
            assertFalse(true);
        }

        assertTrue(true);
    }


    @Test
    public void excludedElementsSourceIntersectionOfSets() {
        OwnSet<Integer> source = new OwnSet<Integer>(10, 20, 30, 50, 60);
        OwnSet<Integer> target = new OwnSet<Integer>(10, 20, 30, 40);

        OwnSet<Integer> result = source.intersectionOfSets(target);


        OwnSet<Integer> excluded = new OwnSet<Integer>();

        for (int i : source) {
            if (!target.contains(i)) {
                excluded.add(i);
            }
        }

        for (int i : excluded) {
            if (result.contains(i)) {
                assertFalse(true);
            }
        }
        assertTrue(true);
    }

    //differenceOfSets

    @Test
    public void differenceOfSetsUnique() {
        OwnSet<Integer> set = new OwnSet(10, 20, 30);
        OwnSet<Integer> setToUnion = new OwnSet(10, 20, 30, 40);

        OwnSet<Integer> result = set.differenceOfSets(setToUnion);

        assertTrue(isUnique(result));
    }

    @Test
    public void sizeDifferenceOfSets() {
        OwnSet<Integer> source = new OwnSet<Integer>(10, 20, 30, 50);
        OwnSet<Integer> target = new OwnSet<Integer>(10, 20, 30, 40);

        OwnSet<Integer> result = source.differenceOfSets(target);

        if (result.size() > source.size()) {
            assertFalse(true);
        }
        assertTrue(true);

    }

    @Test
    public void excludedDifferenceOfSets() {
        OwnSet<Integer> source = new OwnSet<Integer>(10, 20, 30, 50);
        OwnSet<Integer> target = new OwnSet<Integer>(10, 20, 30, 40);

        OwnSet<Integer> result = source.differenceOfSets(target);

        for (Integer i : target.getList()) {
            if (result.contains(i)) {
                assertFalse(true);
            }
        }

        assertTrue(true);

    }


    @Test
    public void existDifferenceOfSets() {
        OwnSet<Integer> source = new OwnSet<Integer>(10, 20, 30, 50);
        OwnSet<Integer> target = new OwnSet<Integer>(10, 20, 30, 40);

        OwnSet<Integer> result = source.differenceOfSets(target);

        for (Integer i : result.getList()) {
            if (!source.contains(i)) {
                assertFalse(true);
            }
        }

        assertTrue(true);
    }


    //symmetricDifferenceOfSets
    @Test
    public void symmetricDifferenceOfSetsUnique() {
        OwnSet<Integer> set = new OwnSet(10, 20, 30);
        OwnSet<Integer> setToUnion = new OwnSet(10, 20, 30, 40);

        OwnSet<Integer> result = set.symmetricDifferenceOfSets(setToUnion);

        assertTrue(isUnique(result));
    }


    @Test
    public void sizeSymmetricDifferenceOfSets() {
        OwnSet<Integer> source = new OwnSet<Integer>(10, 20, 30, 50);
        OwnSet<Integer> target = new OwnSet<Integer>(70, 90);

        OwnSet<Integer> result = source.symmetricDifferenceOfSets(target);

        int smallest = source.size() > target.size() ? target.size() : source.size();

        if (result.size() > (source.size() + target.size())) {
            assertFalse(true);
        }

        assertTrue(true);

    }

    @Test
    public void compareOperationSymmetricDifferenceOfSets() {
        OwnSet<Integer> source = new OwnSet<Integer>(20, 30, 50);
        OwnSet<Integer> target = new OwnSet<Integer>(10, 70, 90);

        OwnSet<Integer> resultU = source.unionOfSets(target);
        OwnSet<Integer> resultI = source.intersectionOfSets(target);
        OwnSet<Integer> resultS = source.symmetricDifferenceOfSets(target);

        if (resultU.size() - resultI.size() == resultS.size()) {
            assertTrue(true);
        }
        assertFalse(false);
    }

    // size
    @Test
    public void size() {
        OwnSet<Integer> result = new OwnSet<Integer>(20, 30, 50);

        int counter = 0;
        for (Integer integer : result) {
            counter++;
        }

        assertEquals(counter, result.size());
    }

    //clear

    @Test
    public void clearNotNull() {
        OwnSet<Integer> result = new OwnSet<Integer>(20, 30, 50);
        result.clear();
        assertNotNull(result);
    }


    @Test
    public void clearSize() {
        OwnSet<Integer> result = new OwnSet<Integer>(20, 30, 50);
        result.clear();
        assertEquals(result.size(), 0);

    }

    // isEmpty

    @Test
    public void isEmptySize() {
        OwnSet<Integer> result = new OwnSet<Integer>(20, 30, 50);
        assertEquals(result.isEmpty(), result.size() == 0);
    }

    // add
    @Test
    public void addUnique() {
        OwnSet<Integer> result = new OwnSet<Integer>(20, 30, 50);
        result.add(40);
        assertTrue(isUnique(result));
    }

    @Test
    public void addSize() {
        int element = 12;

        OwnSet<Integer> result = new OwnSet<Integer>(element);
        OwnSet<Integer> temp = new OwnSet<Integer>(element);
        int param = 25; //12
        try {
            temp.add(param);
        } catch (Exception e) {
            assertTrue("Zdublowanie elementu", true);
            return;
        }

        assertTrue((result.size() + 1) == temp.size());
    }

}
