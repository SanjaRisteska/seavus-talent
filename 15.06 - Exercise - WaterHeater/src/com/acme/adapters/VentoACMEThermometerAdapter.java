package com.acme.adapters;

import com.acme.thermometer.ACMEThermometer;
import com.ventoelectrics.waterheater.VentoThermometer;

public class VentoACMEThermometerAdapter implements ACMEThermometer {
	private VentoThermometer thermometer;

	public VentoACMEThermometerAdapter(VentoThermometer thermometer) {
		this.thermometer = thermometer;
	}

	@Override
	public Integer getTemperature() {
		return thermometer.getTemperature();
	}

}
