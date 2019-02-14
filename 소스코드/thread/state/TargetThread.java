package thread.state;

public class TargetThread extends Thread{
	
	@Override
	public void run() {
		
		for(long i=0; i<2000000000; i++){
			// RUNNABLE 상태 유지
		}
		
		try{
			Thread.sleep(1500); // 1.5 초간 TIMED_WAITING 상태 유지
		}catch(Exception e){}
		
		for(long i=0; i<2000000000; i++){
			// RUNNABEL 상태 유지
		}
		
	}
}
