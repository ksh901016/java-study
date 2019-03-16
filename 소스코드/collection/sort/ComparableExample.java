package collection.sort;

import java.util.Iterator;
import java.util.TreeSet;

public class ComparableExample {
    public static void main(String[] args) {
        TreeSet<Person> treeSet = new TreeSet<Person>();

        treeSet.add(new Person("김씨", 40)); // 나이순으로 저장
        treeSet.add(new Person("임씨", 20));
        treeSet.add(new Person("강씨", 30));

        Iterator<Person> iterator = treeSet.iterator();
        while(iterator.hasNext()){
            Person person = iterator.next();
            System.out.println(person.getName() + "  :  " + person.getAge());
        }
    }
}
