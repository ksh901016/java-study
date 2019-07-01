### Comparable과 Comparator

Comparable, Comparator 항상 헷갈리는 부분이다. 예전에 포스팅을 했지만 항상 까먹기 때문에,,, 책에 나온김에 다시 한번 정리할겸 포스팅을 한다. (https://cornswrold.tistory.com/23)

TreeSet, TreeMap은 정렬을 위해 java.lang.Comparable 구현한 객체를 요구한다. 우리가 아는 Wrapper 객체는 모두 Comparable 인터페이스를 구현하고 있다.(Integer, Double, String ..)

Comparable에는 compareTo() 메소드가 존재하고 적절하게 오버라이딩하여 정렬을 할 수 있게 한다.

| 리턴타입 | 메소드         | 설명                                                         |
| -------- | -------------- | ------------------------------------------------------------ |
| int      | compareTo(T o) | 객체가 같으면 0 리턴<br />주어진 객체보다 작으면 음수 리턴<br />주어진 객체보다 크면 양수 리턴 |

Person 객체를 하나 만들어서 나이 순(오름차순)으로 정렬을 해보자.

```java
public class Person implements Comparable<Person> {

    private String name;
    private int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person o) {
        if(age < o.getAge()) return -1;
        else if(age == o.getAge()) return 0;
        else return 1;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
```



```java
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
```

나이 오름차순으로 정렬되어 들어간 것을 볼 수 있다.

> 임씨  :  20
>
> 강씨  :  30
>
> 김씨  :  40



TreeSet 객체와 TreeMap의 키가 Comparable을 구현하고 있지 않을 경우에는 Exception이 발생한다.

Comparable 인터페이스가 구현되지 않은 클래스를 정렬시키려면 Comparator 인터페이스를 구현한 클래스로 정렬시킬 수 있다. (Comparator 객체를 이용하면 Comparable 미구현 클래스도 정렬을 시킬 수 있다.)

```java
TreeSet<E> set = new TreeSet<E>(new Comparator구현체());
TreeMap<K,V> map = new TreeMap<K,V>(new Comparator구현체());
```

Comparator 인터페이스는 compareTo 메소드를 갖는다.

| 리턴 타입 | 메소드                | 설명                                                         |
| --------- | --------------------- | ------------------------------------------------------------ |
| int       | comparaTo(T o1, T o2) | o1과 o2가 같으면 0 리턴<br />o1이 o2보다 앞에 오게 하려면 음수 리턴<br />o1이 o2보다 뒤에 오게 하려면 양수 리턴 |

Comparable이 구현되있지 않은 Fruit 클래스 생성

```java
public class Fruit {
    private String name;
    private int price;

    public Fruit(String name, int price){
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
```

오름차순, 내림차순으로 정렬하는 Comparator를 생성

```java
public class AscendingComparator implements Comparator<Fruit> {

    @Override
    public int compare(Fruit o1, Fruit o2) {
        if(o1.getPrice() < o2.getPrice()) return -1;
        else if(o1.getPrice() == o2.getPrice()) return 0;
        else return 1;
    }
}

public class DescendingComparator implements Comparator<Fruit> {
    @Override
    public int compare(Fruit o1, Fruit o2) {
        if(o1.getPrice() < o2.getPrice()) return 1;
        else if(o1.getPrice() == o2.getPrice()) return 0;
        else return -1;
    }
}
```

Comparable이 구현되있지 않은 과일객체를 가격으로 정렬하기

```java
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
```

>사과  :  4000
>
>딸기  :  3000
>
>바나나  :  1000

