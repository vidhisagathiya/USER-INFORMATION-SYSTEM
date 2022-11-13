package com.application.view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.TableColumnModel;
import com.application.service.UserDataMapperImpl;

import net.proteanit.sql.DbUtils;

public class GetAllUserDetails extends JFrame {

	private JTable table;

	public static void main(String[] args) {
		new GetAllUserDetails().setVisible(true);
	}

	public GetAllUserDetails() {

		getContentPane().setBackground(Color.WHITE);
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 13));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 768);
		setLayout(null);
		setVisible(true);

		JLabel userLabel = new JLabel("All User Information");
		userLabel.setFont(new Font("Tahoma", Font.BOLD, 31));
		userLabel.setForeground(new Color(100, 149, 237));
		userLabel.setBounds(50, 20, 570, 35);
		add(userLabel);

		JButton btnShow = new JButton("Click to get data");
		btnShow.setFont(new Font("Tahoma", Font.PLAIN, 20));

		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				UserDataMapperImpl dObj = new UserDataMapperImpl();
				table.setModel(DbUtils.resultSetToTableModel(dObj.getAllData()));
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
				table.setFillsViewportHeight(true);
				TableColumnModel columnModel = table.getColumnModel();
				columnModel.getColumn(0).setPreferredWidth(200);
			}
		});

		btnShow.setBounds(200, 100, 200, 30);
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

		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setSize(1800, 1090);
		setVisible(true);

	}

}
