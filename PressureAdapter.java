package sensor;

import java.awt.Color;

public class PressureAdapter implements Sensor {

	private PressureSensor preSensor;
	
	public PressureAdapter() {
		preSensor = new PressureSensor();
	}
	
	public String status() {
		return preSensor.getReport();
	}
	
	public double value() {
		return preSensor.readValue();
	}
	
	public Color meterColor() {
		if(status().equals("OK")) {
			return Color.GREEN;
		}
		if(status().equals("CRITICAL")) {
			return Color.YELLOW;
		}
		if(status().equals("DANGER")) {
			return Color.RED;
		} else {
			return Color.WHITE;
		}
	}
	
}
