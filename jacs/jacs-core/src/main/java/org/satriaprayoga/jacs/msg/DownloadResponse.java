/**
 * jacs-core
 * org.satriaprayoga.jacs.msg
 */
package org.satriaprayoga.jacs.msg;

import org.satriaprayoga.jacs.Message;
import org.satriaprayoga.jacs.SoapBodyParameter;

/**
 * DownloadResponse
 * @author GILANG SATRIA PRAYOGA
 */
public class DownloadResponse extends Message{
	private static final long serialVersionUID = 6789775058418919590L;
	
	private String startTime;
	private String completeTime;
	private int status;
	
	public DownloadResponse() {
		super("DownloadResponse");
	}
	
	@Override
	protected void configureParse(SoapBodyParameter bodyParameter) {
		startTime=bodyParameter.getChildElement("StartTime").getValue();
		completeTime=bodyParameter.getChildElement("CompleteTime").getValue();
		status=Integer.parseInt(bodyParameter.getChildElement("Status").getValue());
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
