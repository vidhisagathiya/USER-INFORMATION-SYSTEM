package com.application.dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CompanyDataMapperImpl implements CompanyDataMapper {

	@Override
	public ResultSet getAllData() {

		ResultSet rs = null;

		String query = "SELECT CompanyId, Companyname, Catchphrase, Cbs FROM Company";

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
