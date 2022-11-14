package com.application.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

import com.application.dal.ConnectDB;
import com.application.dal.UserDataMapperImpl;

import net.proteanit.sql.DbUtils;

public class DeleteUser extends JFrame {

	private JTable table;
	private JTextField textField;

	public static void main(String[] args) {
		new DeleteUser().setVisible(true);
	}

	public DeleteUser() {
		super("DELETE USER");
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 13));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 768);
		setLayout(null);
		setVisible(true);

		JLabel Lcode = new JLabel("Enter User's Email: ");
		Lcode.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Lcode.setBounds(50, 100, 200, 30);
		add(Lcode);

		JLabel userLabel = new JLabel("Delete User here...");
		userLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		userLabel.setForeground(Color.BLUE);
		userLabel.setBounds(50, 20, 570, 35);
		add(userLabel);

		JButton btnShow = new JButton("CONFIRM USER");
		btnShow.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JButton btnDelete = new JButton("DELETE USER");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDelete.setVisible(false);

		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				btnDelete.setVisible(false);
				String Email = textField.getText();
				UserDataMapperImpl dObj = new UserDataMapperImpl();
				table.setModel(DbUtils.resultSetToTableModel(dObj.getUserByEmail(Email)));
				table.getColumnModel().getColumn(0).setHeaderValue("FULL NAME");
				table.getColumnModel().getColumn(1).setHeaderValue("USER NAME");
				table.getColumnModel().getColumn(2).setHeaderValue("EMAIL");
				table.getColumnModel().getColumn(3).setHeaderValue("PHONE");
				table.getColumnModel().getColumn(4).setHeaderValue("WEBSITE");
				table.getColumnModel().getColumn(5).setHeaderValue("COMPANY");
				table.getColumnModel().getColumn(6).setHeaderValue("CATCHPHRASE");
				table.getColumnModel().getColumn(7).setHeaderValue("CBS");
				table.getColumnModel().getColumn(8).setHeaderValue("STREET");
				table.getColumnModel().getColumn(9).setHeaderValue("SUITE");
				table.getColumnModel().getColumn(10).setHeaderValue("CITY");
				table.getColumnModel().getColumn(11).setHeaderValue("ZIPCODE");
				try {
					if (Email != null && dObj.getUserByEmail(Email).next() != false)
						btnDelete.setVisible(true);
					else
						JOptionPane.showMessageDialog(null, "User not found");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String Email = textField.getText();
				UserDataMapperImpl userDataMapperImpl = new UserDataMapperImpl();
				userDataMapperImpl.deleteUser(Email);
				JOptionPane.showMessageDialog(null, "User deleted Successfully");
				setVisible(false);

			}
		});

		btnShow.setBounds(220, 185, 200, 30);
		btnShow.setBorder(new LineBorder(Color.BLACK));
		add(btnShow);

		btnDelete.setBounds(220, 350, 200, 30);
		btnDelete.setBorder(new LineBorder(Color.BLACK));
		add(btnDelete);

		table = new JTable();
		table.setBackground(Color.WHITE);
		table.setBounds(23, 250, 1200, 768);
		Font bigFont = new Font("IMPACT", Font.PLAIN, 15);
		table.getTableHeader().setFont(bigFont);

		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(23, 250, 1300, 300);
		pane.setBackground(Color.WHITE);
		add(pane);

		textField = new JTextField();
		textField.setBounds(220, 100, 200, 30);
		add(textField);

		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setSize(1500, 840);
		setLocationRelativeTo(null);
		setVisible(true);

	}
}