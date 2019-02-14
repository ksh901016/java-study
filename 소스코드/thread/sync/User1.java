package thread.sync;

public class User1 extends Thread{
	private Calculator calculator;
	
	@Override
	public void run() {
		calculator.setmemory(100);
	}

	public void setCalculator(Calculator calculator) {
		this.setName("User1");
		this.calculator = calculator;
	}
	
}
