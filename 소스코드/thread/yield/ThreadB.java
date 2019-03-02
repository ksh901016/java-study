package thread.yield;

public class ThreadB extends Thread{
    public boolean stop = false; // 종료 플래그
    public boolean work = true;  // 작업 진행 여부 플래그 
    
    public void run() {
        while(!stop) {
            if(work) {
                System.out.println("ThreadB가 작업중입니다.");
            }else {
                Thread.yield(); // work false시, 다른 스레드에 양보 
            }
        }
        System.out.println("ThreadB가 종료되었습니다.");
    }
}
