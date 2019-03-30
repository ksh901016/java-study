package lamda.basic;

public class MyFunctionalInterfaceExample {
    public static void main(String[] args) {
        MyFunctionalInterface fi;
        fi = () -> {
            String str = "hello lamda!";
            System.out.println(str);
        };
        fi.method();

        fi = () -> System.out.println("hello again!");
        fi.method();

    }
}
