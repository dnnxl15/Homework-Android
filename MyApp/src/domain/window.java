package domain;

import java.awt.EventQueue;

import javax.swing.JFrame;

import Consult.EventConsult;
import File.FileReader;

public class window {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window window = new window();
					window.frame.setVisible(true);
					Day day = new Day();
					FileReader file = new FileReader();
					EventConsult filter = new EventConsult();
					UserAdministrator user = new UserAdministrator();
					//user.addUser("Esteban", "Coto", "ABC", "Contrasena");
					//user.addUser("Juan", "Blanco", "abc", "password");
					//filter.eventByName("Cata");
					filter.eventByLocation("San Jose");
					//file.readEvent();
					//day.addEvent("Hola", "San Jose", "01/01/2018", "02/02/2018");
					//day.addEvent("Cata", "Alajuela", "01/05/2018", "02/06/2018");
					//day.addEvent("Campos", "Heredia", "01/03/2018", "02/04/2018");
					//day.addEvent("Monte", "San Jose", "01/04/2018", "02/05/2018");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
