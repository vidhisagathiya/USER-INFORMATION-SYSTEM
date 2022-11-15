package com.application.model;

public class User {

	// All final attributes
	private final int Id;
	private final String name;
	private final String username;
	private final String email;
	private final Address address;
	private final String phone;
	private final String website;
	private final Company company;

	private User(UserBuilder builder) {
		this.Id = builder.id;
		this.name = builder.name;
		this.username = builder.username;
		this.email = builder.email;
		this.address = builder.address;
		this.phone = builder.phone;
		this.website = builder.website;
		this.company = builder.company;
	}

	// All getter, and NO setter to provide immutability
	public int getId() {
		return Id;
	}

	public String getName() {
		return name;
	}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public Address getAddress() {
		return address;
	}

	public String getPhone() {
		return phone;
	}

	public String getWebsite() {
		return website;
	}

	public Company getCompany() {
		return company;
	}

	@Override
	public String toString() {
		return this.name + " " + this.username + " " + this.email + " " + this.address + " " + this.phone + " "
				+ this.website + " " + this.company;
	}

	// Builder class
	public static class UserBuilder {
		private int id;
		private String name;
		private String username;
		private String email;
		private Address address;
		private String phone;
		private String website;
		private Company company;

		public UserBuilder id(int id) {
			this.id = id;
			return this;
		}

		public UserBuilder name(String name) {
			this.name = name;
			return this;
		}

		public UserBuilder username(String username) {
			this.username = username;
			return this;
		}

		public UserBuilder email(String email) {
			this.email = email;
			return this;
		}

		public UserBuilder address(Address address) {
			this.address = address;
			return this;
		}

		public UserBuilder phone(String phone) {
			this.phone = phone;
			return this;
		}

		public UserBuilder website(String website) {
			this.website = website;
			return this;
		}

		public UserBuilder Company(Company company) {
			this.company = company;
			return this;
		}

		// Return the finally constructed User object
		public User build() {
			User user = new User(this);
			return user;
		}
	}

}
