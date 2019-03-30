package lamda.variable;

import lamda.basic.MyFunctionalInterface;

public class UsingLocalVariable {
    void method(int arg){
        int localVar = 40;

        MyFunctionalInterface fi = () -> {
            // 로컬 변수 읽기
            System.out.println("arg : " + arg);
            System.out.println("localVar : " + localVar + "\n");
        };

        fi.method();
    }
}
