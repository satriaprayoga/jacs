/**
 * jacs-core
 * org.satriaprayoga.jacs.cwmp
 */
package org.satriaprayoga.jacs.cwmp;

import org.satriaprayoga.jacs.SoapParameter;

/**
 * SimpleCwmpSoapFactory
 * @author GILANG SATRIA PRAYOGA
 */
public class SimpleCwmpSoapFactory extends CwmpSoapFactory{
	
	private SimpleCwmpSoapFactory(){}
	
	private static CwmpSoapFactory cwmpSoapFactory=null;
	
	public static CwmpSoapFactory getInstance() {
		if(cwmpSoapFactory==null){
			cwmpSoapFactory=new SimpleCwmpSoapFactory();
		}
		return cwmpSoapFactory;
	}
	
	@Override
	public SoapParameter createSoapParameter(String name, String uri,
			String prefix) {
		return (SoapParameter)createParameter(name, uri, prefix);
	}

}
