package com.acme.thermoregulator;

import com.ventoelectrics.waterheater.VentoHeater;
import com.ventoelectrics.waterheater.VentoThermometer;
import com.ventoelectrics.waterheater.VentoThermoregulator;


public class Thermoregulator implements VentoThermoregulator {

	 int maxTemperature;
	 int currentTemperature;
	 VentoHeater heater;
	 VentoThermometer thermometer;
	 boolean powerEnabled = false;
	

	public Thermoregulator(VentoHeater ventoHeater, VentoThermometer ventoThermometer) {
		this.heater = ventoHeater;
		this.thermometer = ventoThermometer;
	}


	public void enablePower() {
		powerEnabled = true;
		System.out.println("Enabled");
		Regulator regulator = new Regulator();
		Thread thread = new Thread(regulator);
		thread.start();
	}

	public void disablePower() {
		powerEnabled = false;
		System.out.println("Disabled");

	}

	public void setTemperature(Integer temperature) {
		// TODO Auto-generated method stub
		this.maxTemperature = temperature;
		System.out.println("Temperature set to " + maxTemperature);

	}

	void turnOnHeater() {
		heater.enable();
	}

	void turnOffHeater() {
		heater.disable();
	}

	public void waitToRead() throws InterruptedException {
		Thread.sleep(3000);
	}
	
	
	public class Regulator implements Runnable {

		@Override
		public void run() {
			while (powerEnabled) {
				

				currentTemperature = thermometer.getTemperature();
				System.out.println("Current temperature = " + currentTemperature);

				if (currentTemperature < maxTemperature) {
					turnOnHeater();
				} else if (currentTemperature > maxTemperature) {
					turnOffHeater();
				}
				
				try {
					waitToRead();
				} catch (InterruptedException e) {
				}

			}
		}
	
	
	}

}
