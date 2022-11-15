package com.application.dal;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.application.model.User;

public interface UserDataMapper extends DataMapper {

	public void AddUser(User user, String CompanyName, String ZipCode) throws SQLException;

	public void deleteUser(String Email) throws SQLException;

	public ResultSet getUserByCompany(String comapnyname) throws SQLException;

	public ResultSet getUserByLocation(String cityName) throws SQLException;

	public ResultSet getUserByEmail(String EmailId) throws SQLException;

	public ResultSet getAddressZipcode() throws SQLException;

}
