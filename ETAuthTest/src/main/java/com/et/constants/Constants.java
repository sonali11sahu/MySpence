package com.et.constants;

public class Constants {

	//WEB APPLICATION
	
	static public String  peerIP = "http://10.0.0.69";
	static public String ldapIP = "localhost";
	static public int ldapPort = 1389;
	static public String ldapAdmin = "cn=Directory Manager";
	static public char[] ldapPwd = new char[]{'o','p','e','n','d','j'};
	static public String WSip = Constants.peerIP + ":8090";
	static public String openAMauthURL = Constants.peerIP+":8080/OpenAM-11.0.0/identity/authenticate?username=";
	static public String WSlogin = "/login";
	static public String WSregister = "/register";
	static public String WSlogout = "/logout";

}
