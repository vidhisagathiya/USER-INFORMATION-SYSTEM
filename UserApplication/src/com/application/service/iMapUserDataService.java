package com.application.service;

import java.sql.ResultSet;
import java.util.List;

import com.application.model.User;

public interface iMapUserDataService {
	
	public ResultSet getallData();
	public ResultSet getByCompany(String comapnyname);
	public ResultSet getByLocation(String cityName);
	public ResultSet getByEmail(String EmailId);
	
}
