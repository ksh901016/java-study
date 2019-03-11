package thread.threadgroup;


import thread.daemon.AutoSaveThread;

import java.util.Map;
import java.util.Set;

public class ThreadInfoExample {
    public static void main(String[] args) {
        AutoSaveThread autoSaveThread = new AutoSaveThread();
        autoSaveThread.setName("AutoSaveThread");
        autoSaveThread.setDaemon(true);
        autoSaveThread.start();

        Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces(); // 프로세스 내에서 실행하는 모든 스레드의 정보를 얻음
        Set<Thread> threads = map.keySet();

        for(Thread thread : threads){
            System.out.println("Name : " + thread.getName() + ((thread.isDaemon()) ? "[Daemon]" : "[Main]"));
            System.out.println("\t" + "Group : " + thread.getThreadGroup().getName());
            System.out.println();
        }
    }
}
