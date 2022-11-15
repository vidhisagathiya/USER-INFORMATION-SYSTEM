package com.application.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.application.dal.CompanyDataMapperImpl;
import com.application.dal.UserDataMapperImpl;
import com.application.model.User;

public class AddUser extends JFrame {

	JTextField textField, textField_1, textField_2, textField_3, textField_4, textField_5, textField_6, textField_7;

	public AddUser() {
		getContentPane().setForeground(Color.BLUE);
		getContentPane().setBackground(Color.WHITE);
		setTitle("ADD NEW USER");

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(1000, 768);
		setLayout(null);
		setVisible(true);

		JLabel Name = new JLabel("FULL NAME");
		Name.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Name.setBounds(60, 80, 250, 27);
		add(Name);

		textField = new JTextField();
		textField.setBounds(200, 80, 200, 40);
		add(textField);

		JButton btnShow = new JButton("SUBMIT");
		btnShow.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnShow.setBounds(200, 450, 150, 40);
		add(btnShow);

		JLabel UserName = new JLabel("USERNAME");
		UserName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		UserName.setBounds(60, 130, 250, 27);
		add(UserName);

		textField_1 = new JTextField();
		textField_1.setBounds(200, 130, 200, 40);
		add(textField_1);

		JLabel Email = new JLabel("EMAIL");
		Email.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Email.setBounds(60, 180, 250, 27);
		add(Email);

		textField_2 = new JTextField();
		textField_2.setBounds(200, 180, 200, 40);
		add(textField_2);

		JLabel Phone = new JLabel("PHONE NUMBER");
		Phone.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Phone.setBounds(60, 230, 250, 27);
		add(Phone);

		textField_3 = new JTextField();
		textField_3.setBounds(200, 230, 200, 40);
		add(textField_3);

		JLabel Website = new JLabel("WEBSITE");
		Website.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Website.setBounds(60, 280, 250, 27);
		add(Website);

		textField_4 = new JTextField();
		textField_4.setBounds(200, 280, 200, 40);
		add(textField_4);

		CompanyDataMapperImpl companyDataMapperImpl = new CompanyDataMapperImpl();
		ResultSet rs = companyDataMapperImpl.getAllData();
		int x = 0;
		String[] CompanyList = new String[20];
		try {
			while (rs.next()) {
				CompanyList[x++] = rs.getString("Companyname");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		JLabel CompanyName = new JLabel("Company Name");
		CompanyName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		CompanyName.setBounds(60, 330, 250, 27);
		add(CompanyName);

		JComboBox comboBox1 = new JComboBox(CompanyList);
		comboBox1.setBounds(200, 330, 200, 40);
		add(comboBox1);

		setVisible(true);

		JLabel AddUsers = new JLabel("FILL USER DETAILS HERE ");
		AddUsers.setForeground(Color.BLUE);
		AddUsers.setFont(new Font("Tahoma", Font.PLAIN, 23));
		AddUsers.setBounds(100, 24, 442, 35);
		add(AddUsers);

		UserDataMapperImpl userDataMapperImpl = new UserDataMapperImpl();
		ResultSet result = null;
		try {
			result = userDataMapperImpl.getAddressZipcode();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		int y = 0;
		String[] AddressList = new String[20];
		try {
			while (result.next()) {
				AddressList[y++] = result.getString("Zipcode");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		JLabel ZipCode = new JLabel("ZIP CODE");
		ZipCode.setFont(new Font("Tahoma", Font.PLAIN, 17));
		ZipCode.setBounds(60, 380, 250, 27);
		add(ZipCode);

		JComboBox comboBox2 = new JComboBox(AddressList);
		comboBox2.setBounds(200, 380, 200, 40);
		add(comboBox2);

		btnShow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				String Name = textField.getText();
				String UserName = textField_1.getText();
				String Email = textField_2.getText();
				String Phone = textField_3.getText();
				String Website = textField_4.getText();
				String CompanyName = (String) comboBox1.getSelectedItem();
				String ZipCode = (String) comboBox2.getSelectedItem();

				User user = new User.UserBuilder().name(Name).username(UserName).email(Email).phone(Phone)
						.website(Website).build();

				UserDataMapperImpl userDataMapperImpl = new UserDataMapperImpl();
				try {
					userDataMapperImpl.AddUser(user, CompanyName, ZipCode);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "User Added Successfully");
				setVisible(false);

			}
		});
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		setSize(1500, 840);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	public static void main(String[] args) {
		new AddUser();
	}
}