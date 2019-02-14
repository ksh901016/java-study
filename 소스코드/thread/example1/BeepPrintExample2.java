package thread.example1;

import java.awt.Toolkit;

public class BeepPrintExample2 {
	public static void main(String[] args){
		// 쓰레드가 동작
		Runnable beepTask = new BeepTask();
		Thread thread = new Thread(beepTask); // 작업스레드 생성
		thread.start();
		
		for(int i=0; i<5; i++){
			System.out.println("띵");
			try{ Thread.sleep(500);}catch(Exception e){}
		}
	}
	
	// 익명 객체를 이용하는 방법
	Thread thread2 = new Thread(new Runnable() {
		
		@Override
		public void run() {
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			
			for(int i=0; i<5; i++){
				toolkit.beep();
				try{ Thread.sleep(500);}catch(Exception e){} // 0.5초간 일시 정지
			}
		}
	});
	
	// 람다식을 이용하는 방법 (Java 8)
	Thread thread3 = new Thread(() -> {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		
		for(int i=0; i<5; i++){
			toolkit.beep();
			try{ Thread.sleep(500);}catch(Exception e){} // 0.5초간 일시 정지
		}
	});
}
