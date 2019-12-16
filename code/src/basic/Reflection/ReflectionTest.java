package basic.Reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionTest {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        int num = 1000;

        ReflectionTest test = new ReflectionTest();

        Class clazz = ReflectionTest.class;

        Method method = clazz.getMethod("count");
        long before = System.currentTimeMillis();
        for(int i=0; i<num; i++) method.invoke(test);
        System.out.println(System.currentTimeMillis() - before);


        before = System.currentTimeMillis();
        for(int i=0; i<num; i++) test.count();
        System.out.println(System.currentTimeMillis() - before);



    }

    public void count(){

    }
}
