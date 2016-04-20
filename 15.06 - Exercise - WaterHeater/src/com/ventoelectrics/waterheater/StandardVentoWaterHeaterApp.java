package com.ventoelectrics.waterheater;

import com.acme.adapters.VentoACMEThermoregulatorAdapter;

public class StandardVentoWaterHeaterApp {

	public static void main(String[] args) throws Exception {

		final VentoThermometer ventoThermometer = new VentoThermometer();
		final VentoHeater ventoHeater = new VentoHeater();
		final VentoPowerSwitch ventoPowerSwitch = new VentoPowerSwitch();

		final VentoThermoregulator ventoThermoregulator = new VentoACMEThermoregulatorAdapter(ventoHeater, ventoThermometer,false); // ACME standard thermoregulator instance. 

		ventoPowerSwitch.controlPowerFor(ventoThermoregulator);
		ventoPowerSwitch.controlPowerFor(ventoHeater);
		ventoPowerSwitch.controlPowerFor(ventoThermometer);
		

		VentoWaterHeaterApp.run(ventoThermoregulator, ventoPowerSwitch);
	}
}
