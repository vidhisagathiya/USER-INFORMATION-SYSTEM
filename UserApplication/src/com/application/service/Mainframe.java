package com.application.service;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.application.view.GetUserByCompany;
import com.application.view.GetUserByEmail;
import com.application.view.GetUserByLocation;


public class Mainframe extends JFrame {

	public static void main(String[] args) {
		new Mainframe().setVisible(true);
	}

	public Mainframe() {
		super("USER APPLICATION SYSTEM");
		initialize();
	}

	private void initialize() {

		setForeground(Color.CYAN);
		setLayout(null);

		JLabel NewLabel = new JLabel("");
		NewLabel.setIcon(new ImageIcon(getClass().getResource("/logo.jpg")));
		NewLabel.setBounds(0, 0, 1920, 990);
		add(NewLabel);

		JLabel UserAppSystem = new JLabel("Welcome To User Details Application System");
		UserAppSystem.setForeground(Color.WHITE);
		UserAppSystem.setFont(new Font("Impact", Font.BOLD, 45));
		UserAppSystem.setBounds(300, 60, 1000, 55);
		NewLabel.add(UserAppSystem);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu MainMenu = new JMenu("SEARCH USER");
		MainMenu.setForeground(Color.BLUE);
		menuBar.add(MainMenu);

		JMenuItem AllUserDetails = new JMenuItem("ALL USER DETAILS");
		MainMenu.add(AllUserDetails);

		JMenuItem UserDetailByLocation = new JMenuItem("BY LOCATION");
		MainMenu.add(UserDetailByLocation);

		JMenuItem UserDetailByMail = new JMenuItem("BY EMAIL");
		MainMenu.add(UserDetailByMail);

		JMenuItem UserDetailByCompany = new JMenuItem("BY COMPANY");
		MainMenu.add(UserDetailByCompany);

		AllUserDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				new GetAllUserDetails();
			}
		});

		UserDetailByLocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				new GetUserByLocation();
			}
		});

		UserDetailByCompany.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				new GetUserByCompany();
			}
		});

		UserDetailByMail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				new GetUserByEmail();
			}
		});

		setSize(1950, 1090);
		setVisible(true);

	}

}
