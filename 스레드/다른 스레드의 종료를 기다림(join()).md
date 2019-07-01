### 다른 스레드의 종료를 기다림(join())

스레드는 다른 스레드와 독립적으로 실행되는 것이 일반적이지만, 다른 스레드가 종료될 때까지 기다리다가 실행되야되는 경우가 발생할 수 있다.

예를 들어 B라는 스레드는 계산을하는 스레드이고, A라는 스레드는 B스레드가 계산이 끝나면 그 결과값을 가지고 로직을 처리해야하는 상황이다.

이 와같은 상황은 아래와 같은 코드를 이용해 구현할 수 있다.(join() 이용)

```java
ThreadA{
	threadB.start(); // ThreadB 실행 (실행순서 1)
	threadB.join();  // 일시정지

	...ThreadA의 로직 수행 ; // (실행순서 3)
}
    
ThreadB{
    run(){
      // ThreadB 작업 실행(실행순서 2)
	}
}
```

ThreadA가 ThreadB의 join() 메소드를 호출하면 ThreadA는 ThreadB가 종료할 때까지 일시정지 상태가 되고 ThreadB의 run()이 종료되면 ThreadA는 일시정지에서 풀려 다음 코드를 실행하게 된다.



예제 코드를 살펴보자.

Main Thread에서는 SumThread에서의 계산이 끝난 결과를 찍어줘야 하므로, MainThread에서 SumThread.join() 메서드를 호출하는 것을 볼 수 있다.

```java
public class SumThread extends Thread{
    private long sum;
    
    public long getSum() {
        return sum;
    }
    
    public void setSum(long sum) {
        this.sum = sum;
    }
    
    public void run() {
        for(int i=1; i<=100; i++) {
            sum+=i;
        }
    }
}
```



```java
public class JoinExample {
    public static void main(String[] args) {
        SumThread sumThread = new SumThread();
        sumThread.start();
        
        try {
            sumThread.join(); // sumThread가 종료될때까지 메인 스레드를 정지시킴 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("1 ~ 100까지의 합 : " + sumThread.getSum());
    }
}
```

