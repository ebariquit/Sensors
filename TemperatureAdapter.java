package sensor;

import java.awt.Color;

public class TemperatureAdapter implements Sensor {

	private TemperatureSensor temSensor;
	
	public TemperatureAdapter() {
		temSensor = new TemperatureSensor();
	}
	
	public String status() {
		return temSensor.getTempReport();
	}
	
	public double value() {
		return temSensor.senseTemperature();
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
