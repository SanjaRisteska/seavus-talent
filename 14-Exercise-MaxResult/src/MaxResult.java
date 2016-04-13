import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MaxResult {
	private static final int NUMBER_OF_CALCULATIONS = 10;

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		int maxResult = 0;
		final CountDownLatch latch = new CountDownLatch(NUMBER_OF_CALCULATIONS);
		final ExecutorService executorService = Executors.newCachedThreadPool();
		List<Future<Integer>> results = new ArrayList<Future<Integer>>();
		for (int i = 0; i < NUMBER_OF_CALCULATIONS; i++) {
			results.add(executorService.submit(new ComplexCalculation(latch)));
		}

		latch.await();

		try {
			for (Future<Integer> result : results) {
				Integer complexCalculationResult = result.get();
				if (maxResult < complexCalculationResult) {
					maxResult = complexCalculationResult;
				}
			}
			System.out.println("The max result is " + maxResult);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
