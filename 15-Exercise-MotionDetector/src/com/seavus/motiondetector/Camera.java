package com.seavus.motiondetector;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Camera implements CapturingDevice {

	@Override
	public String getImage() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String img = null;
		System.out.println("Insert image.");
		img = in.readLine();

	

		
		return img;
	}

}
