package com.application.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import com.application.model.User;
import com.google.gson.Gson;


public class MapJsonService implements iMapJsonService{
	
	static HttpURLConnection connection = null;
	static StringBuffer responseContent = new StringBuffer();
	static Gson gson = new Gson();
	
	
	//getconnection()
	//addrecords(conn, ){
	//prepared statement
//}
	@Override
	public  List<User> getData() {
	    
		try {
			URL url = new URL("https://jsonplaceholder.typicode.com/users");
			connection = (HttpURLConnection) url.openConnection();
			
			
			//Request setup
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(500000);
			connection.setReadTimeout(500000);
			
			
			int status = connection.getResponseCode();
			//System.out.println(status);
			
			String line;
			
			if(status>299) {
				BufferedReader reader=new BufferedReader(new InputStreamReader(connection.getErrorStream()));
				while((line=reader.readLine())!=null) {
					 responseContent.append(line);
				}
				reader.close();
			}
			else {
				BufferedReader reader=new BufferedReader(new InputStreamReader(connection.getInputStream()));
				while((line=reader.readLine())!=null) {
					responseContent.append(line);
				}
				reader.close();
			}
		//System.out.println("#############################");	
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			connection.disconnect();
		}
		
		List<User> user_list = Arrays.asList(gson.fromJson(responseContent.toString(),User[].class));
		//System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		//for (User user : user_list) {
		//	System.out.println(user);
		//}
		return user_list;
		
	}	
}


