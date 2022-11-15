package com.application.UnitTestCases;

import org.junit.Test;

import com.application.dal.UserDataMapper;
import com.application.dal.UserDataMapperImpl;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.ResultSet;
import java.sql.SQLException;

public class testUserDataMapper {

	UserDataMapper udm = new UserDataMapperImpl();

	@Test
	public void tesGetAllData() throws SQLException {
		String result = null;
		ResultSet rs = udm.getAllData();
		while (rs.next()) {
			result = rs.getString(1);
			//System.out.println(result);
		}
		assertNotNull(result);
	}

	@Test
	public void tesGetUserByEmail() throws SQLException {
		String result = null;
		String Email = "Sincere@april.biz";
		ResultSet rs = udm.getUserByEmail(Email);
		while (rs.next()) {
			result = rs.getString(1);
			// System.out.println(result);

		}
		assertEquals("Leanne Graham", result);
	}

	@Test
	public void testGetUserByCompany() throws SQLException {
		String result = null;
		String companyName = "Romaguera-Jacobson";
		ResultSet rs = udm.getUserByCompany(companyName);
		while (rs.next()) {
			result = rs.getString(1);
			// System.out.println(result);

		}
		assertEquals("Clementine Bauch", result);
	}

	@Test
	public void testGetUserByLocation() throws SQLException {
		String result = null;
		String cityName = "Howemouth";
		ResultSet rs = udm.getUserByLocation(cityName);
		while (rs.next()) {
			result = rs.getString(1);
			// System.out.println(result);

		}
		assertEquals("Kurtis Weissnat", result);
	}
}
