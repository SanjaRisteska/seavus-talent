import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StopwatchApp {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Stopwatch sw = new Stopwatch();

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String command = in.readLine();
		while (true) {

			if (command.equalsIgnoreCase("pause")) {
				sw.pause();

			} else if (command.equalsIgnoreCase("play")) {
				sw.play();
			} else if (command.equalsIgnoreCase("resume")) {
				sw.resume();
			} else if (command.equalsIgnoreCase("stop")) {
				sw.stop();
			}

			else if (command.equalsIgnoreCase("exit")) {
				System.exit(0);
			}
			command = in.readLine();
		}
	}
}
