### interrupt() 메소드를 이용하여 스레드를 정지시키기

스레드는 자신의 run() 메소드가 모두 실행되면 자동적으로 종료된다. 하지만 실행중인 스레드를 즉시 종료해야 할 때도 필요하다. (stop() 메소드가 존재하였으나, 종료시 자원들이 불안전한 상태로 남겨지기 때문에 deprecated 되었다.)

interrupt() 메소드는 스레드가 일시 정지 상태에 있을 때 **InterruptedException 예외**를 발생 시킨다.

이것을 이용하면 run() 메소드를 정상 종료시킬 수 있다.

> 스레드가 실행 대기 또는 실행 상태에 있을 때 interrupt() 메소드가 실행되면 즉시 InterruptedException 예외가 발생하지 않고, 스레드가 미래에 일시 정지 상태가 되면 InterruptedException 예외가 발생한다. (스레드가 일시 정지 상태가 되지 않으면 interrupt() 메소드 호출은 아무런 의미가 없다.)

따라서 하위 예제 코드에서는 잠시나마 일시정지 시키기위해 Thread.sleep(1)을 선언하였다.

```java
public class InterruptExample {
    // 1초 후 출력 스레드를 중지시킴
    public static void main(String[] args) {
        Thread thread = new PrintThread();
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt(); // 스레드를 종료시키기 위해 InterruptedException 발생
    }
}
```

```java
public class PrintThread extends Thread {
    @Override
    public void run() {
        try {
            while(true) {
                System.out.println("실행 중");
                Thread.sleep(1);
            }
        } catch (InterruptedException e) {
            System.out.println("interrupted 발생");
            e.printStackTrace();
        }
        System.out.println("자원 정리");
        System.out.println("실행 종료");
    }
}
```

일시 정지를 만들지 않고도 interrupt() 호출 여부를 알 수 있는 방법이 있는데 Thread.interrupted() 메소드를 실행시키는 것이다. 

```java
boolean status = Thread.interrupted();
if(status){
    // interrupted 발생
    break;
}
```

