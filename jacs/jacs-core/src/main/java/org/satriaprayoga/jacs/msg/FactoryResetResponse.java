/**
 * jacs-core
 * org.satriaprayoga.jacs.msg
 */
package org.satriaprayoga.jacs.msg;

import org.satriaprayoga.jacs.Message;
import org.satriaprayoga.jacs.SoapBodyParameter;
import org.satriaprayoga.jacs.cwmp.CwmpSoapFactory;

/**
 * FactoryResetResponse
 * @author GILANG SATRIA PRAYOGA
 */
public class FactoryResetResponse extends Message{
	private static final long serialVersionUID = 5766692077549415479L;
	
	public FactoryResetResponse() {
		super("FactoryResetResponse");
	}
	
	@Override
	protected void configureBody(SoapBodyParameter bodyParameter,
			CwmpSoapFactory cwmpSoapFactory) {
	}
	
	@Override
	protected void configureParse(SoapBodyParameter bodyParameter) {
	}

}
