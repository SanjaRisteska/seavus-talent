package com.acme.thermoregulator;

import com.acme.heater.ACMEHeater;
import com.acme.thermometer.ACMEThermometer;


public class Thermoregulator implements ACMEThermoregulator{

	 int regulatorTemperature;
	 int currentTemperature;
	 ACMEHeater heater;
	 ACMEThermometer thermometer;
	 boolean powerEnabled = false;
	

	public Thermoregulator(ACMEHeater ventoHeater, ACMEThermometer ventoThermometer) {
		this.heater = ventoHeater;
		this.thermometer = ventoThermometer;
	}


	public void enablePower() {
		powerEnabled = true;
		System.out.println("Thermoregulator - Enabled");
		Regulator regulator = new Regulator();
		Thread thread = new Thread(regulator);
		thread.start();
	}

	public void disablePower() {
		powerEnabled = false;
		System.out.println("Thermoregulator - Disabled");

	}

	public void setTemperature(Integer temperature) {
		this.regulatorTemperature = temperature;
		System.out.println("Temperature set to " + regulatorTemperature);

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

				if (currentTemperature < regulatorTemperature) {
					turnOnHeater();
				} else if (currentTemperature > regulatorTemperature) {
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
