package lamda;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.ObjIntConsumer;

public class ConsumerExample {
    public static void main(String[] args) {
        Consumer<String> consumer = s -> System.out.println(s + " World!");
        consumer.accept("Hello");

        BiConsumer<String, String> biConsumer = (t, u) -> System.out.println(t + " " + u); // 두개의 파라미터를 소비
        biConsumer.accept("Hello", "World!");

        DoubleConsumer doubleConsumer = d -> System.out.println("num : " + d);
        doubleConsumer.accept(10);

        ObjIntConsumer<String> objIntConsumer = (t, u) -> System.out.println(t + u); // 객체, int 파라미터 소비
        objIntConsumer.accept("num : ", 10);
    }
}
