import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Stopwatch {

	static boolean pause = false;
	static boolean stop = false;
	static int seconds = 1;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Counter task = new Counter();
		Thread thread = new Thread(task);

		thread.start();

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String command = in.readLine();
		while (true) {

			if (command.equalsIgnoreCase("pause")) {
				pause = true;

			} else if (command.equalsIgnoreCase("play")) {
				synchronized (task) {
					pause = false;
					task.notifyAll();

				}
			} else if (command.equalsIgnoreCase("stop")) {
				break;
			}
			command = in.readLine();
		}

		stop = true;

	}

	public static class Counter implements Runnable {

		@Override
		public void run() {
			while (true) {
				if (!pause && !stop) {
					System.out.println(seconds);
					seconds++;
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				else if (stop) {
					return;
				} else if (pause) {
					try {
						synchronized (this) {
							wait();

						}
					} catch (InterruptedException e) {
					}
				}

			}

		}

	}

}
