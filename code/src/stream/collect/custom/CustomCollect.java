package stream.collect.custom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CustomCollect {
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("a", "b", "c", "d", "e");
        List<String> list2 = Arrays.asList("a", "b", "d");
        // 2중 for문은 stream으로 어떻게 작성할까?
        // 만약 for문을 돌면서 같은 것만 list에 담고 싶다면?

        // 8버전 이전
        List<String> result1 = new ArrayList<>();
        for(String str1 : list1){
            for(String str2 : list2){
                if(str1.equals(str2)){
                    result1.add(str1);
                }
            }
        }
        for(String str : result1){
            System.out.print(str);
        }

        System.out.println();

        // 8버전 (stream 이용)
        List<String> result2 =
        list1.stream()
            .filter(str -> list2.stream().anyMatch(Predicate.isEqual(str)))
            .collect(Collectors.toList());

        result2.stream().forEach(System.out::print);
    }
}
