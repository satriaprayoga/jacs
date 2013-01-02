package org.satriaprayoga.jacs.servlet.auth;


/**
 * CpeAuthenticator.java
 * @author GILANG SATRIA PRAYOGA
 */
public interface CpeAuthenticator {

	public boolean authenticate(String username,String password);
}
