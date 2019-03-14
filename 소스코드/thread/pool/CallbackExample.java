package thread.pool;

import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CallbackExample {
    private ExecutorService executorService;

    public CallbackExample(){
        executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    }

    private CompletionHandler<Integer, Void> callback =
        new CompletionHandler<Integer, Void>() {
            @Override
            public void completed(Integer result, Void attachment) {
                System.out.println("실행 완료(completed) " + result);
            }

            @Override
            public void failed(Throwable exc, Void attachment) {
                System.out.println("실행 실패(failed) " + exc.toString());
            }
        };

    public void doWork(final String x, final String y){
        Runnable task = new Runnable() {
            @Override
            public void run() {
                try {
                    int intX = Integer.parseInt(x);
                    int intY = Integer.parseInt(y);
                    int result = intX + intY;
                    callback.completed(result, null); // 성공
                }catch(NumberFormatException e){
                    callback.failed(e, null); // 예외발생
                }
            }
        };

        executorService.submit(task);
    }

    public void finish(){
        executorService.shutdown(); // 스레드풀 종료
    }

    public static void main(String[] args) {
        CallbackExample example = new CallbackExample();
        example.doWork("3", "3");
        example.doWork("3", "삼");
        example.finish();
    }
}
