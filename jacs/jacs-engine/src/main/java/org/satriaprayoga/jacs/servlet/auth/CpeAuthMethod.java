/**
 * org.satriaprayoga.jacs.server.auth
 */
package org.satriaprayoga.jacs.servlet.auth;

/**
 * CpeAuthMethod.java
 * @author GILANG SATRIA PRAYOGA
 */
public enum CpeAuthMethod {
	BASIC("Basic"),
	DIGEST("Digest"),
	MD5("md5");
	
	final String method;
	
	private CpeAuthMethod(String methodName) {
		this.method=methodName;
	}
	
	@Override
	public String toString() {
		return method;
	}
}
