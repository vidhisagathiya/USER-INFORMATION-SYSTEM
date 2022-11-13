package com.application.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.application.model.User;
import com.application.service.ConnectDB;
import com.application.service.MapJsonService;
import com.application.service.MapUserDataService;
import com.application.service.iMapJsonService;


public class StudentApplication {

	static iMapJsonService mapJsonService = new MapJsonService();

	public static void main(String[] args) {

		List<User> user_list = mapJsonService.getData();

		try {

			ConnectDB.ConnectToDB().setAutoCommit(false);

			for (User obj : user_list) {

				String emailadd = obj.getEmail();

				PreparedStatement stmt = ConnectDB.ConnectToDB()
						.prepareStatement("SELECT userid from User where email = ?");
				stmt.setString(1, emailadd);
				ResultSet check = stmt.executeQuery();

				if (check.next() == false) {

					PreparedStatement pstmt3 = ConnectDB.ConnectToDB()
							.prepareStatement("INSERT INTO Address values (?, ?, ?, ?, ?, ?, ?)");

					PreparedStatement pstmt1 = ConnectDB.ConnectToDB()
							.prepareStatement("INSERT INTO Company values (?, ?, ?, ?)");

					PreparedStatement pstmt = ConnectDB.ConnectToDB()
							.prepareStatement("INSERT INTO User values (?, ?, ?, ?, ?, ?, ?, ?)");

					int addressid = obj.getAddress().getid();
					String street = obj.getAddress().getStreet();
					String suite = obj.getAddress().getSuite();
					String city = obj.getAddress().getCity();
					String zipcode = obj.getAddress().getZipcode();

					String lat = obj.getAddress().getGeo().getLat();
					String lng = obj.getAddress().getGeo().getLng();

					pstmt3.setInt(1, addressid);
					pstmt3.setString(2, street);
					pstmt3.setString(3, suite);
					pstmt3.setString(4, city);
					pstmt3.setString(5, zipcode);
					pstmt3.setString(6, lat);
					pstmt3.setString(7, lng);

					pstmt3.executeUpdate();

					int companyid = obj.getCompany().getId();
					String cname = obj.getCompany().getName();
					String catchPhrase = obj.getCompany().getCatchPhrase();
					String bs = obj.getCompany().getBs();

					pstmt1.setInt(1, companyid);
					pstmt1.setString(2, cname);
					pstmt1.setString(3, catchPhrase);
					pstmt1.setString(4, bs);
					pstmt1.executeUpdate();

					int userid = obj.getId();
					String name = obj.getName();
					String username = obj.getUsername();
					String email = obj.getEmail();
					String phone = obj.getPhone();
					String website = obj.getWebsite();

					pstmt.setInt(1, userid);
					pstmt.setString(2, name);
					pstmt.setString(3, username);
					pstmt.setString(4, email);

					pstmt.setString(5, phone);
					pstmt.setString(6, website);

					String companyadd = obj.getCompany().getName();
					PreparedStatement pstmt5 = ConnectDB.ConnectToDB()
							.prepareStatement("SELECT cid from company where cname = ?");
					pstmt5.setString(1, companyadd);
					ResultSet cid = pstmt5.executeQuery();
					cid.next();

					String add = obj.getAddress().getZipcode();
					PreparedStatement pstmt6 = ConnectDB.ConnectToDB()
							.prepareStatement("SELECT addressid from address where zipcode = ?");
					pstmt6.setString(1, add);
					ResultSet addid = pstmt6.executeQuery();
					addid.next();
					pstmt.setInt(7, cid.getInt(1));
					pstmt.setInt(8, addid.getInt(1));
					pstmt.executeUpdate();

				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}
}
