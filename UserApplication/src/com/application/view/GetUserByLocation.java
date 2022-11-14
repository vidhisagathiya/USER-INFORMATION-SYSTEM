package com.application.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.TableColumnModel;

import com.application.dal.UserDataMapperImpl;

import net.proteanit.sql.DbUtils;

public class GetUserByLocation extends JFrame {

	private JTable table;
	private JTextField textField;

	public static void main(String[] args) {
		new GetUserByLocation().setVisible(true);
	}

	public GetUserByLocation() {
		super("SEARCH USER BY LOCATION");
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 13));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 768);
		setLayout(null);
		setVisible(true);

		JLabel Lcode = new JLabel("Enter City Name :");
		Lcode.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Lcode.setBounds(50, 100, 200, 30);
		add(Lcode);

		JLabel userLabel = new JLabel("Users belong to searched Location");
		userLabel.setForeground(Color.BLUE);
		userLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		userLabel.setBounds(50, 20, 570, 35);
		add(userLabel);

		JButton btnShow = new JButton("VIEW DATA");
		btnShow.setFont(new Font("Tahoma", Font.PLAIN, 20));

		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				String location = textField.getText();

				UserDataMapperImpl dObj = new UserDataMapperImpl();
				table.setModel(DbUtils.resultSetToTableModel(dObj.getUserByLocation(location)));
				table.getColumnModel().getColumn(0).setHeaderValue("FULL NAME");
				table.getColumnModel().getColumn(1).setHeaderValue("USER NAME");
				table.getColumnModel().getColumn(2).setHeaderValue("EMAIL");
				table.getColumnModel().getColumn(3).setHeaderValue("PHONE");
				table.getColumnModel().getColumn(4).setHeaderValue("WEBSITE");
				table.getColumnModel().getColumn(5).setHeaderValue("COMPANY");
				table.getColumnModel().getColumn(6).setHeaderValue("CATCHPHRASE");
				table.getColumnModel().getColumn(7).setHeaderValue("BS");
				table.getColumnModel().getColumn(8).setHeaderValue("STREET");
				table.getColumnModel().getColumn(9).setHeaderValue("SUITE");
				table.getColumnModel().getColumn(10).setHeaderValue("CITY");
				table.getColumnModel().getColumn(11).setHeaderValue("ZIPCODE");
				table.setFillsViewportHeight(true);
				TableColumnModel columnModel = table.getColumnModel();
				columnModel.getColumn(0).setPreferredWidth(200);
			}
		});

		btnShow.setBounds(220, 185, 200, 30);
		btnShow.setBorder(new LineBorder(Color.BLACK));
		add(btnShow);

		table = new JTable();
		table.setBackground(Color.WHITE);
		table.setBounds(23, 250, 1600, 768);
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
