package com.application.dal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import com.application.model.User;
import com.google.gson.Gson;

public class JsonServiceImpl implements JsonServiceMapper {

	static HttpURLConnection connection = null;
	static StringBuffer responseContent = new StringBuffer();
	static Gson gson = new Gson();

	@Override
	public List<User> getJsonData() {

		try {
			URL url = new URL("https://jsonplaceholder.typicode.com/users");
			connection = (HttpURLConnection) url.openConnection();

			// Request setup
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(500000);
			connection.setReadTimeout(500000);

			int status = connection.getResponseCode();

			String line;

			if (status > 299) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
				while ((line = reader.readLine()) != null) {
					responseContent.append(line);
				}
				reader.close();
			} else {
				BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				while ((line = reader.readLine()) != null) {
					responseContent.append(line);
				}
				reader.close();
			}

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connection.disconnect();
		}

		List<User> user_list = Arrays.asList(gson.fromJson(responseContent.toString(), User[].class));
		return user_list;

	}

	@Override
	public void JSONtoDatabase() throws SQLException {

		List<User> user_list = getJsonData();
		Connection con = null;
		try {
			con = ConnectDB.getInstance().getConnection();
			for (User obj : user_list) {

				String Email = obj.getEmail();

				PreparedStatement stmt = con.prepareStatement("SELECT UserId From User WHERE Email = ?");
				stmt.setString(1, Email);
				ResultSet check = stmt.executeQuery();

				if (!check.next()) {

					PreparedStatement pstmt1 = con.prepareStatement("INSERT INTO Address VALUES (?, ?, ?, ?, ?, ?, ?)");

					pstmt1.setInt(1, obj.getAddress().getId());
					pstmt1.setString(2, obj.getAddress().getStreet());
					pstmt1.setString(3, obj.getAddress().getSuite());
					pstmt1.setString(4, obj.getAddress().getCity());
					pstmt1.setString(5, obj.getAddress().getZipcode());
					pstmt1.setString(6, obj.getAddress().getGeo().getLat());
					pstmt1.setString(7, obj.getAddress().getGeo().getLng());
					pstmt1.executeUpdate();

					PreparedStatement pstmt2 = con.prepareStatement("INSERT INTO Company VALUES (?, ?, ?, ?)");

					pstmt2.setInt(1, obj.getCompany().getId());
					pstmt2.setString(2, obj.getCompany().getName());
					pstmt2.setString(3, obj.getCompany().getCatchPhrase());
					pstmt2.setString(4, obj.getCompany().getBs());
					pstmt2.executeUpdate();

					PreparedStatement pstmt3 = con.prepareStatement("INSERT INTO User VALUES (?, ?, ?, ?, ?, ?, ?, ?)");

					pstmt3.setInt(1, obj.getId());
					pstmt3.setString(2, obj.getName());
					pstmt3.setString(3, obj.getUsername());
					pstmt3.setString(4, obj.getEmail());
					pstmt3.setString(5, obj.getPhone());
					pstmt3.setString(6, obj.getWebsite());

					PreparedStatement pstmt4 = con.prepareStatement("SELECT CompanyId From Company WHERE CompanyName = ?");
					pstmt4.setString(1, obj.getCompany().getName());
					ResultSet city = pstmt4.executeQuery();
					city.next();

					PreparedStatement pstmt5 = con.prepareStatement("SELECT AddressId From Address WHERE Zipcode = ?");
					pstmt5.setString(1, obj.getAddress().getZipcode());

					ResultSet address = pstmt5.executeQuery();
					address.next();
					pstmt3.setInt(7, city.getInt(1));
					pstmt3.setInt(8, address.getInt(1));
					pstmt3.executeUpdate();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
