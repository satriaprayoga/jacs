/**
 * jacs-core
 * org.satriaprayoga.jacs
 */
package org.satriaprayoga.jacs;

import java.util.Iterator;

/**
 * SoapArgument
 * @author GILANG SATRIA PRAYOGA
 */
public interface SoapParameter extends Parameter{
	
	public SoapParameter setValue(String value);
	
	public SoapParameter addSoapParameter(SoapParameter argument);
	
	public SoapParameter getChildElement(String childName);
	
	public Iterator<SoapParameter> childIterator();
	
	public boolean hasChild();
	
	public int childSize();
}
