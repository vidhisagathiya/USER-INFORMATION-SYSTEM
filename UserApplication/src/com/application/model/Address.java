package com.application.model;

public class Address {
	public int addressid;
	public String street;
	public String suite;
	public String city;
	public String zipcode;
	public Geo geo;

	public int getaddressid()
	{
		return addressid;
	}
	public void setaddressid(int addressid)
	{
		this.addressid = addressid;
	}
	
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getSuite() {
		return suite;
	}

	public void setSuite(String suite) {
		this.suite = suite;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public Geo getGeo() {
		return geo;
	}

	public void setGeo(Geo geo) {
		this.geo = geo;
	}
	
	public String toString() {
		return this.street+" "+this.suite+" "+this.city+" "+this.zipcode+" "+this.geo;
		}

}
