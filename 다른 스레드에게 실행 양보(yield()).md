### 스레드 상태제어

스레드를 일시정지 상태로 만들거나, 정지된 스레드를 다시 실행시키거나 하는 행위 즉, 실행 중인 스레드의 상태 변경하는 것을 **스레드 상태 제어**라고 한다.

몇 가지 스레드 상태 제어 함수를 알아보자

**다른 스레드에게 실행 양보(yield())**

스레드 실행 양보 예제

ThreadA 정의

```java
public class ThreadA extends Thread{
    public boolean stop = false; // 종료 플래그
    public boolean work = true;  // 작업 진행 여부 플래
    
    public void run() {
        while(!stop) {
            if(work) {
                System.out.println("ThreadA가 작업중입니다.");
            }else {
                Thread.yield(); // work false시, 다른 스레드에 양보 
            }
        }
        System.out.println("ThreadA가 종료되었습니다.");
    }
}
```

ThreadB 정의

```java
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
```

```java
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
```

