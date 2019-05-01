package projectPackage;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.Binding;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.beansbinding.Converter;
import org.jdesktop.beansbinding.Property;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import net.miginfocom.swing.MigLayout;


@SuppressWarnings("serial")
public class UserInterface extends JFrame {
	JFrame frame = new JFrame("WeatherApp");
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();	
	
	JTextField typeCity = new JTextField();
	JTextField notifications = new JTextField();
	JButton search = new JButton("SZUKAJ!");
	JButton warsaw = new JButton("WARSZAWA");
	JButton london = new JButton("LONDYN");
	JButton paris = new JButton("PARYZ");
	JButton berlin = new JButton("BERLIN");
	JButton moscow = new JButton("MOSKWA");
	JButton madrid = new JButton("MADRYT");
	JButton rome = new JButton("RZYM");
	
	JButton addAll = new JButton("DODAJ WSZYSTKO");
	JButton addLast = new JButton("DODAJ OSTATNI");
	JButton clearInfo = new JButton("WYCZYSC TYMCZASOWE");
	JButton clearLast = new JButton("USUN OSTATNI");
	
	JButton getDB = new JButton("ODSWIEZ BAZE");
	JButton clearDB = new JButton("WYCZYSC BAZE");
	JCheckBox checkAuto = new JCheckBox("AUTO INSERT");
	
	static JTable showInfo = new JTable();
	static JTable showDB = new JTable();
	static DataContener newData= new DataContener();
	private WeatherInfoList weatherInfoList = new WeatherInfoList();
	private WeatherDbList weatherDbList = new WeatherDbList();
	
