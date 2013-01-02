/**
 * jacs-core
 * org.satriaprayoga.jacs.cwmp
 */
package org.satriaprayoga.jacs.cwmp;

import org.satriaprayoga.jacs.Parameter;
import org.satriaprayoga.jacs.SoapParameter;

/**
 * CwmpSoapFactory
 * @author GILANG SATRIA PRAYOGA
 */
public abstract class CwmpSoapFactory {
	
	protected final Parameter createParameter(String name,String uri,String prefix){
		SoapParameter parameter=new CwmpSoapMessageStub(name, uri, prefix);
		return parameter;
	}
	
	protected Parameter createParameter(String name){
		return createParameter(name,null,null);
	}
	
	public abstract SoapParameter createSoapParameter(String name,String uri,String prefix);
	
	public SoapParameter createSoapParameter(String name){
		return createSoapParameter(name,null,null);
	}

}
