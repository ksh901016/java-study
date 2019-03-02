package thread.yield;

public class YieldExample {
    public static void main(String[] args) {
        ThreadA threadA = new ThreadA();
        ThreadB threadB = new ThreadB();
        
        threadA.start();
        threadB.start();
        
        try { Thread.sleep(1000); } catch (InterruptedException e) { }
        threadA.work = false; // thread B만 실행
        
        try { Thread.sleep(1000); } catch (InterruptedException e) { }
        threadA.work = true;  // thread A, B 둘다 실행 
        
        try { Thread.sleep(1000); } catch (InterruptedException e) { }
        threadA.stop = true;
        threadB.stop = true; // 둘다 종료 
    }
}
