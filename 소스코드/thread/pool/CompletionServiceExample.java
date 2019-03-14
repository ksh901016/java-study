package thread.pool;

import java.util.concurrent.*;

public class CompletionServiceExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(executorService);

        System.out.println("=작업 처리 요청=");
        for(int i=0; i<5; i++){
            completionService.submit(new Callable<Integer>() { // 스레드풀 작업요청
                @Override
                public Integer call() throws Exception {
                    int sum = 0;
                    for(int i=1; i<=10; i++){
                        sum += i;
                    }
                    return sum;
                }
            });
        }

        System.out.println("=처리 완료된 작업 확인=");
        executorService.submit(new Runnable(){ // 스레드 풀의 스레드에서 실행
            @Override
            public void run() {
                while(true){
                    try{
                        Future<Integer> future = completionService.take();
                        int value = future.get();
                        System.out.println("처리결과 >>>> " + value);
                    }catch(Exception e){
                        System.out.println(e.toString());
                        break;
                    }
                }
            }
        });

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdownNow();
        // shutdown()을 하면 스레드가 끝나지 않는다. (작업 완료된 것이 끝나면 스레드풀이 닫히기 떄문이다.)
        // 쉽게 실수 할 수있다., 나는 shutdown()으로 호출해서 한참 삽질했다.
    }
}
