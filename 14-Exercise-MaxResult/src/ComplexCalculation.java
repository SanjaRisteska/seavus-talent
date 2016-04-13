import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

public class ComplexCalculation implements Callable<Integer> {

	private CountDownLatch latch;

	public ComplexCalculation(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public Integer call() throws Exception {
		System.out.println("Complex calculation started...");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
		int result = new Random().nextInt(10 + 1);
		System.out.println("Complex calculation completed. The result is " + result);
		latch.countDown();
		return result;
	}

}
