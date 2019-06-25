package sensor;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class SensorApplication extends JFrame {
	 
	Sensor temAdapter = new TemperatureAdapter();
	Sensor preAdapter = new PressureAdapter();
	Sensor radAdapter = new RadiationAdapter();		
	
	// Constructor
	public SensorApplication() {
		// Setup GUI
		setTitle("Sensor Tracker");
		setLayout(new GridLayout(3,1));
		// Add sensors using necessary parameters
		addSensor(temAdapter, 550);
		addSensor(preAdapter, 15);
		addSensor(radAdapter, 10);		
		// Finalize GUI
		setPreferredSize(new Dimension(300,300));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		pack();
	}
	
	public void addSensor(Sensor sensor, int progressBarMax) {
		// Initialize GUI components
		JPanel panel = new JPanel(new GridLayout(2,1));
		panel.setBorder(new TitledBorder(sensor.type()));
		JProgressBar meter = new JProgressBar(0, progressBarMax);
		JLabel label = new JLabel();
		// Extract color & value
		double value = sensor.value();
		Color color = sensor.meterColor();
		// Set displays
		label.setText(sensor.status()+" -----> "+value);
		meter.setValue((int) value);
		meter.setForeground(color);
		// Add components
		panel.add(meter);
		panel.add(label);
		add(panel);
	}
	

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		SensorApplication app = new SensorApplication();
	}

}
