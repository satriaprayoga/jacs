/**
 * jacs-core
 * org.satriaprayoga.jacs.msg
 */
package org.satriaprayoga.jacs.msg;

import org.satriaprayoga.jacs.Message;
import org.satriaprayoga.jacs.SoapBodyParameter;

/**
 * DeleteObjectResponse
 * @author GILANG SATRIA PRAYOGA
 */
public class DeleteObjectResponse extends Message{

	private static final long serialVersionUID = -3188264035083508856L;
	
	private int status;
	
	public DeleteObjectResponse() {
		super("DeleteObjectResponse");
	}
	
	@Override
	protected void configureParse(SoapBodyParameter bodyParameter) {
		status=Integer.parseInt(bodyParameter.getChildElement("Status").getValue());
	}
	
	public int getStatus() {
		return status;
	}
}
