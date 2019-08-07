package lamda.methodreferences;

import java.util.function.BiFunction;
import java.util.function.Function;

public class MethodReferences3 {
    public static void main(String[] args) {
        Function<String, Account> function1 = Account::new;
        Account account = function1.apply("아이디");

        BiFunction<String, String, Account> function2 = Account::new;
        Account account2 = function2.apply("아이디", "패스워드");

        System.out.println(account);
        System.out.println(account2);
    }
}
