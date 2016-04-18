package com.acme.thermoregulator;

import com.ventoelectrics.waterheater.VentoHeater;
import com.ventoelectrics.waterheater.VentoThermometer;

public class EfficientThermoregulator extends Thermoregulator{

	public EfficientThermoregulator(VentoHeater ventoHeater, VentoThermometer ventoThermometer) {
		super(ventoHeater, ventoThermometer);
	}
	
	public void waitToRead() throws InterruptedException{
		Thread.sleep(1000);
	}

}
