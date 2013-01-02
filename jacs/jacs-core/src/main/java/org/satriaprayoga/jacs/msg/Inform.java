/**
 * jacs-core
 * org.satriaprayoga.jacs.msg
 */
package org.satriaprayoga.jacs.msg;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.satriaprayoga.jacs.Message;
import org.satriaprayoga.jacs.SoapBodyParameter;
import org.satriaprayoga.jacs.SoapParameter;
import org.satriaprayoga.jacs.structure.DeviceIdStruct;
import org.satriaprayoga.jacs.structure.EventStruct;
import org.satriaprayoga.jacs.structure.ParameterValueStruct;

/**
 * Inform
 * @author GILANG SATRIA PRAYOGA
 */
public class Inform extends Message{
	private static final long serialVersionUID = -8655051436051010650L;
	

	private List<EventStruct> eventStructs;
	private List<ParameterValueStruct> parameterValueStructs;
	private DeviceIdStruct deviceIdStruct;
	
	private int maxEnvelopes=1;
	private String currentTime;
	private int retryCount;
	
	public Inform() {
		super("Inform");
		eventStructs=new ArrayList<EventStruct>();
		parameterValueStructs=new ArrayList<ParameterValueStruct>();
	}
	
	@Override
	protected void configureParse(SoapBodyParameter bodyParameter) {
		configureDeviceId(bodyParameter);
		configureEvent(bodyParameter);
		maxEnvelopes=Integer.parseInt(bodyParameter.getChildElement("MaxEnvelopes").getValue());
		currentTime=bodyParameter.getChildElement("CurrentTime").getValue();
		retryCount=Integer.parseInt(bodyParameter.getChildElement("RetryCount").getValue());
		configureParameterValueStruct(bodyParameter);
	}
	
	private void configureDeviceId(SoapParameter argument){
		SoapParameter deviceArg=argument.getChildElement("DeviceId");
		String manufacturer=deviceArg.getChildElement("Manufacturer").getValue();
		String oui=deviceArg.getChildElement("OUI").getValue();
		String productClass=deviceArg.getChildElement("ProductClass").getValue();
		String serialNumber=deviceArg.getChildElement("SerialNumber").getValue();
		deviceIdStruct=new DeviceIdStruct(manufacturer, oui, productClass, serialNumber);
	}
	
	private void configureEvent(SoapParameter argument){
		SoapParameter eventArg=argument.getChildElement("Event");
		Iterator<SoapParameter> iterator=eventArg.childIterator();
		while(iterator.hasNext()){
			SoapParameter event=iterator.next();
			String eventCode=event.getChildElement("EventCode").getValue();
			String commandKey=event.getChildElement("CommandKey").getValue();
			EventStruct eventStruct=new EventStruct(eventCode, commandKey);
			eventStructs.add(eventStruct);
		}
	}
	
	private void configureParameterValueStruct(SoapParameter arg){
		SoapParameter argument=arg.getChildElement("ParameterList");
		Iterator<SoapParameter> iterator=argument.childIterator();
		while(iterator.hasNext()){
			SoapParameter paramStruct=iterator.next();
			SoapParameter name=paramStruct.getChildElement("Name");
			SoapParameter value=paramStruct.getChildElement("value");
			
			ParameterValueStruct struct=new ParameterValueStruct(name.getValue(), (value==null?"":value.getValue()));
			parameterValueStructs.add(struct);
		}
	}

	public List<EventStruct> getEventStructs() {
		return eventStructs;
	}

	public List<ParameterValueStruct> getParameterValueStructs() {
		return parameterValueStructs;
	}

	public DeviceIdStruct getDeviceIdStruct() {
		return deviceIdStruct;
	}

	public int getMaxEnvelopes() {
		return maxEnvelopes;
	}

	public String getCurrentTime() {
		return currentTime;
	}

	public int getRetryCount() {
		return retryCount;
	}

}
