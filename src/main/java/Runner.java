import sets.OwnSet;

public class Runner {
    public static void main(String[] args) {
//        OwnSet<Integer> set = new OwnSet(10, 20, 30, 20, 10); //For exception
        OwnSet<Integer> set = new OwnSet(10, 20, 30);
        System.out.println(set);
        System.out.println(set.getList());
        System.out.println(set.unionOfSets(new OwnSet(60, 50, 40, 10, 30))); //Union uniques
        System.out.println(set.symmetricDifferenceOfSets(new OwnSet(30, 40, 50))); //Unique
        System.out.println(set.intersectionOfSets(new OwnSet(30, 40, 50)));
        System.out.println(set.differenceOfSets(new OwnSet(30, 40, 50)));

        System.out.println(set.size());
        System.out.println(set.isEmpty());
        System.out.println(set.contains(10));


    }
}
