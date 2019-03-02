package thread.join;

public class JoinExample {
    public static void main(String[] args) {
        SumThread sumThread = new SumThread();
        sumThread.start();
        
        try {
            sumThread.join(); // sumThread가 종료될때까지 메인 스레드를 정지시킴 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("1 ~ 100까지의 합 : " + sumThread.getSum());
    }
}
