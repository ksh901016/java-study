package lamda.variable;

import lamda.basic.MyFunctionalInterface;

public class UsingThis {
    public int outterValue = 10;

    class Ineer{
        int innerValue = 20;

        void method(){
            MyFunctionalInterface fi = () -> {
                System.out.println("outterValue : " + outterValue);
                System.out.println("outterValue : " + UsingThis.this.outterValue + "\n");

                System.out.println("innerValue : " + innerValue);
                System.out.println("innerValue : " + this.innerValue + "\n"); // 람다식 내부에서 this는 Inner 객체를 참조
            };
            fi.method();
        }
    }
}
