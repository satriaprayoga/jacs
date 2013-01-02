/**
 * jacs-core
 * org.satriaprayoga.jacs.msg
 */
package org.satriaprayoga.jacs.msg;

import org.satriaprayoga.jacs.Message;
import org.satriaprayoga.jacs.SoapBodyParameter;

/**
 * AddObjectResponse
 * @author GILANG SATRIA PRAYOGA
 */
public class AddObjectResponse extends Message{
	
	private static final long serialVersionUID = 452928085661801647L;
	
	private int status;
	private int instanceNumber;
	
	public AddObjectResponse() {
		super("AddObjectResponse");
	}

	@Override
	protected void configureParse(SoapBodyParameter bodyParameter) {
		instanceNumber=Integer.parseInt(bodyParameter.getChildElement("InstanceValue").getValue());
		status=Integer.parseInt(bodyParameter.getChildElement("Status").getValue());
	}
	
	public int getStatus() {
		return status;
	}
	
	public int getInstanceNumber() {
		return instanceNumber;
	}

}
