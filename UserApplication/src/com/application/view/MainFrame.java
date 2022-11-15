package com.application.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainFrame extends JFrame {

	public static void main(String[] args) {

		new MainFrame();
	}

	public MainFrame() {
		super("USER DETAILS APPLICATION SYSTEM");
		setForeground(Color.CYAN);
		setLayout(null);

		JLabel NewLabel = new JLabel("");
		NewLabel.setIcon(new ImageIcon(getClass().getResource("/logo.png")));
		NewLabel.setBounds(0, 0, 1920, 990);
		add(NewLabel);

		JLabel UserAppSystem = new JLabel("Welcome To User Details Application....!!");
		UserAppSystem.setForeground(Color.black);
		UserAppSystem.setFont(new Font("Tahoma", Font.BOLD, 45));
		UserAppSystem.setBounds(300, 60, 1000, 55);
		NewLabel.add(UserAppSystem);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.add(Box.createHorizontalGlue());

		JMenu Menu1 = new JMenu("SEARCH USER");
		Menu1.setForeground(Color.BLUE);
		menuBar.add(Menu1);

		JMenu Menu2 = new JMenu("EDIT USER");
		Menu2.setForeground(Color.BLUE);
		menuBar.add(Menu2);

		JMenuItem AddUser = new JMenuItem("ADD USER");
		Menu2.add(AddUser);

		JMenuItem DeleteUser = new JMenuItem("DELETE USER");
		Menu2.add(DeleteUser);

		JMenuItem AllUserDetails = new JMenuItem("ALL USER DETAILS");
		Menu1.add(AllUserDetails);

		JMenuItem UserDetailByLocation = new JMenuItem("SEARCH BY LOCATION");
		Menu1.add(UserDetailByLocation);

		JMenuItem UserDetailByMail = new JMenuItem("SEARCH BY EMAIL");
		Menu1.add(UserDetailByMail);

		JMenuItem UserDetailByCompany = new JMenuItem("SEARCH BY COMPANY");
		Menu1.add(UserDetailByCompany);

		AllUserDetails.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				new GetAllUserDetails();
			}
		});

		UserDetailByLocation.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				new GetUserByLocation();
			}
		});

		UserDetailByCompany.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				new GetUserByCompany();
			}
		});

		UserDetailByMail.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				new GetUserByEmail();
			}
		});

		AddUser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				new AddUser();
			}
		});

		DeleteUser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				new DeleteUser();
			}
		});
		setSize(1950, 1090);
		setVisible(true);
	}
}
