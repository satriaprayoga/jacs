/**
 * jacs-core
 * org.satriaprayoga.jacs.cwmp
 */
package org.satriaprayoga.jacs.cwmp;

import org.satriaprayoga.jacs.SoapBodyParameter;

/**
 * CwmpBody
 * @author GILANG SATRIA PRAYOGA
 */
public class CwmpSoapBody extends CwmpSoapMessageStub implements SoapBodyParameter{
	
	public CwmpSoapBody(String name) {
		super(name,null,null);
	}
	
	public CwmpSoapBody(String name, String uri, String prefix) {
		super(name, uri, prefix);
	}

	@Override
	public boolean hasFault() {
		return getName().equals("Fault");
	}

}
