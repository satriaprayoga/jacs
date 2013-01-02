/**
 * jacs-core
 * org.satriaprayoga.jacs.msg
 */
package org.satriaprayoga.jacs.msg;

import org.satriaprayoga.jacs.Message;
import org.satriaprayoga.jacs.SoapBodyParameter;
import org.satriaprayoga.jacs.cwmp.CwmpSoapFactory;

/**
 * AutonomousTransferCompleteResponse
 * @author GILANG SATRIA PRAYOGA
 */
public class AutonomousTransferCompleteResponse extends Message{
	private static final long serialVersionUID = -1510935744296728673L;
	
	public AutonomousTransferCompleteResponse() {
		super("AutonomousTransferCompleteResponse");
	}
	
	@Override
	protected void configureBody(SoapBodyParameter bodyParameter,
			CwmpSoapFactory cwmpSoapFactory) {
	}

}
