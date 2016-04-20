package com.acme.adapters;

import com.acme.thermoregulator.EfficientThermoregulator;
import com.acme.thermoregulator.Thermoregulator;
import com.ventoelectrics.waterheater.VentoHeater;
import com.ventoelectrics.waterheater.VentoThermometer;
import com.ventoelectrics.waterheater.VentoThermoregulator;

public class VentoACMEThermoregulatorAdapter implements VentoThermoregulator {

	private Thermoregulator thermoregulator;

	public VentoACMEThermoregulatorAdapter(VentoHeater heater, VentoThermometer thermometer, boolean efficient) {
		if (efficient) {
			this.thermoregulator = new EfficientThermoregulator(new VentoACMEHeaterAdapter(heater),
					new VentoACMEThermometerAdapter(thermometer));
		} else {
			this.thermoregulator = new Thermoregulator(new VentoACMEHeaterAdapter(heater),
					new VentoACMEThermometerAdapter(thermometer));
		}
	}

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
