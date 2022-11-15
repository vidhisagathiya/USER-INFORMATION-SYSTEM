package com.application.controller;

import java.sql.SQLException;

import javax.swing.JFrame;

import com.application.dal.JsonServiceImpl;
import com.application.view.MainFrame;

public class Main extends JFrame {

	public static void main(String[] args) {

		JsonServiceImpl jsonObj = new JsonServiceImpl();
		try {
			jsonObj.JSONtoDatabase();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new MainFrame().setVisible(true);
	}
}
