
import java.io.IOException;

import com.seavus.motiondetector.AlarmChanel;
import com.seavus.motiondetector.CapturingDevice;
import com.seavus.motiondetector.MotionDetector;
import com.seavus.motiondetector.SoundAlarm;
import com.sedc.camera.Camera;

public class MotionDetectorApplication {

	public static void main(String[] args) throws IOException {
		CapturingDevice capturingDevice = new Camera();
		AlarmChanel alarmChanel = new SoundAlarm();
		MotionDetector motionDetector = new MotionDetector(alarmChanel, capturingDevice);

		motionDetector.run();

	}

}
