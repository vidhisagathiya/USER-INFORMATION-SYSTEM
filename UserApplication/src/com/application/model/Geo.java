package com.application.model;

public class Geo {
	public int geoid;
	public String lat;
	public String lng;

	public int getgeoid()
	{
		return geoid;
	}
	public void setgeoid(int geoid)
	{
		this.geoid = geoid;
	}
	
	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}
	
	public String toString() {
		return this.lat+" "+this.lng;
		}

}
