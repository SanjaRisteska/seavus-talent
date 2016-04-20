package com.acme.thermoregulator;

public interface ACMEThermoregulator {
	public void enablePower();

	public void disablePower();

	public void setTemperature(Integer temperature);
}
