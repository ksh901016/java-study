package lamda;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;

public class PredicateExample {

    private static List<Integer> numList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    public static int count(IntPredicate predicate){
        int count = 0;
        for(int num : numList){
            if(predicate.test(num)){
                count ++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int evenNumCount = count((num) ->{
            if(num % 2 == 0){
                return true;
            }
            return false;
        });

        System.out.println("짝수 갯수 : "  + evenNumCount);

        int oddNumCount = count((num) ->{
            if(num % 2 != 0){
                return true;
            }
            return false;
        });

        System.out.println("홀수 갯수 : "  + oddNumCount);
    }
}
