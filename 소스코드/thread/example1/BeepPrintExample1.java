package thread.example1;

import java.awt.Toolkit;

public class BeepPrintExample1 {
	public static void main(String[] args){
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		
		for(int i=0; i<5; i++){
			toolkit.beep();
			try{ Thread.sleep(500);}catch(Exception e){} // 0.5초간 일시 정지
		}
		
		for(int i=0; i<5; i++){
			System.out.println("띵");
			try{ Thread.sleep(500);}catch(Exception e){} // 0.5초간 일시정지
		}
		
		// 메인 쓰레드에서 2가지 작업을 하므로, 비프음이 끝나면 띵을 프린트해준다.
	}
}
