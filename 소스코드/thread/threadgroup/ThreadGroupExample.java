package thread.threadgroup;

public class ThreadGroupExample {
        public static void main(String[] args) {
            ThreadGroup group = new ThreadGroup("myGroup");
            WorkThread workThread1 = new WorkThread(group, "workThread1");
            WorkThread workThread2 = new WorkThread(group, "workThread2");

            workThread1.start();
            workThread2.start();

            System.out.println("[ main 스레드 그룹 ]");
            ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
            mainGroup.list();

            try{
                Thread.sleep(3000);
            }catch (InterruptedException e){

            }

            System.out.println("[ myGroup 스레드 그룹의 interrupted 호출]");
            group.interrupt();
        }
}
