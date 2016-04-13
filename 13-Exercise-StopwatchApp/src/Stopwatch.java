
public class Stopwatch {
	private int seconds;
	Counter counter;
	Thread thread;
	static boolean pause = false;
	static boolean play = false;
	static boolean stop = true;

	public Stopwatch() {
		seconds = 1;

	}

	public void play() {
	if(stop){
		stop=false;
		seconds = 1;
		counter = new Counter(seconds);
		thread = new Thread(counter);
		thread.start();
	}

	}

	public void resume() {
		if (pause) {
			synchronized (counter) {
				pause = false;
				counter.notifyAll();

			}
		}
	}

	public void stop() {
		stop = true;
		thread.interrupt();
	}

	public void pause() {
		pause = true;
	}

	public static class Counter implements Runnable {

		private int seconds;

		public Counter(int seconds) {
			this.seconds = seconds;
		}

		@Override
		public void run() {
			while (true) {

				if (Thread.interrupted()) {
					return;
				}
				if (!pause) {
					System.out.println(seconds);
					seconds++;
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						return;
					}
				}

				else if (pause) {
					try {
						synchronized (this) {
							wait();

						}
					} catch (InterruptedException e) {
						return;
					}
				}

			}

		}

	}

}
