package com.acme.adapters;

import com.acme.heater.ACMEHeater;
import com.ventoelectrics.waterheater.VentoHeater;

public class VentoACMEHeaterAdapter implements ACMEHeater {

	private VentoHeater heater;

	public VentoACMEHeaterAdapter(VentoHeater heater) {
		this.heater = heater;
	}

	@Override
	public void enable() {
		heater.enable();
	}

	@Override
	public void disable() {
		heater.disable();
	}

}
