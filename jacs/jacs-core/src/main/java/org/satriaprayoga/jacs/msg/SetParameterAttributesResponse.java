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
public class SetParameterAttributesResponse extends Message{
	private static final long serialVersionUID = 242138233469359501L;
	
	public SetParameterAttributesResponse() {
		super("SetParameterAttributesResponse");
	}
	


	@Override
	protected void configureBody(SoapBodyParameter bodyPart,
			CwmpSoapFactory CwmpSoapFactory) {
	}

	@Override
	protected void configureParse(SoapBodyParameter SoapBodyParameter) {
	}

}
