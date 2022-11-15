package com.application.dal;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface DataMapper {

	public ResultSet getAllData() throws SQLException;

}
