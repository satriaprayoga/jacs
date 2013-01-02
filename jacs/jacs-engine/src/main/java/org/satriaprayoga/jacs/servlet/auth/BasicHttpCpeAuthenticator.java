/**
 * org.satriaprayoga.jacs.server.auth
 */
package org.satriaprayoga.jacs.servlet.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * BasicHttpCpeAuthenticator.java
 * @author GILANG SATRIA PRAYOGA
 */
public class BasicHttpCpeAuthenticator implements CpeAuthenticator{
	
	private final HttpServletRequest request;
	private final HttpServletResponse response;

	public BasicHttpCpeAuthenticator(HttpServletRequest request,
			HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}
	@Override
	public boolean authenticate(String username, String password) {
		request.getHeader("Authorization");
		response.setHeader("", "");
		return false;
	}

}
