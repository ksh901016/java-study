package thread.sync;

public class Calculator {
	private int memory;
	
	public int getMemory(){
		return memory;
	}
	
	public void setmemory(int memory){
		// 동기화 블록 생성
		synchronized (this) {
			this.memory = memory;
			try{
				Thread.sleep(2000);
			}catch(InterruptedException e){}
			
			System.out.println(Thread.currentThread().getName() + ": " + this.memory);
		}
	}
}
