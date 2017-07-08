package com.et.auth;

public class NewUser {
	
	
	private String name;
	private String email;
	private String pwd;
	private String cpwd;
	private String mobile;
	
	public NewUser(String name, String email, String pwd, String cpwd, String mobile) {
		super();
		this.name = name;
		this.email = email;
		this.pwd = pwd;
		this.cpwd = cpwd;
		this.mobile = mobile;
	}

	public NewUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getCpwd() {
		return cpwd;
	}

	public void setCpwd(String cpwd) {
		this.cpwd = cpwd;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	

}
