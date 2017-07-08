package com.et.util;

import org.forgerock.opendj.ldap.Connection;
import org.forgerock.opendj.ldap.Entry;
import org.forgerock.opendj.ldap.ErrorResultException;
import org.forgerock.opendj.ldap.LDAPConnectionFactory;
import org.forgerock.opendj.ldap.LinkedHashMapEntry;

import com.et.auth.NewUser;

public class Registration {

	
	public void addUser(NewUser nusr){
		
		System.out.println("IN ADD USER ");
		
		// An entry to add to the directory
		Entry entry = new LinkedHashMapEntry("cn=Bob.example,ou=people,dc=openam,dc=forgerock,dc=org")
		    .addAttribute("cn", "Bob.example")
		    .addAttribute("objectclass", "top")
		    .addAttribute("objectclass", "person")
		    .addAttribute("objectclass", "organizationalPerson")
		    .addAttribute("objectclass", "inetOrgPerson")
		    .addAttribute("mail", "subgenius@example.com")
		    .addAttribute("sn", "Dobbs");

		final LDAPConnectionFactory factory = new LDAPConnectionFactory("localhost", 1389);
		Connection connection = null;
		try {
		    connection = factory.getConnection();
		    // Bind as a user who has the right to add entries.
		    connection.bind("cn=Directory Manager", new char[]{'o','p','e','n','d','j'});

		    connection.add(entry);

		} catch (final ErrorResultException e) {
		    System.err.println(e.getMessage());
		    System.exit(e.getResult().getResultCode().intValue());
		    return;
		} 
		catch (final Exception e) {
		    System.err.println(e.getMessage());
		    return;
		}
		finally {
		    if (connection != null) {
		        connection.close();
		    }
		}
		
	}
	
}
