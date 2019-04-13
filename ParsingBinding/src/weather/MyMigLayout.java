package weather;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;


import net.miginfocom.swing.MigLayout;

public class MyMigLayout extends JFrame {
	JFrame frame = new JFrame("WeatherInfo");
	JPanel panel = new JPanel();
	
	WeatherData newData = new WeatherData();
	
	JLabel cityName = new JLabel("Nazwa miasta: ");
	JTextArea newCityName = new JTextArea(1,20);
	JLabel country= new JLabel("Panstwo: ");
	JTextArea newCountry = new JTextArea(1,20);
	JLabel tempValue= new JLabel("Temperatura: ");
	JTextArea newTempValue = new JTextArea(1,20);
	JLabel windSpeed= new JLabel("Predkosc wiatru: ");
	JTextArea newWindSpeed = new JTextArea(1,20);
	JLabel time= new JLabel("Czas: ");
	JTextArea newTime = new JTextArea(1,20);
	JButton getData = new JButton("Pobierz");
	
	public MyMigLayout() {
		parsingBinding newOne = new parsingBinding(); 
		getData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				newOne.getWeatherInformation();
			}
		});
		
		panel.setLayout(new MigLayout());
		panel.add(cityName);
		panel.add(newCityName,"wrap,pushx,growx");
		panel.add(country);
		panel.add(newCountry,"wrap,pushx,growx");
		panel.add(tempValue);
		panel.add(newTempValue,"wrap,pushx,growx");
		panel.add(windSpeed);
		panel.add(newWindSpeed,"wrap,pushx,growx");
		panel.add(time);
		panel.add(newTime,"wrap,pushx,growx");
		panel.add(getData);
				
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		frame.pack();
		frame.setVisible(true);
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
		
			@Override
			public void run() {
				new MyMigLayout();
			}
		});
	}
}
