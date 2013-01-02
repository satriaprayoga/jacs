/**
 * 
 */
package org.satriaprayoga.jacs.msg;

import org.satriaprayoga.jacs.Message;
import org.satriaprayoga.jacs.SoapBodyParameter;

/**
 * @author satriaprayoga
 *
 */
public class UploadResponse extends Message{

	private static final long serialVersionUID = 4948484986577034657L;

	private String startTime;
	private String completeTime;
	private int status;

	public UploadResponse() {
		super("UploadResponse");
	}

	@Override
	protected void configureParse(SoapBodyParameter SoapBodyParameter) {
		startTime=SoapBodyParameter.getChildElement("StartTime").getValue();
		completeTime=SoapBodyParameter.getChildElement("CompleteTime").getValue();
		status=Integer.parseInt(SoapBodyParameter.getChildElement("Status").getValue());
	}

	public String getStartTime() {
		return startTime;
	}

	public String getCompleteTime() {
		return completeTime;
	}

	public int getStatus() {
		return status;
	}
	
	

}
