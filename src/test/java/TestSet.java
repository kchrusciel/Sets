import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import sets.OwnSet;

import java.util.*;

import static com.googlecode.catchexception.apis.BDDCatchException.caughtException;
import static com.googlecode.catchexception.apis.BDDCatchException.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class TestSet {

    private OwnSet<Integer> set;

    @Before
    public void setUp() throws Exception {
        set = new OwnSet<>(10, 20, 30);
    }

    @Test
    @Parameters({"3"})
    public void shouldReturnSize(int expectedSize) {
        //When
        int size = set.size();
        //Then
        assertThat(size).isEqualTo(expectedSize);
    }

    @Test
    public void shouldThrowExceptionWhenAddNonUniqueElement() throws Exception {
        //When
        when(set).add(10);
        // Then
        then(caughtException())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Only unique elements!")
                .hasNoCause();
    }

    @Test
    @Parameters({
            "40",
            "50"})
    public void shouldReturnTrueWhenCheckElementIsUnique(int elementToCheck) throws Exception {
        //Given
        OwnSet<Integer> set = new OwnSet<>(10, 20, 30);
        //When
        boolean result = set.checkUnique(elementToCheck);
        // Then
        assertThat(result).isTrue();
    }

    @Test
    public void shouldReturnNotNullWhenGetList() {
        //Given
        set = new OwnSet<>();
        //When
        List<Integer> list = set.getList();
        //Then
        assertNotNull(list);
    }

    @Test
    @Parameters({
            "80",
            "90"})
    public void shouldReturnTrueWhenAddUniqueElement(int elementToCheck) throws Exception {
        //Given
        OwnSet<Integer> set = new OwnSet<>(10, 20, 30);
        //When
        boolean result = set.add(elementToCheck);
        // Then
        assertThat(result).isTrue();
    }

    @Test
    public void shouldReturnUnionOfSets() {
        //Given
        OwnSet<Integer> setToUnion = new OwnSet(10, 20, 30, 40);
        //When
        OwnSet<Integer> result = set.unionOfSets(setToUnion);
        List<Integer> expectedResult = setToUnion.getList();
        //Then
        assertThat(result).containsAll(expectedResult);
    }

    @Test
    @Parameters({"7"})
    public void shouldChangeSizeAfterUnion(int expectedSize) {
        //Given
        OwnSet<Integer> target = new OwnSet(40, 50, 60, 70);
        //When
        OwnSet<Integer> result = set.unionOfSets(target);
        int size = result.getList().size();
        //Then
        assertThat(size).isEqualTo(expectedSize);
    }

    @Test
    public void shouldReturnIntersectionOfSets() {
        //Given
        OwnSet<Integer> setToUnion = new OwnSet(10, 20, 30, 40);
        //When
        OwnSet<Integer> result = set.intersectionOfSets(setToUnion);
        List<Integer> expectedResult = set.getList();
        //Then
        assertThat(result).containsAll(expectedResult);
    }

    @Test
    public void shouldReturnZeroSizeAfterDifference() {
        //Given
        OwnSet<Integer> setToUnion = new OwnSet(10, 20, 30, 40);
        //When
        OwnSet<Integer> result = set.differenceOfSets(setToUnion);
        int size = result.size();
        //Then
        assertThat(size).isEqualTo(0);
    }

    @Test
    @Parameters({"1"})
    public void shouldReturnExpectedSizeAfterDifference(int expectedResult) {
        //Given
        set = new OwnSet<>(10, 20, 30, 50);
        OwnSet<Integer> target = new OwnSet<>(10, 20, 30, 40);
        //When
        OwnSet<Integer> result = set.differenceOfSets(target);
        int size = result.size();
        //Then
        assertThat(size).isEqualTo(expectedResult);
    }

    @Test
    public void shouldReturnNotNullAfterClear() {
        //When
        set.clear();
        //Then
        assertThat(set).isNotNull();
    }

    @Test
    public void shouldReturnZeroSizeAfterClear() {
        //When
        set.clear();
        int size = set.size();
        //Then
        assertThat(size).isEqualTo(0);
    }

    @Test
    public void shouldReturnFalseWhenCheckIsEmpty() {
        //When
        boolean result = set.isEmpty();
        //Then
        assertThat(result).isFalse();
    }

    @Test
    public void shouldReturnTrueWhenCheckIsEmpty() {
        //Given
        OwnSet<Integer> setToCheck = new OwnSet<>();
        //When
        boolean result = setToCheck.isEmpty();
        //Then
        assertThat(result).isTrue();
    }

    @Test
    public void shouldReturnChangedSizeAfterAdd() {
        //Given
        int sizeBeforeAdd = set.size();
        //When
        set.add(50);
        int sizeAfterAdd = set.size();
        //Then
        assertThat(sizeAfterAdd).isEqualTo(sizeBeforeAdd + 1);
    }

    @Test
    public void shouldChangeSizeAfterRemoveExistingElement() throws Exception {
        //Given
        int sizeBeforeRemove = set.size();
        //When
        set.remove(10);
        int sizeAfterRemove = set.size();
        //Then
        assertThat(sizeAfterRemove).isEqualTo(sizeBeforeRemove - 1);
    }

    @Test
    public void shouldNotChangeSizeAfterRemoveNonExistingElement() throws Exception {
        //Given
        int sizeBeforeRemove = set.size();
        //When
        set.remove(100);
        int sizeAfterRemove = set.size();
        //Then
        assertThat(sizeAfterRemove).isEqualTo(sizeBeforeRemove);
    }

    @Test
    @Parameters({
            "10, true",
            "50, false"})
    public void shouldReturnBooleanValue(int valueToCheck, boolean expectedValue) throws Exception {
        //When
        boolean result = set.contains(valueToCheck);
        //Then
        assertThat(result).isEqualTo(expectedValue);
    }

    @Test
    public void shouldReturnTrueAfterContainsAllCheck() throws Exception {
        //Given
        List<Integer> listToCheck = new ArrayList<>(Arrays.asList(20, 30));
        //When
        boolean result = set.containsAll(listToCheck);
        //Then
        assertThat(result).isTrue();
    }

    @Test
    public void shouldReturnFalseAfterContainsAllCheck() throws Exception {
        //Given
        List<Integer> listToCheck = new ArrayList<>(Arrays.asList(20, 30, 50, 10000));
        //When
        boolean result = set.containsAll(listToCheck);
        //Then
        assertThat(result).isFalse();
    }

    @Test
    public void shouldReturnSymmetricDifferenceOfSets() throws Exception {
        //When
        OwnSet<Integer> setToUnion = new OwnSet(10, 20, 30, 40);
        //Then
        OwnSet<Integer> result = set.symmetricDifferenceOfSets(setToUnion);
        List<Integer> expectedResult = new ArrayList<>(Arrays.asList(40));
        //Then
        assertThat(result).containsAll(expectedResult);
    }

    @Test
    @Parameters({"1"})
    public void shouldChangeSizeAfterSymmetricDifferenceOfSets(int expectedValue) throws Exception {
        //When
        OwnSet<Integer> setToUnion = new OwnSet(10, 20, 30, 40);
        //Then
        OwnSet<Integer> differenceOfSets = set.symmetricDifferenceOfSets(setToUnion);
        int result = differenceOfSets.size();
        //Then
        assertThat(result).isEqualTo(1);
    }

    private boolean isUnique(OwnSet param) {
        List<Integer> list = param.getList();
        Set<Integer> set = new HashSet<>(list);

        if (set.size() < list.size()) {
            return false;
        }
        return true;
    }

    @Test
    public void compareOperationintersectionOfSets() {
        //Given
        OwnSet<Integer> target = new OwnSet<>(10);

        OwnSet<Integer> resultOfIntersection = set.intersectionOfSets(target);
        OwnSet<Integer> resultOfDifference = set.differenceOfSets(target);


        assertEquals(set.size(), (resultOfIntersection.size() + resultOfDifference.size()));

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

    @Test
    public void compareOperationSymmetricDifferenceOfSets() {
        OwnSet<Integer> source = new OwnSet<>(20, 30, 50);
        OwnSet<Integer> target = new OwnSet<>(10, 70, 90);

        OwnSet<Integer> resultU = source.unionOfSets(target);
        OwnSet<Integer> resultI = source.intersectionOfSets(target);
        OwnSet<Integer> resultS = source.symmetricDifferenceOfSets(target);

        if (resultU.size() - resultI.size() == resultS.size()) {
            assertTrue(true);
        }
        assertFalse(false);
    }

}
