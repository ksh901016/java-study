package thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ResultByRuunableExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        System.out.println("=작업 처리 요청=");

        class Task implements Runnable{ // 작업을 정의
            Result result;
            Task(Result result) {this.result = result;} // 외부 객체를 필드에 저장

            @Override
            public void run() {
                int sum = 0;
                for(int i=0; i<=10; i++){
                    sum += i;
                }
                result.addValue(sum);
            }
        }

        /*** 두 가지 작업 처리를 요청 ***/
        Result result = new Result();
        Runnable task1 = new Task(result);
        Runnable task2 = new Task(result);
        Future<Result> future1 = executorService.submit(task1, result);
        Future<Result> future2 = executorService.submit(task2, result);

        /*** 두 가지 작업 결과를 취합 ***/
        try {
            result = future1.get();
            result = future2.get();
            System.out.println("결과 >>>>" + result.sumValue);
            System.out.println("=작업 처리 완료=");
        }catch (Exception e){
            e.printStackTrace();
        }

        executorService.shutdown();
    }
}

class Result{
    int sumValue;
    synchronized void addValue(int value){
        sumValue += value;
    }
}
