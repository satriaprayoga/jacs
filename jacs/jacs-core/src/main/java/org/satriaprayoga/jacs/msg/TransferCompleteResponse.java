/**
 * 
 */
package org.satriaprayoga.jacs.msg;

import org.satriaprayoga.jacs.Message;
import org.satriaprayoga.jacs.SoapBodyParameter;
import org.satriaprayoga.jacs.cwmp.CwmpSoapFactory;

/**
 * @author satriaprayoga
 *
 */
public class TransferCompleteResponse extends Message{

	private static final long serialVersionUID = -5617584079717915222L;

	public TransferCompleteResponse() {
		super("TransferCompleteResponse");
	}
	
	@Override
	protected void configureBody(SoapBodyParameter bodyPart,
			CwmpSoapFactory cwmpSoapFactory) {
		
	}

	@Override
	protected void configureParse(SoapBodyParameter SoapBodyParameter) {
	
	}

}
