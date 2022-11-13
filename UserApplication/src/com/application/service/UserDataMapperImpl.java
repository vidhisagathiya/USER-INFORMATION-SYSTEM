package com.application.service;

import java.sql.*;

public class UserDataMapperImpl implements UserDataMapper {

	@Override
	public ResultSet getAllData() {

		ResultSet rs = null;

		String query = "select " + "  u.fullname,\n" + "  u.username,\n" + "  u.email,\n" + "  u.phone,\n"
				+ "  u.website,\n" + "  c.cname,\n" + "  c.catchphrase,\n" + "  c.cbs,\n" + "  a.street,\n"
				+ "  a.suite,\n" + "  a.city,\n" + "  a.zipcode\n"
				+ " from user u right join company c on u.cid = c.cid right join address a\n"
				+ " on u.addressid = a.addressid";

		try {
			PreparedStatement stmt = ConnectDB.ConnectToDB().prepareStatement(query);
			rs = stmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;

	}

	@Override
	public ResultSet getByCompany(String comapnyname) {
		// TODO Auto-generated method stub

		ResultSet rs = null;
		String query = "select " + "  u.fullname,\n" + "  u.username,\n" + "  u.email,\n" + "  u.phone,\n"
				+ "  u.website,\n" + "  c.cname,\n" + "  c.catchphrase,\n" + "  c.cbs,\n" + "  a.street,\n"
				+ "  a.suite,\n" + "  a.city,\n" + "  a.zipcode\n"
				+ " from user u right join company c on u.cid = c.cid right join address a\n"
				+ " on u.addressid = a.addressid " + "where c.cname = ?";

		try {

			PreparedStatement stmt = ConnectDB.ConnectToDB().prepareStatement(query);
			stmt.setString(1, comapnyname);
			rs = stmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rs;
	}

	@Override
	public ResultSet getByLocation(String cityName) {
		// TODO Auto-generated method stub
		ResultSet rs = null;

		String query = "select " + "  u.fullname,\n" + "  u.username,\n" + "  u.email,\n" + "  u.phone,\n"
				+ "  u.website,\n" + "  c.cname,\n" + "  c.catchphrase,\n" + "  c.cbs,\n" + "  a.street,\n"
				+ "  a.suite,\n" + "  a.city,\n" + "  a.zipcode\n"
				+ " from user u right join company c on u.cid = c.cid right join address a\n"
				+ " on u.addressid = a.addressid " + "where a.city = ?";

		try {

			PreparedStatement stmt = ConnectDB.ConnectToDB().prepareStatement(query);
			stmt.setString(1, cityName);
			rs = stmt.executeQuery();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rs;
	}

	@Override
	public ResultSet getByEmail(String EmailId) {
		// TODO Auto-generated method stub

		ResultSet rs = null;
		String query = "select " + "  u.fullname,\n" + "  u.username,\n" + "  u.email,\n" + "  u.phone,\n"
				+ "  u.website,\n" + "  c.cname,\n" + "  c.catchphrase,\n" + "  c.cbs,\n" + "  a.street,\n"
				+ "  a.suite,\n" + "  a.city,\n" + "  a.zipcode\n"
				+ " from user u right join company c on u.cid = c.cid right join address a\n"
				+ " on u.addressid = a.addressid " + "where u.email= ?";

		try {

			PreparedStatement stmt = ConnectDB.ConnectToDB().prepareStatement(query);
			stmt.setString(1, EmailId);
			rs = stmt.executeQuery();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rs;
	}
}
