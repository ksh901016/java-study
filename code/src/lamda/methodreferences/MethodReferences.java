package lamda.methodreferences;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntBinaryOperator;

public class MethodReferences {
    public static void main(String[] args) {
        List<String> strList = Arrays.asList("안녕", "하세요");
        strList.stream().forEach(System.out::println);

        // static 메소드 참조
        IntBinaryOperator operator;
        operator = (x, y) -> Calculator.staticAdd(x, y);
        System.out.println(operator.applyAsInt(1, 2));

        operator = Calculator::staticAdd; // 메소드 참조
        System.out.println(operator.applyAsInt(1, 2));

        // instance 메소드 참조
        Calculator calculator = new Calculator();
        operator = (x, y) -> calculator.instanceAdd(x, y);
        System.out.println(operator.applyAsInt(1, 2));

        operator = calculator::instanceAdd; // 메소드 참조
        System.out.println(operator.applyAsInt(1, 2));
    }
}
