/**
 * jacs-core
 * org.satriaprayoga.jacs.msg
 */
package org.satriaprayoga.jacs.msg;

import org.satriaprayoga.jacs.Message;
import org.satriaprayoga.jacs.SoapBodyParameter;
import org.satriaprayoga.jacs.cwmp.CwmpSoapFactory;

/**
 * DeleteObject
 * @author GILANG SATRIA PRAYOGA
 */
public class DeleteObject extends Message{
	private static final long serialVersionUID = -3177482896800084771L;
	
	private String parameterKey;
	private String objectName;
	
	public DeleteObject(String parameterKey,String objectName){
		super("DeleteObject");
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
	
	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}
	
	public void setParameterKey(String parameterKey) {
		this.parameterKey = parameterKey;
	}

}
