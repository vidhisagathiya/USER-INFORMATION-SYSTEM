package com.application.model;

public class Company {
	public int companyid;
	public String name;
	public String catchPhrase;
	public String bs;

	public int getcompanyid()
	{
		return companyid;
	}
	public void setcompanyid(int companyid)
	{
		this.companyid = companyid;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCatchPhrase() {
		return catchPhrase;
	}

	public void setCatchPhrase(String catchPhrase) {
		this.catchPhrase = catchPhrase;
	}

	public String getBs() {
		return bs;
	}

	public void setBs(String bs) {
		this.bs = bs;
	}
	
	public String toString() {
		return this.name+" "+this.catchPhrase+" "+this.bs;
		}

}
