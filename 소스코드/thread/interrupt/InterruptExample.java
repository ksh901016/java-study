package thread;

public class InterruptExample {
    // 1초 후 출력 스레드를 중지시킴
    public static void main(String[] args) {
        Thread thread = new PrintThread();
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt(); // 스레드를 종료시키기 위해 InterruptedException 발생
    }
}
