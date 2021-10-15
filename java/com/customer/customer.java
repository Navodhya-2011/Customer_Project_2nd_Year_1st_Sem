package com.customer;

public class customer {
	private  int ID;
	private String name;
	private String email;
	private String phone;
	private String userName;
	private String password;
	public customer(int iD, String name, String email, String phone, String userName, String password) {
		super();
		this.ID = iD;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.userName = userName;
		this.password = password;
	}
	public int getID() {
		return ID;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getPhone() {
		return phone;
	}
	public String getUsername() {
		return userName;
	}
	public String getPassword() {
		return password;
	}

	
	
}
