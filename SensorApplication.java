package sensor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.TitledBorder;

public class SensorApplication extends JFrame {
	
	public SensorApplication() {
		setTitle("Sensor Tracker");
		setLayout(new GridLayout(3,1));

		
		Sensor temAdapter = new TemperatureAdapter();
		String temStatus = temAdapter.status();
		double temValue = temAdapter.value();
		Color temMeterColor = temAdapter.meterColor();
		JPanel  temperaturePnl = new JPanel(new GridLayout(2,1));
		temperaturePnl.setBorder(new TitledBorder("Temperature"));
		JProgressBar temMeter = new JProgressBar(0,400);
		temMeter.setValue((int)temValue);
		temMeter.setForeground(temMeterColor);
		JLabel temperatureLabel = new JLabel();
		temperatureLabel.setText(temStatus +"  --->  "+ temValue);
		temperaturePnl.add(temMeter);
		temperaturePnl.add(temperatureLabel);
		add(temperaturePnl);
		
		Sensor preAdapter = new PressureAdapter();
		String preStatus = preAdapter.status();
		double preValue = preAdapter.value();
		Color preMeterColor = preAdapter.meterColor();
		JPanel pressurePnl = new JPanel(new GridLayout(2,1));
		pressurePnl.setBorder(new TitledBorder("Pressure"));
		JProgressBar preMeter = new JProgressBar(0,8);
		preMeter.setValue((int)preValue);
		preMeter.setForeground(preMeterColor);
		JLabel preLabel = new JLabel();
		preLabel.setText(preStatus +"  --->  "+ preValue);
		pressurePnl.add(preMeter);
		pressurePnl.add(preLabel);
		add(pressurePnl);
		
		Sensor radAdapter = new RadiationAdapter();
		String radStatus = radAdapter.status();
		double radValue = radAdapter.value();
		Color radMeterColor = radAdapter.meterColor();
		JPanel radPnl = new JPanel(new GridLayout(2,1));
		radPnl.setBorder(new TitledBorder("Radiation"));
		JProgressBar radMeter = new JProgressBar(0,5);
		radMeter.setValue((int)radValue);
		radMeter.setForeground(radMeterColor);
		JLabel radLabel = new JLabel();
		radLabel.setText(radStatus +"  --->  "+ radValue);
		radPnl.add(radMeter);
		radPnl.add(radLabel);
		add(radPnl);
		
		setPreferredSize(new Dimension(600,600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		pack();
	}

	public static void main(String[] args) {
		SensorApplication app = new SensorApplication();
	}

}
