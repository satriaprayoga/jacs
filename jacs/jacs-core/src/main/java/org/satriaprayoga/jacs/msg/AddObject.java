package org.satriaprayoga.jacs.msg;

import org.satriaprayoga.jacs.Message;
import org.satriaprayoga.jacs.SoapBodyParameter;
import org.satriaprayoga.jacs.cwmp.CwmpSoapFactory;

/**
 * 
 * AddObject
 * @author GILANG SATRIA PRAYOGA
 */
public class AddObject extends Message{
	private static final long serialVersionUID = 7135896082847025225L;
	
	private String parameterKey;
	private String objectName;
	
	public AddObject() {
		super("AddObject");
	}
	
	public AddObject(String parameterKey,String objectName) {
		this();
		this.parameterKey=parameterKey;
		this.objectName=objectName;
	}

	@Override
	protected void configureBody(SoapBodyParameter bodyParameter,
			CwmpSoapFactory cwmpSoapFactory) {
		bodyParameter.addSoapParameter(cwmpSoapFactory.createSoapParameter("ParameterKey").setValue(parameterKey));
		bodyParameter.addSoapParameter(cwmpSoapFactory.createSoapParameter("ObjectName").setValue(objectName));
	}

	
	public String getObjectName() {
		return objectName;
	}
	
	public String getParameterKey() {
		return parameterKey;
	}


}
