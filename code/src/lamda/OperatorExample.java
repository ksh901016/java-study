package lamda;

import java.util.function.IntBinaryOperator;

public class OperatorExample {
    private static int[] ages = {15, 20, 10, 50};

    public static int maxOrmin(IntBinaryOperator operator){
        int result = ages[0];
        for(int age : ages){
            result = operator.applyAsInt(result, age);
        }
        return result;
    }


    public static void main(String[] args) {
        // 최대값
        int max = maxOrmin((a, b) ->{
            if(a>=b) return a;
            else return b;
        });

        // 최소값
        int min = maxOrmin((a, b)->{
            if(a<=b) return a;
            else return b;
        });

        System.out.println("최대값 구하기 성공? : " + (max == 50));
        System.out.println("최소값 구하기 성공? : " + (min == 10));
    }
}
