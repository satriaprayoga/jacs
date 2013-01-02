/**
 * 
 */
package org.satriaprayoga.jacs.structure;

/**
 * @author satriaprayoga
 *
 */
public class ParameterInfoStruct {

	private String name;
	private boolean writable;
	
	public ParameterInfoStruct(String name,boolean writable) {
		this.name=name;
		this.writable=writable;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isWritable() {
		return writable;
	}
}
