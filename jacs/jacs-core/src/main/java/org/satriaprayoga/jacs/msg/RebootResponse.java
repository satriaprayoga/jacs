/**
 * jacs-core
 * org.satriaprayoga.jacs.msg
 */
package org.satriaprayoga.jacs.msg;

import org.satriaprayoga.jacs.Message;
import org.satriaprayoga.jacs.SoapBodyParameter;
import org.satriaprayoga.jacs.cwmp.CwmpSoapFactory;

/**
 * RebootResponse
 * @author GILANG SATRIA PRAYOGA
 */
public class RebootResponse extends Message{
	private static final long serialVersionUID = -5318087535154567082L;
	
	public RebootResponse() {
		super("RebootResponse");
	}
	
	@Override
	protected void configureBody(SoapBodyParameter bodyParameter,
			CwmpSoapFactory cwmpSoapFactory) {
	}
	
	@Override
	protected void configureParse(SoapBodyParameter bodyParameter) {
	}

}
