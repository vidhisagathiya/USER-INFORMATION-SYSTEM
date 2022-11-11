package com.application.service;

import java.util.List;

import com.application.model.User;

public interface iMapUserDataService {
	
	public void getallData();
	public List<User> getByCompany(String comapnyname);
	public List<User> getByLocation(String cityName);
	public List<User> getByEmail(String EmailId);
	
}
