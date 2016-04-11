
public class NumberPrinter {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		int endNumber = Integer.parseInt(args[0]);
		int interval = Integer.parseInt(args[1]);
		Task task = new Task(endNumber);
		Thread thread = new Thread(task);

		thread.start();

		thread.join(interval);
		System.out.println("Interupting the task...");
		thread.interrupt();

	}

	public static class Task implements Runnable {
		int startNumber = 1;
		int endNumber;

		public Task(int endNumber) {
			this.endNumber = endNumber;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while (startNumber < endNumber) {
				if (Thread.interrupted()) {
					System.out.println("I've been interrupted.");
					return;
				}
				System.out.println(startNumber);
				startNumber++;
			}

		}

	}

}
