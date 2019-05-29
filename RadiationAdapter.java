package sensor;

import java.awt.Color;

public class RadiationAdapter implements Sensor{
	
	private RadiationSensor radSensor;
	
	public RadiationAdapter() {
		radSensor = new RadiationSensor();
	}
	
	public String status() {
		return radSensor.getStatusInfo();
	}
	
	public double value() {
		return radSensor.getRadiationValue();
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
