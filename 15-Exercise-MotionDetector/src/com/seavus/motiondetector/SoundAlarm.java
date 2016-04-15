package com.seavus.motiondetector;

public class SoundAlarm implements AlarmChanel {

	@Override
	public void alarm() {
		System.out.println("Alarm ringing!!!");
	}

}
