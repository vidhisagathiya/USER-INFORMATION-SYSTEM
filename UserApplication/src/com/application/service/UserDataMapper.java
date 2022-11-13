package com.application.service;

import java.sql.ResultSet;

public interface UserDataMapper {
	
	public ResultSet getAllData();
	public ResultSet getByCompany(String comapnyname);
	public ResultSet getByLocation(String cityName);
	public ResultSet getByEmail(String EmailId);
	
}
