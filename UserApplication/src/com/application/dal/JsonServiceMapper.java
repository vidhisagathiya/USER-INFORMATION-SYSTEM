package com.application.dal;

import java.util.List;
import com.application.model.User;

public interface JsonServiceMapper {

	public List<User> getJsonData();

	public void JSONtoDatabase();

}
