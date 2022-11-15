package com.application.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.TableColumnModel;

import com.application.dal.UserDataMapperImpl;

import net.proteanit.sql.DbUtils;

public class GetAllUserDetails extends JFrame {

	private JTable table;

	public static void main(String[] args) {
		new GetAllUserDetails().setVisible(true);
	}

	public GetAllUserDetails() {

		getContentPane().setBackground(Color.WHITE);
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 13));

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(1000, 768);
		setLayout(null);
		setVisible(true);

		JLabel userLabel = new JLabel("All User's Information");
		userLabel.setForeground(Color.BLUE);
		userLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		userLabel.setBounds(50, 20, 570, 35);
		add(userLabel);

		JButton btnShow = new JButton("CLICK HERE TO VIEW DATA");
		btnShow.setFont(new Font("Tahoma", Font.PLAIN, 20));

		btnShow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				UserDataMapperImpl dObj = new UserDataMapperImpl();
				try {
					table.setModel(DbUtils.resultSetToTableModel(dObj.getAllData()));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				table.getColumnModel().getColumn(0).setHeaderValue("FULL NAME");
				table.getColumnModel().getColumn(1).setHeaderValue("USER NAME");
				table.getColumnModel().getColumn(2).setHeaderValue("EMAIL");
				table.getColumnModel().getColumn(3).setHeaderValue("PHONE");
				table.getColumnModel().getColumn(4).setHeaderValue("WEBSITE");
				table.getColumnModel().getColumn(5).setHeaderValue("COMPANY");
				table.getColumnModel().getColumn(6).setHeaderValue("CATCHPHRASE");
				table.getColumnModel().getColumn(7).setHeaderValue("BASE");
				table.getColumnModel().getColumn(8).setHeaderValue("STREET");
				table.getColumnModel().getColumn(9).setHeaderValue("SUITE");
				table.getColumnModel().getColumn(10).setHeaderValue("CITY");
				table.getColumnModel().getColumn(11).setHeaderValue("ZIPCODE");
				table.setFillsViewportHeight(true);
				TableColumnModel columnModel = table.getColumnModel();
				columnModel.getColumn(0).setPreferredWidth(200);
			}
		});

		btnShow.setBounds(50, 100, 330, 50);
		add(btnShow);

		table = new JTable();
		table.setBackground(Color.WHITE);
		table.setBounds(23, 150, 1600, 768);
		Font bigFont = new Font("IMPACT", Font.PLAIN, 15);
		table.getTableHeader().setFont(bigFont);

		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(23, 250, 1300, 300);
		pane.setBackground(Color.WHITE);
		add(pane);

		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		setSize(1500, 840);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
