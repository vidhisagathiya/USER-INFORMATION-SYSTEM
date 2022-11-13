package com.application.model;

public class Geo {
	public String lat;
	public String lng;

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
		return this.lat + " " + this.lng;
	}

}
