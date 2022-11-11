package com.application.service;

import java.sql.*;
import java.util.*;

import com.application.model.User;

import java.sql.ResultSet;

public class MapUserDataService implements iMapUserDataService {

	@Override
	public void getallData() {

		String query = "select " + "  u.fullname,\n" + "  u.username,\n" + "  u.email,\n" + "  u.phone,\n"
				+ "  u.website,\n" + "  c.cname,\n" + "  c.catchphrase,\n" + "  c.cbs,\n" + "  a.street,\n"
				+ "  a.suite,\n" + "  a.city,\n" + "  a.zipcode\n"
				+ " from user u right join company c on u.cid = c.cid right join address a\n"
				+ " on u.addressid = a.addressid";

		try {

			PreparedStatement stmt = ConnectDB.ConnectToDB().prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String fullname = rs.getString("u.fullname");
				String username = rs.getString("u.username");
				String email = rs.getString("u.email");
				String phone = rs.getString("u.phone");
				String website = rs.getString("u.website");
				String cname = rs.getString("c.cname");
				String catchphrase = rs.getString("c.catchphrase");
				String cbs = rs.getString("c.cbs");
				String street = rs.getString("a.street");
				String suite = rs.getString("a.suite");
				String city = rs.getString("a.city");
				String zipcode = rs.getString("a.zipcode");
				System.out.println("-->getallData");
				System.out.println("-->" + fullname + ", " + username + ", " + email + ", " + phone + ", " + website
						+ ", " + cname + ", " + catchphrase + ", " + cbs + ", " + street + ", " + suite + ", " + city
						+ ", " + zipcode);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<User> getByCompany(String comapnyname) {
		// TODO Auto-generated method stub
		String query = "select " + "  u.fullname,\n" + "  u.username,\n" + "  u.email,\n" + "  u.phone,\n"
				+ "  u.website,\n" + "  c.cname,\n" + "  c.catchphrase,\n" + "  c.cbs,\n" + "  a.street,\n"
				+ "  a.suite,\n" + "  a.city,\n" + "  a.zipcode\n"
				+ " from user u right join company c on u.cid = c.cid right join address a\n"
				+ " on u.addressid = a.addressid "
				+ "where c.cname = ?";

		try {

			PreparedStatement stmt = ConnectDB.ConnectToDB().prepareStatement(query);
			stmt.setString(1, comapnyname);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String fullname = rs.getString("u.fullname");
				String username = rs.getString("u.username");
				String email = rs.getString("u.email");
				String phone = rs.getString("u.phone");
				String website = rs.getString("u.website");
				String cname = rs.getString("c.cname");
				String catchphrase = rs.getString("c.catchphrase");
				String cbs = rs.getString("c.cbs");
				String street = rs.getString("a.street");
				String suite = rs.getString("a.suite");
				String city = rs.getString("a.city");
				String zipcode = rs.getString("a.zipcode");
				System.out.println("-->getByCompany");
				System.out.println("-->" + fullname + ", " + username + ", " + email + ", " + phone + ", " + website
						+ ", " + cname + ", " + catchphrase + ", " + cbs + ", " + street + ", " + suite + ", " + city
						+ ", " + zipcode);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<User> getByLocation(String cityName) {
		// TODO Auto-generated method stub
		String query = "select " + "  u.fullname,\n" + "  u.username,\n" + "  u.email,\n" + "  u.phone,\n"
				+ "  u.website,\n" + "  c.cname,\n" + "  c.catchphrase,\n" + "  c.cbs,\n" + "  a.street,\n"
				+ "  a.suite,\n" + "  a.city,\n" + "  a.zipcode\n"
				+ " from user u right join company c on u.cid = c.cid right join address a\n"
				+ " on u.addressid = a.addressid "
				+ "where a.city = ?";

		try {

			PreparedStatement stmt = ConnectDB.ConnectToDB().prepareStatement(query);
			stmt.setString(1, cityName);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String fullname = rs.getString("u.fullname");
				String username = rs.getString("u.username");
				String email = rs.getString("u.email");
				String phone = rs.getString("u.phone");
				String website = rs.getString("u.website");
				String cname = rs.getString("c.cname");
				String catchphrase = rs.getString("c.catchphrase");
				String cbs = rs.getString("c.cbs");
				String street = rs.getString("a.street");
				String suite = rs.getString("a.suite");
				String city = rs.getString("a.city");
				String zipcode = rs.getString("a.zipcode");
				System.out.println("-->getByLocation");
				System.out.println("-->" + fullname + ", " + username + ", " + email + ", " + phone + ", " + website
						+ ", " + cname + ", " + catchphrase + ", " + cbs + ", " + street + ", " + suite + ", " + city
						+ ", " + zipcode);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<User> getByEmail(String EmailId) {
		// TODO Auto-generated method stub
		String query = "select " + "  u.fullname,\n" + "  u.username,\n" + "  u.email,\n" + "  u.phone,\n"
				+ "  u.website,\n" + "  c.cname,\n" + "  c.catchphrase,\n" + "  c.cbs,\n" + "  a.street,\n"
				+ "  a.suite,\n" + "  a.city,\n" + "  a.zipcode\n"
				+ " from user u right join company c on u.cid = c.cid right join address a\n"
				+ " on u.addressid = a.addressid "
				+ "where u.email= ?";

		try {

			PreparedStatement stmt = ConnectDB.ConnectToDB().prepareStatement(query);
			stmt.setString(1, EmailId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String fullname = rs.getString("u.fullname");
				String username = rs.getString("u.username");
				String email = rs.getString("u.email");
				String phone = rs.getString("u.phone");
				String website = rs.getString("u.website");
				String cname = rs.getString("c.cname");
				String catchphrase = rs.getString("c.catchphrase");
				String cbs = rs.getString("c.cbs");
				String street = rs.getString("a.street");
				String suite = rs.getString("a.suite");
				String city = rs.getString("a.city");
				String zipcode = rs.getString("a.zipcode");
				System.out.println("-->getByEmail");
				System.out.println("-->" + fullname + ", " + username + ", " + email + ", " + phone + ", " + website
						+ ", " + cname + ", " + catchphrase + ", " + cbs + ", " + street + ", " + suite + ", " + city
						+ ", " + zipcode);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
}
