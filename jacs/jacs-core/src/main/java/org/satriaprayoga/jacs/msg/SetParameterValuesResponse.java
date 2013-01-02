package org.satriaprayoga.jacs.msg;

import org.satriaprayoga.jacs.Message;
import org.satriaprayoga.jacs.SoapBodyParameter;

/**
 * 
 * @author satriaprayoga
 *
 */
public class SetParameterValuesResponse extends Message{
	private static final long serialVersionUID = 5645504722332986246L;
	
	private int status;
	
	public SetParameterValuesResponse() {
		super("SetParameterValuesResponse");
	}

	@Override
	protected void configureParse(SoapBodyParameter messageBody) {
		status=Integer.valueOf(messageBody.getChildElement("Status").getValue());
	}
	
	public int getStatus() {
		return status;
	}

}
