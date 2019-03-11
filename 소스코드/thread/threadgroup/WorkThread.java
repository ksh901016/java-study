package thread.threadgroup;

public class WorkThread extends Thread {

    public WorkThread(ThreadGroup threadGroup, String threadName){
        super(threadGroup, threadName); // 스레드 그룹과 이름 설정
    }

    @Override
    public void run() {
        while(true){
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                System.out.println(getName() + " interrupted");
                break;
            }
        }
        System.out.println(getName() + " 종료됨");
    }
}
