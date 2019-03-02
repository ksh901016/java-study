package thread.cooperation;

public class ThreadA extends Thread{
    private WorkObject workObject;

    ThreadA(WorkObject workObject) {
        this.workObject = workObject;
    }
    
    public void run() {
        for(int i=0; i<10; i++) {
            workObject.methodA(); // 공유객체의 methodA를 반복적으로 호출 
        }
    }
}
