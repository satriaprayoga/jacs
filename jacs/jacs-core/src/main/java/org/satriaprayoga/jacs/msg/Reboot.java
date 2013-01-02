package org.satriaprayoga.jacs.msg;

import org.satriaprayoga.jacs.Message;
import org.satriaprayoga.jacs.SoapBodyParameter;
import org.satriaprayoga.jacs.cwmp.CwmpSoapFactory;

/**
 * 
 * Reboot
 * @author GILANG SATRIA PRAYOGA
 */
public class Reboot extends Message{
	private static final long serialVersionUID = -7575436179724733377L;
	
	private String commandKey;
	
	public Reboot() {
		super("Reboot");
	}
	
	public Reboot(String commandKey){
		this();
		this.commandKey=commandKey;
	}
	
	@Override
	protected void configureBody(SoapBodyParameter bodyParameter,
			CwmpSoapFactory cwmpSoapFactory) {
		bodyParameter.addSoapParameter(cwmpSoapFactory.createSoapParameter("CommandKey")).setValue(commandKey);
	}

	public String getCommandKey() {
		return commandKey;
	}

}