	public UserInterface() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
			}
		});
		 
		panel1.setLayout(new MigLayout());
		panel1.add(typeCity,"grow, span 6");
		panel1.add(search,"wrap, grow");
		panel1.add(warsaw,"grow");
		panel1.add(london,"grow");
		panel1.add(paris,"grow");
		panel1.add(berlin,"grow");
		panel1.add(moscow,"grow");
		panel1.add(madrid,"grow");
		panel1.add(rome,"grow");
		
		panel2.setLayout(new MigLayout());
		panel2.add(addAll,"grow");
		panel2.add(addLast,"grow");
		panel2.add(clearInfo,"grow");
		panel2.add(clearLast,"grow");
		
		panel3.setLayout(new MigLayout());
		panel3.add(getDB,"grow");
		panel3.add(clearDB,"grow");
		panel3.add(checkAuto,"grow");
		panel3.add(notifications,"grow, width 250");
		
		
		JScrollPane scrollPanel1 = new JScrollPane(showInfo);
		scrollPanel1.setPreferredSize(new Dimension(0, 150));
		JScrollPane scrollPanel2 = new JScrollPane(showDB);
		scrollPanel2.setPreferredSize(new Dimension(0, 150));
		
		frame.setLayout(new MigLayout());
		frame.add(panel1,"grow, wrap");
		frame.add(scrollPanel1,"grow, wrap");
		frame.add(panel2,"grow, wrap");
		frame.add(scrollPanel2,"grow,wrap");
		frame.add(panel3,"grow");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		frame.pack();
		frame.setVisible(true);	
		
		search.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					String name = typeCity.getText();
					DataContener entry = ParsingXml.getWeatherInformation(name);
					if(entry.cityName!="undefined") {
					weatherInfoList.addData(entry);
					typeCity.setText("");
					if(checkAuto.isSelected()) {
					DatabaseConnection.insertEntry(entry);
					weatherDbList.addData(entry);
					}
					}else {
						notifications.setText("Nie znaleziono miasta");
					}				
			}
		});
		
	
		
		
		warsaw.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					DataContener newOne = ParsingXml.getWeatherInformation("Warsaw");
					weatherInfoList.addData(newOne);
					if(checkAuto.isSelected()) {
						DatabaseConnection.insertEntry(newOne);
						weatherDbList.addData(newOne);
						}
				} catch(Exception ex){
					typeCity.setText("Some error occured");
				}
				
			}
		});
		
		london.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					DataContener newOne = ParsingXml.getWeatherInformation("London");
					weatherInfoList.addData(newOne);
					if(checkAuto.isSelected()) {
						DatabaseConnection.insertEntry(newOne);
						weatherDbList.addData(newOne);
						}
				} catch(Exception ex){
					typeCity.setText("Some error occured");
				}
				
			}
		});
		
		paris.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					DataContener newOne = ParsingXml.getWeatherInformation("Paris");
					weatherInfoList.addData(newOne);
					if(checkAuto.isSelected()) {
						DatabaseConnection.insertEntry(newOne);
						weatherDbList.addData(newOne);
						}
				} catch(Exception ex){
					typeCity.setText("Some error occured");
				}
				
			}
		});
		berlin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					DataContener newOne = ParsingXml.getWeatherInformation("Berlin");
					weatherInfoList.addData(newOne);
					if(checkAuto.isSelected()) {
						DatabaseConnection.insertEntry(newOne);
						weatherDbList.addData(newOne);
						}
				} catch(Exception ex){
					typeCity.setText("Some error occured");
				}
				
			}
		});
		moscow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					DataContener newOne = ParsingXml.getWeatherInformation("Moscow");
					weatherInfoList.addData(newOne);
					if(checkAuto.isSelected()) {
						DatabaseConnection.insertEntry(newOne);
						weatherDbList.addData(newOne);
						}
				} catch(Exception ex){
					typeCity.setText("Some error occured");
				}
				
			}
		});
		
		madrid.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					DataContener newOne = ParsingXml.getWeatherInformation("Madrid");
					weatherInfoList.addData(newOne);
					if(checkAuto.isSelected()) {
						DatabaseConnection.insertEntry(newOne);
						weatherDbList.addData(newOne);
						}
				} catch(Exception ex){
					typeCity.setText("Some error occured");
				}
				
			}
		});
		
		rome.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					DataContener newOne = ParsingXml.getWeatherInformation("Rome");
					weatherInfoList.addData(newOne);
					if(checkAuto.isSelected()) {
						DatabaseConnection.insertEntry(newOne);
						weatherDbList.addData(newOne);
						}
				} catch(Exception ex){
					typeCity.setText("Some error occured");
				}
				
			}
		});
		
		addAll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					List<DataContener> tempList = weatherInfoList.getContener();
					if(tempList.size()>0) {
					for (DataContener temp : tempList) {
						weatherDbList.addData(temp);
						DatabaseConnection.insertEntry(temp);
					}
					weatherInfoList.eraseData();
					}else {
						notifications.setText("Brak elementu do dodania");
					}
				} catch(Exception ex){
					typeCity.setText("Nie mo¿na dodaæ!");
				}
				
			}
		});
		
		addLast.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					DataContener newOne = weatherInfoList.getLastElement();
					DatabaseConnection.insertEntry(newOne);
					weatherDbList.addData(newOne);
					weatherInfoList.clearLastElement();
				} catch(Exception ex){
					notifications.setText("Brak elementu do dodania");
				}
				
			}
		});
		
		clearInfo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(weatherInfoList.contener.size()>0)
				weatherInfoList.eraseData();
			}
		});
		
		clearLast.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(weatherInfoList.getContener().size()>0)
				weatherInfoList.clearLastElement();
				else
					notifications.setText("Brak elementu do usuniecia!");
			}
		});
		
		getDB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				List<DataContener> contener = DatabaseConnection.selectWeatherEntries();
				if(weatherDbList.contener.size()>0)
				weatherDbList.eraseData();
				for (DataContener temp : contener) {
					weatherDbList.addData(temp);
				}
			}
		});
		
		clearDB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(weatherDbList.contener.size()>0) {
				weatherDbList.eraseData();
				DatabaseConnection.deleteAllDbData();
				}else
					notifications.setText("Baza danych ju¿ jest pusta!");
			}
		});
		
		
		initDataBindings();
		DatabaseConnection.dbConnect();
		weatherTimerTask();
		
	}

	public void weatherTimerTask() {
		Timer timer=new Timer();
		TimerTask timerTask =new TimerTask() {
			public void run() {
					List<DataContener> tempList = weatherInfoList.getContener();
					for (DataContener temp : tempList) {
						weatherDbList.addData(temp);
						DatabaseConnection.insertEntry(temp);
					}
					weatherInfoList.eraseData();				
			}
		};
		timer.scheduleAtFixedRate(timerTask, 60000,60000);
	}
	

	
	protected BindingGroup initDataBindings() {
		BindingGroup bindingGroup = new BindingGroup();
		
		BeanProperty<WeatherInfoList, List<DataContener>> weatherDatabaseProperty = BeanProperty.create("contener");
		JTableBinding<DataContener, WeatherInfoList, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, weatherInfoList, weatherDatabaseProperty, showInfo);

		BeanProperty<DataContener, String> dataContenerProperty1 = BeanProperty.create("city");
		JTableBinding<DataContener, WeatherInfoList, JTable>.ColumnBinding 
		columnBinding = jTableBinding.addColumnBinding(dataContenerProperty1);
		columnBinding.setColumnName("City");
		
		BeanProperty<DataContener, String> dataContenerProperty4 = BeanProperty.create("country");
		jTableBinding.addColumnBinding(dataContenerProperty4).setColumnName("Country");
		
		BeanProperty<DataContener, String> dataContenerProperty2 = BeanProperty.create("temp");
		jTableBinding.addColumnBinding(dataContenerProperty2).setColumnName("Temperature");
		
		BeanProperty<DataContener, String> dataContenerProperty3 = BeanProperty.create("wind");
		jTableBinding.addColumnBinding(dataContenerProperty3).setColumnName("Wind speed");
		
		BeanProperty<DataContener, String> dataContenerProperty = BeanProperty.create("time");
		jTableBinding.addColumnBinding(dataContenerProperty).setColumnName("Time");
		
		bindingGroup.addBinding(jTableBinding);
		jTableBinding.bind();
		
		 
		
		BeanProperty<WeatherDbList, List<DataContener>> weatherDatabaseProperty2 = BeanProperty.create("contener");
		JTableBinding<DataContener, WeatherDbList, JTable> jTableBinding2 = SwingBindings.createJTableBinding(UpdateStrategy.READ, weatherDbList, weatherDatabaseProperty2, showDB);

		BeanProperty<DataContener, String> dataContenerProperty7 = BeanProperty.create("city");
		JTableBinding<DataContener, WeatherDbList, JTable>.ColumnBinding 
		columnBinding2 = jTableBinding2.addColumnBinding(dataContenerProperty7);
		columnBinding2.setColumnName("City");
		
		BeanProperty<DataContener, String> dataContenerProperty9 = BeanProperty.create("country");
		jTableBinding2.addColumnBinding(dataContenerProperty9).setColumnName("Country");		
		
		BeanProperty<DataContener, String> dataContenerProperty8 = BeanProperty.create("temp");
		jTableBinding2.addColumnBinding(dataContenerProperty8).setColumnName("Temperature");
		
		BeanProperty<DataContener, String> dataContenerProperty10 = BeanProperty.create("wind");
		jTableBinding2.addColumnBinding(dataContenerProperty10).setColumnName("Wind speed");
		
		BeanProperty<DataContener, String> dataContenerProperty6 = BeanProperty.create("time");
		jTableBinding2.addColumnBinding(dataContenerProperty6).setColumnName("Time");
		
		bindingGroup.addBinding(jTableBinding2);
		jTableBinding2.bind();
		
		return bindingGroup;
	}
	
	
}
