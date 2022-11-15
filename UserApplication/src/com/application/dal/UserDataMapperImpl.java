package com.application.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.application.model.User;

public class UserDataMapperImpl implements UserDataMapper {

	ResultSet rs = null;
	Connection con = null;
	
	@Override
	public void AddUser(User user, String CompanyName, String ZipCode) throws SQLException {

		try {
			con = ConnectDB.getInstance().getConnection();

			PreparedStatement stmt = con.prepareStatement("SELECT Userid FROM User WHERE Email = ?");
			stmt.setString(1, user.getEmail());
			ResultSet check = stmt.executeQuery();

			if (!check.next()) {

				PreparedStatement pstmt = con.prepareStatement(
						"INSERT INTO User (Fullname , Username, Email, Phone, Website, CompanyId, AddressId) "
								+ "VALUES (?, ?, ?, ?, ?, ?, ?)");

				pstmt.setString(1, user.getName());
				pstmt.setString(2, user.getUsername());
				pstmt.setString(3, user.getEmail());
				pstmt.setString(4, user.getPhone());
				pstmt.setString(5, user.getWebsite());

				PreparedStatement pstmt1 = con.prepareStatement("SELECT CompanyId FROM Company WHERE Companyname = ?");
				pstmt1.setString(1, CompanyName);
				ResultSet city = pstmt1.executeQuery();
				city.next();

				PreparedStatement pstmt2 = con.prepareStatement("SELECT AddressId FROM Address WHERE Zipcode = ?");
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
	public void deleteUser(String Email) throws SQLException {
		Connection con = null;
		try {
			con = ConnectDB.getInstance().getConnection();
			PreparedStatement stmt = con.prepareStatement("DELETE FROM User WHERE Email = ?");
			stmt.setString(1, Email);
			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public ResultSet getAllData() throws SQLException {

		String query = "SELECT " + "  u.Fullname,\n" + "  u.Username,\n" + "  u.Email,\n" + "  u.Phone,\n"
				+ "  u.Website,\n" + "  c.CompanyName,\n" + "  c.Catchphrase,\n" + "  c.cbs,\n" + "  a.Street,\n"
				+ "  a.Suite,\n" + "  a.City,\n" + "  a.Zipcode\n"
				+ " FROM User u RIGHT JOIN Company c ON u.CompanyId = c.CompanyId RIGHT JOIN Address a\n"
				+ " ON u.Addressid = a.Addressid ";

		try {
			con = ConnectDB.getInstance().getConnection();
			PreparedStatement stmt = con.prepareStatement(query);
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
	public ResultSet getUserByCompany(String comapnyname) throws SQLException {

		ResultSet rs = null;
		Connection con = null;
		String query = "SELECT " + "  u.Fullname,\n" + "  u.Username,\n" + "  u.Email,\n" + "  u.Phone,\n"
				+ "  u.Website,\n" + "  c.Companyname,\n" + "  c.Catchphrase,\n" + "  c.cbs,\n" + "  a.Street,\n"
				+ "  a.Suite,\n" + "  a.City,\n" + "  a.Zipcode\n"
				+ " FROM User u RIGHT JOIN Company c ON u.CompanyId = c.CompanyId RIGHT JOIN Address a\n"
				+ " ON u.Addressid = a.Addressid " + "WHERE  c.Companyname = ?";

		try {
			con = ConnectDB.getInstance().getConnection();
			PreparedStatement stmt = con.prepareStatement(query);
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
	public ResultSet getUserByLocation(String cityName) throws SQLException {
		
		String query = "SELECT " + "  u.Fullname,\n" + "  u.Username,\n" + "  u.Email,\n" + "  u.Phone,\n"
				+ "  u.Website,\n" + "  c.Companyname,\n" + "  c.Catchphrase,\n" + "  c.cbs,\n" + "  a.Street,\n"
				+ "  a.Suite,\n" + "  a.City,\n" + "  a.Zipcode\n"
				+ " FROM User u RIGHT JOIN Company c ON u.CompanyId = c.CompanyId RIGHT JOIN Address a\n"
				+ " ON u.Addressid = a.Addressid " + "WHERE  a.City = ?";

		try {
			con = ConnectDB.getInstance().getConnection();
			PreparedStatement stmt = con.prepareStatement(query);
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
	public ResultSet getUserByEmail(String EmailId) throws SQLException {

		String query = "SELECT " + "  u.Fullname,\n" + "  u.Username,\n" + "  u.Email,\n" + "  u.Phone,\n"
				+ "  u.Website,\n" + "  c.Companyname,\n" + "  c.Catchphrase,\n" + "  c.cbs,\n" + "  a.Street,\n"
				+ "  a.Suite,\n" + "  a.City,\n" + "  a.Zipcode\n"
				+ " FROM User u RIGHT JOIN Company c ON u.CompanyId = c.CompanyId RIGHT JOIN Address a\n"
				+ " ON u.Addressid = a.Addressid " + "WHERE u.Email= ?";

		try {
			con = ConnectDB.getInstance().getConnection();
			PreparedStatement stmt = con.prepareStatement(query);
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
	public ResultSet getAddressZipcode() throws SQLException {
		
		String query = "SELECT Street, Suite, City, Zipcode, Latitude, Longitude  FROM Address";

		try {
			con = ConnectDB.getInstance().getConnection();
			PreparedStatement stmt = con.prepareStatement(query);
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
