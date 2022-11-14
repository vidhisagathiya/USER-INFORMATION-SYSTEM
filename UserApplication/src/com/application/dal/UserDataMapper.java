package com.application.dal;

import java.sql.ResultSet;

import com.application.model.User;

public interface UserDataMapper extends DataMapper {

	public void AddUser(User user, String CompanyName, String ZipCode);

	public void deleteUser(String Email);

	public ResultSet getUserByCompany(String comapnyname);

	public ResultSet getUserByLocation(String cityName);

	public ResultSet getUserByEmail(String EmailId);

	public ResultSet getAddressZipcode();

}
