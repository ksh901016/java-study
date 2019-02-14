package thread.example2;

import java.awt.Toolkit;

public class BeepPrintExample3 {
	public static void main(String[] args){
		Thread thread = new BeepThread();
		thread.start();
		
		for(int i=0; i<5; i++){
			System.out.println("띵");
			try{ Thread.sleep(500);}catch(Exception e){}
		}
		
		// 익명 객체를 이용하는 방법
		Thread thread2 = new Thread(){
			@Override
			public void run(){
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				
				for(int i=0; i<5; i++){
					toolkit.beep();
					try{ Thread.sleep(500);}catch(Exception e){} // 0.5초간 일시 정지
				}
			}
		};
	}
}
