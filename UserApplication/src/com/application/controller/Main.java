package com.application.controller;

import javax.swing.*;
import com.application.dal.JsonServiceImpl;
import com.application.view.*;

public class Main extends JFrame {

	public static void main(String[] args) {

		JsonServiceImpl jsonObj = new JsonServiceImpl();
		jsonObj.JSONtoDatabase();
		new MainFrame().setVisible(true); 
	}
}
