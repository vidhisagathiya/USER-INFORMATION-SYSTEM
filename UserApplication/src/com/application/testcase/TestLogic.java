package com.application.testcase;

import static org.junit.Assert.assertEquals;

import java.net.HttpURLConnection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;

import com.application.dal.UserDataMapper;
import com.application.dal.UserDataMapperImpl;
import com.application.model.Address;
import com.application.model.Company;
import com.application.model.User;
import com.google.gson.Gson;

public class TestLogic {

	List<User> data = new ArrayList<User>();
	String userData = null;
	//@BeforeClass
	//public static void setUpBeforeClass() throws Exception {

//		data = Arrays.asList("Leanne Graham", "Bret", "Sincere@april.biz", "1-770-736-8031 x56442",
//				"hildegard.org", "Romaguera-Crona", "Multi-layered client-server neural-net",
//				"harness real-time e-markets", "Kulas Light", "Apt. 556", "Gwenborough", "92998-3874");
		
		//data = iMapUserDataService.getByEmail("Sincere@april.biz");

	//}

	@Test
	public void testgetbyemail() {
		
		
		System.out.println(data.size());
		String tempData = "Leanne Graham, Bret, Sincere@april.biz, 1-770-736-8031 x56442, hildegard.org, Romaguera-Crona, Multi-layered client-server neural-net, harness real-time e-markets, Kulas Light, Apt. 556, Gwenborough, 92998-3874";
		
		//for (User u : data) {
		//	userData = new Gson().toJson(u);
		//}

		//System.out.println(userData);
		// Test equal
		/*UserDataMapper imp = new UserDataMapperImpl();
		try {
			//System.out.println(imp.getByEmail("Sincere@april.biz").getInt(2));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// assertThat(data, imp.getByEmail("Sincere@april.biz").getInt(2));
		assertEquals(tempData, userData);*/
	}
}
