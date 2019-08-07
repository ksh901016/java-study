package lamda.methodreferences;

import java.util.function.ToIntBiFunction;

public class MethodReferences2 {
    public static void main(String[] args) {
        ToIntBiFunction<String, String> function;

        function = String::compareToIgnoreCase;
        System.out.println(function.applyAsInt("hello", "HELLO") == 0 ? "동일한 문자열" : "문자열 다름");
    }
}
