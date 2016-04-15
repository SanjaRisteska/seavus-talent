package com.seavus.motiondetector;
import java.io.IOException;

public class MotionDetectorApplication {

	public static void main(String[] args) throws IOException {
		CapturingDevice capturingDevice = new Camera();
		AlarmChanel alarmChanel = new SoundAlarm();
		MotionDetector motionDetector = new MotionDetector(alarmChanel, capturingDevice);

		motionDetector.run();

	}

}
