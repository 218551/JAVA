package projectPackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import net.miginfocom.swing.MigLayout;

public class UserInterface extends JFrame {
	JFrame frame = new JFrame("WeatherApp");
	JPanel panel = new JPanel();
	JTextArea showInfo = new JTextArea(10,50);
	JTextArea showDB = new JTextArea(10,50);
	JButton getInfo = new JButton("POBIERZ DANE");
	JButton clearInfo = new JButton("WYCZYSC DANE");
	JButton addLastInfoToDB = new JButton("AKTUALIZUJ DB");
	JButton unknown1 = new JButton("unknown1");
	JButton getDB = new JButton("POKAZ BAZE");
	JButton clearDB = new JButton("WYCZYSC BAZE");
	JButton unknown2 = new JButton("unknown2");
	JButton unknown3 = new JButton("unknown3");
	 
	public UserInterface() {
		panel.setLayout(new MigLayout());
		panel.add(getInfo,"grow");
		panel.add(clearInfo,"grow");
		panel.add(addLastInfoToDB,"grow");
		panel.add(unknown1,"wrap, grow");
		panel.add(getDB,"grow");
		panel.add(clearDB,"grow");
		panel.add(unknown2,"grow");
		panel.add(unknown3,"grow");
		panel.add(showInfo,"dock north");
		panel.add(showDB,"dock south");
		
		
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		frame.pack();
		frame.setVisible(true);	
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new UserInterface();
			}
		});
	}

}
