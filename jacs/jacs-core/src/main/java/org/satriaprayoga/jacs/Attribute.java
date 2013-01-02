/**
 * jacs-core
 * org.satriaprayoga.jacs
 */
package org.satriaprayoga.jacs;

/**
 * Attribute
 * @author GILANG SATRIA PRAYOGA
 */
public class Attribute {
	
	private String name;
	private String value;
	
	public Attribute(String name,String value) {
		this.name=name;
		this.value=value;
		
	}
	
	public String getName() {
		return name;
	}
	
	public String getValue() {
		return value;
	}
}
