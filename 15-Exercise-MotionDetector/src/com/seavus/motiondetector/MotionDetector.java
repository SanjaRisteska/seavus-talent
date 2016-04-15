package com.seavus.motiondetector;
import java.io.IOException;

public class MotionDetector {
	AlarmChanel alarmChanel;
	CapturingDevice capturingDevice;

	public MotionDetector(AlarmChanel alarmChanel, CapturingDevice capturingDevice) {
		this.alarmChanel = alarmChanel;
		this.capturingDevice = capturingDevice;
	}

	public void run() throws IOException {
		String img1 = capturingDevice.getImage();
		if (img1.trim().isEmpty()) {
			return;
		}
		String img2 = "";
		while (true) {
			img2 = capturingDevice.getImage();
			if (img2.trim().isEmpty()) {
				break;
			}
			detectMotion(img1, img2);
			
			img1=img2;
		}
	}

	public void detectMotion(String img1, String img2) {

		if (!(img1.equals(img2))) {
			alarmChanel.alarm();
		}

	}

}
