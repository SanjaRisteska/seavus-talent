package com.acme.thermoregulator;

import com.acme.heater.ACMEHeater;
import com.acme.thermometer.ACMEThermometer;

public class EfficientThermoregulator extends Thermoregulator{

	public EfficientThermoregulator(ACMEHeater heater, ACMEThermometer thermometer) {
		super(heater, thermometer);
	}
	
	public void waitToRead() throws InterruptedException{
		Thread.sleep(1000);
	}

}
