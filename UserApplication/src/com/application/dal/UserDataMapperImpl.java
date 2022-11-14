package com.application.dal;

import java.sql.*;

import com.application.model.User;

public class UserDataMapperImpl implements UserDataMapper {

	@Override
	public void AddUser(User user, String CompanyName, String ZipCode) {

		try {
			ConnectDB con = ConnectDB.getInstance();

			PreparedStatement stmt = con.getConnection().prepareStatement("SELECT userid from User where email = ?");
			stmt.setString(1, user.getEmail());
			ResultSet check = stmt.executeQuery();

			if (check.next() == false) {

				PreparedStatement pstmt = con.getConnection().prepareStatement(
						"INSERT INTO User (fullname , username, email, phone, website, cid, addressid) "
								+ "values (?, ?, ?, ?, ?, ?, ?)");

				pstmt.setString(1, user.getName());
				pstmt.setString(2, user.username);
				pstmt.setString(3, user.getEmail());
				pstmt.setString(4, user.getPhone());
				pstmt.setString(5, user.getWebsite());

				PreparedStatement pstmt1 = con.getConnection()
						.prepareStatement("SELECT cid from company where cname = ?");
				pstmt1.setString(1, CompanyName);
				ResultSet city = pstmt1.executeQuery();
				city.next();

				PreparedStatement pstmt2 = con.getConnection()
						.prepareStatement("SELECT addressid from address where zipcode = ?");
				pstmt2.setString(1, ZipCode);

				ResultSet address = pstmt2.executeQuery();
				address.next();
				pstmt.setInt(6, city.getInt(1));
				pstmt.setInt(7, address.getInt(1));
				pstmt.executeUpdate();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteUser(String Email) {
		try {
			ConnectDB con = ConnectDB.getInstance();
			PreparedStatement stmt = con.getConnection().prepareStatement("DELETE from User where email = ?");
			stmt.setString(1, Email);
			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public ResultSet getAllData() {

		ResultSet rs = null;

		String query = "select " + "  u.fullname,\n" + "  u.username,\n" + "  u.email,\n" + "  u.phone,\n"
				+ "  u.website,\n" + "  c.cname,\n" + "  c.catchphrase,\n" + "  c.cbs,\n" + "  a.street,\n"
				+ "  a.suite,\n" + "  a.city,\n" + "  a.zipcode\n"
				+ " from user u right join company c on u.cid = c.cid right join address a\n"
				+ " on u.addressid = a.addressid";

		try {
			ConnectDB con = ConnectDB.getInstance();
			PreparedStatement stmt = con.getConnection().prepareStatement(query);
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
	public ResultSet getUserByCompany(String comapnyname) {
		// TODO Auto-generated method stub

		ResultSet rs = null;
		String query = "select " + "  u.fullname,\n" + "  u.username,\n" + "  u.email,\n" + "  u.phone,\n"
				+ "  u.website,\n" + "  c.cname,\n" + "  c.catchphrase,\n" + "  c.cbs,\n" + "  a.street,\n"
				+ "  a.suite,\n" + "  a.city,\n" + "  a.zipcode\n"
				+ " from user u right join company c on u.cid = c.cid right join address a\n"
				+ " on u.addressid = a.addressid " + "where c.cname = ?";

		try {
			ConnectDB con = ConnectDB.getInstance();
			PreparedStatement stmt = con.getConnection().prepareStatement(query);
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
	public ResultSet getUserByLocation(String cityName) {
		// TODO Auto-generated method stub
		ResultSet rs = null;

		String query = "select " + "  u.fullname,\n" + "  u.username,\n" + "  u.email,\n" + "  u.phone,\n"
				+ "  u.website,\n" + "  c.cname,\n" + "  c.catchphrase,\n" + "  c.cbs,\n" + "  a.street,\n"
				+ "  a.suite,\n" + "  a.city,\n" + "  a.zipcode\n"
				+ " from user u right join company c on u.cid = c.cid right join address a\n"
				+ " on u.addressid = a.addressid " + "where a.city = ?";

		try {
			ConnectDB con = ConnectDB.getInstance();
			PreparedStatement stmt = con.getConnection().prepareStatement(query);
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
	public ResultSet getUserByEmail(String EmailId) {
		// TODO Auto-generated method stub

		ResultSet rs = null;
		String query = "select " + "  u.fullname,\n" + "  u.username,\n" + "  u.email,\n" + "  u.phone,\n"
				+ "  u.website,\n" + "  c.cname,\n" + "  c.catchphrase,\n" + "  c.cbs,\n" + "  a.street,\n"
				+ "  a.suite,\n" + "  a.city,\n" + "  a.zipcode\n"
				+ " from user u right join company c on u.cid = c.cid right join address a\n"
				+ " on u.addressid = a.addressid " + "where u.email= ?";

		try {
			ConnectDB con = ConnectDB.getInstance();
			PreparedStatement stmt = con.getConnection().prepareStatement(query);
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

	@Override
	public ResultSet getAddressZipcode() {
		// TODO Auto-generated method stub
		ResultSet rs = null;

		String query = "select street, suite, city, zipcode, lat, lng from address";

		try {
			ConnectDB con = ConnectDB.getInstance();
			PreparedStatement stmt = con.getConnection().prepareStatement(query);
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
