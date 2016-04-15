package com.seavus.motiondetector;
import java.io.IOException;

public interface CapturingDevice {
	String getImage() throws IOException;

}
