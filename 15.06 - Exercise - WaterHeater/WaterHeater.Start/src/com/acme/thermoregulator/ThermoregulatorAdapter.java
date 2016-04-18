package com.acme.thermoregulator;

import com.ventoelectrics.waterheater.VentoHeater;
import com.ventoelectrics.waterheater.VentoThermometer;
import com.ventoelectrics.waterheater.VentoThermoregulator;

public class ThermoregulatorAdapter implements VentoThermoregulator {
	Thermoregulator thermoregulator;
	VentoHeater ventoHeater; 
	VentoThermometer ventoThermometer;

	@Override
	public void enablePower() {
		thermoregulator.enablePower();
	}

	@Override
	public void disablePower() {
		thermoregulator.disablePower();
	}

	@Override
	public void setTemperature(Integer temperature) {
		thermoregulator.setTemperature(temperature);
	}

}
