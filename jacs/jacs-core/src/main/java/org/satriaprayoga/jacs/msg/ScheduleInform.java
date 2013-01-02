/**
 * jacs-core
 * org.satriaprayoga.jacs.msg
 */
package org.satriaprayoga.jacs.msg;

import org.satriaprayoga.jacs.Message;
import org.satriaprayoga.jacs.SoapBodyParameter;
import org.satriaprayoga.jacs.cwmp.CwmpSoapFactory;

/**
 * ScheduleInform
 * @author GILANG SATRIA PRAYOGA
 */
public class ScheduleInform extends Message{
	private static final long serialVersionUID = -2256468069759899692L;
	
	private String commandKey;
	private int delaySeconds;

	public ScheduleInform() {
		super("ScheduleInform");
	}
	
	public ScheduleInform(String commandKey,int delaySeconds) {
		this();
		this.commandKey=commandKey;
		this.delaySeconds=delaySeconds;
	}
	
	@Override
	protected void configureBody(SoapBodyParameter bodyParameter,
			CwmpSoapFactory cwmpSoapFactory) {
		bodyParameter.addSoapParameter(cwmpSoapFactory.createSoapParameter("CommandKey")).setValue(commandKey);
		bodyParameter.addSoapParameter(cwmpSoapFactory.createSoapParameter("DelaySeconds")).setValue(String.valueOf(delaySeconds));
	}
	
	public String getCommandKey() {
		return commandKey;
	}
	
	public int getDelaySeconds() {
		return delaySeconds;
	}

}
