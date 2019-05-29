package sensor;

import java.awt.Color;

public interface Sensor {
	
	public String status();
	public double value();
	public Color meterColor();
	
}
