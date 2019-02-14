package thread.sync;

public class User2 extends Thread{
	private Calculator calculator;
	
	@Override
	public void run() {
		calculator.setmemory(50);
	}

	public void setCalculator(Calculator calculator) {
		this.setName("User2");
		this.calculator = calculator;
	}
	
}
