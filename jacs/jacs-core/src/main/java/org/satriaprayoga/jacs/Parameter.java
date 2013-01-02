/**
 * jacs-core
 * org.satriaprayoga.jacs
 */
package org.satriaprayoga.jacs;

/**
 * Argument
 * @author GILANG SATRIA PRAYOGA
 */
public interface Parameter {

	public void setAttribute(String name,String value);
	
	public String getValue();
	
	public String getAttributeValue(String name);
	
	public String getAttributeName();
	
	public String getName();
	
	public String getUri();
	
	public String getPrefix();
}
