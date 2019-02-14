package thread.example1;

import java.awt.Toolkit;

public class BeepTask implements Runnable{

	// 스레드 실행 내용
	@Override
	public void run() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		
		for(int i=0; i<5; i++){
			toolkit.beep();
			try{ Thread.sleep(500);}catch(Exception e){} // 0.5초간 일시 정지
		}
	}

}
