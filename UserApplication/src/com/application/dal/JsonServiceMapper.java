package com.application.dal;

import java.sql.SQLException;
import java.util.List;

import com.application.model.User;

public interface JsonServiceMapper {

	public List<User> getJsonData() ;

	public void JSONtoDatabase() throws SQLException;

}
