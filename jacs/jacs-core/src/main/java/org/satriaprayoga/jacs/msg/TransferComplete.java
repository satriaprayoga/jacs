/**
 * 
 */
package org.satriaprayoga.jacs.msg;

import org.satriaprayoga.jacs.Message;
import org.satriaprayoga.jacs.SoapBodyParameter;
import org.satriaprayoga.jacs.SoapParameter;

/**
 * @author satriaprayoga
 *
 */
public class TransferComplete extends Message{

	private static final long serialVersionUID = -6696457564086003088L;
	
	private String commandKey;
	private String startTime;
	private String completeTime;
	private String faultCode;
	private String faultString;
	
	public TransferComplete() {
		super("TransferComplete");
	}

	@Override
	protected void configureParse(SoapBodyParameter messageBody) {
		commandKey=messageBody.getChildElement("CommandKey").getValue();
		startTime=messageBody.getChildElement("StartTime").getValue();
		completeTime=messageBody.getChildElement("CompleteTime").getValue();
		SoapParameter faultArg=messageBody.getChildElement("FaultStruct");
		if(faultArg!=null){
			faultCode=faultArg.getChildElement("FaultCode").getValue();
			faultString=faultArg.getChildElement("FaultString").getValue();
		}else{
			faultCode="0";
			faultString=null;
		}
	}

	public String getCommandKey() {
		return commandKey;
	}

	public void setCommandKey(String commandKey) {
		this.commandKey = commandKey;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getCompleteTime() {
		return completeTime;
	}

	public void setCompleteTime(String completeTime) {
		this.completeTime = completeTime;
	}

	public String getFaultCode() {
		return faultCode;
	}

	public void setFaultCode(String faultCode) {
		this.faultCode = faultCode;
	}

	public String getFaultString() {
		return faultString;
	}

	public void setFaultString(String faultString) {
		this.faultString = faultString;
	}
	
	

}
