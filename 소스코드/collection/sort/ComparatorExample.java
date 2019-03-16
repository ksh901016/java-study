package collection.sort;

import java.util.Iterator;
import java.util.TreeSet;

public class ComparatorExample {
    public static void main(String[] args) {
        //TreeSet<Fruit> treeSet = new TreeSet<Fruit>(new AscendingComparator()); // 오름차순
        TreeSet<Fruit> treeSet = new TreeSet<Fruit>(new DescendingComparator()); // 내림차순
        treeSet.add(new Fruit("딸기", 3000));
        treeSet.add(new Fruit("바나나", 1000));
        treeSet.add(new Fruit("사과", 4000));

        Iterator<Fruit> iterator = treeSet.iterator();
        while(iterator.hasNext()){
            Fruit fruit = iterator.next();
            System.out.println(fruit.getName() + "  :  " + fruit.getPrice());
        }
    }
}
