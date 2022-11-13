package com.application.controller;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.application.service.JsonServiceImpl;
import com.application.view.*;


public class Mainframe extends JFrame {

	public static void main(String[] args) {

		JsonServiceImpl jsonObj = new JsonServiceImpl();
		jsonObj.JSONtoDatabase();
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
		menuBar.add(Box.createHorizontalGlue());

		JMenu MainMenu = new JMenu("SEARCH USER");
		MainMenu.setForeground(Color.BLUE);
		menuBar.add(MainMenu);

		JMenuItem AllUserDetails = new JMenuItem("ALL USER DETAILS");
		
		MainMenu.add(AllUserDetails);

		JMenuItem UserDetailByLocation = new JMenuItem("SEARCH BY LOCATION");
		MainMenu.add(UserDetailByLocation);

		JMenuItem UserDetailByMail = new JMenuItem("SEARCH BY EMAIL");
		MainMenu.add(UserDetailByMail);

		JMenuItem UserDetailByCompany = new JMenuItem("SEARCH BY COMPANY");
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
