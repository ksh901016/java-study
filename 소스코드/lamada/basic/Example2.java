package lamda.basic;

public class Example2 {
    public static void main(String[] args) {
        MyFunctionalInterface2 fi;
        fi = (x) -> {
            int result = x * 5;
            System.out.println(result);
        };
        fi.method(5);

        fi = x -> System.out.println(x*5); // 매개 변수가 하나일 경우 괄호를 생략, 실행문 하나일 때 중괄호 생략 가능
        fi.method(5);
    }
}
