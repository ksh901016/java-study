package lamda;

import java.util.function.IntSupplier;

public class SupplierExample {
    public static void main(String[] args) {
        IntSupplier intSupplier = () ->{
            int num = (int) (Math.random() * 6) + 1; // 주사위 눈금
            return num;
        };

        int num = intSupplier.getAsInt();
        System.out.println(num);
    }
}
