import sets.Set;

public class Runner {
    public static void main(String[] args) {
        System.out.println("Runner");
        Set set = new Set();
        set.addNumber(10);
        set.addNumber(12);
        set.addNumber(14);

        Set setToCheck = new Set();
        setToCheck.addNumber(20);
        setToCheck.addNumber(12);

        System.out.println(set.intersectionOfSets(setToCheck));
        System.out.println(set.symmetricDifference(setToCheck));
        System.out.println(set.unionOfSets(setToCheck));
        System.out.println(set.relativeComplementsOfSets(setToCheck));
    }
}
