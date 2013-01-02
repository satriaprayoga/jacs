/**
 * jacs-core
 * org.satriaprayoga.jacs.msg
 */
package org.satriaprayoga.jacs.msg;

import org.satriaprayoga.jacs.Message;
import org.satriaprayoga.jacs.SoapBodyParameter;
import org.satriaprayoga.jacs.cwmp.CwmpSoapFactory;

/**
 * GetRPCMethods
 * @author GILANG SATRIA PRAYOGA
 */
public class GetRPCMethods extends Message{
	private static final long serialVersionUID = -8569634628101889169L;
	
	public GetRPCMethods() {
		super("GetRPCMethods");
	}
	
	@Override
	protected void configureParse(SoapBodyParameter bodyParameter) {
	}
	
	@Override
	protected void configureBody(SoapBodyParameter bodyParameter,
			CwmpSoapFactory cwmpSoapFactory) {
	}

}
