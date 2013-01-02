/**
 * 
 */
package org.satriaprayoga.jacs.msg;

import java.util.ArrayList;
import java.util.List;

import org.satriaprayoga.jacs.Message;
import org.satriaprayoga.jacs.SoapBodyParameter;
import org.satriaprayoga.jacs.SoapParameter;
import org.satriaprayoga.jacs.cwmp.CwmpSoapFactory;
import org.satriaprayoga.jacs.structure.SetParameterAttributeStruct;


/**
 * @author satriaprayoga
 *
 */
public class SetParameterAttributes extends Message{

	private static final long serialVersionUID = -1788299451507503606L;
	
	private List<SetParameterAttributeStruct> parameterAttributeStructs;
	
	public SetParameterAttributes() {
		super("SetParameterAttributes");
		parameterAttributeStructs=new ArrayList<SetParameterAttributeStruct>();
	}

	@Override
	protected void configureBody(SoapBodyParameter bodyPart,
			CwmpSoapFactory CwmpSoapFactory) {
		SoapParameter argument=bodyPart.addSoapParameter(CwmpSoapFactory.createSoapParameter("ParameterList"));
		argument.setAttribute(SOAP_ARRAY_TYPE, "cwmp:SetParameterAttributesStruct["+parameterAttributeStructs.size()+"]");
		for(SetParameterAttributeStruct struct:parameterAttributeStructs){
			SoapParameter structArg=argument.addSoapParameter(CwmpSoapFactory.createSoapParameter("SetParameterAttributesStruct"));
			structArg.addSoapParameter(CwmpSoapFactory.createSoapParameter("Name")).setValue(struct.getName());
			structArg.addSoapParameter(CwmpSoapFactory.createSoapParameter("NotificationChange")).setValue(struct.isNotificationChange()?"1":"0");
			structArg.addSoapParameter(CwmpSoapFactory.createSoapParameter("Notification")).setValue(String.valueOf(struct.getNotification()));
			structArg.addSoapParameter(CwmpSoapFactory.createSoapParameter("AccessListChange")).setValue(struct.isAccessListChange()?"1":"0");
			SoapParameter acl=argument.addSoapParameter(CwmpSoapFactory.createSoapParameter("AccessList"));
			List<String> acls=struct.getAccessList();
			acl.setAttribute(XSD_STRING, "xsd:string["+acls.size()+"]");
			for(String s:acls){
				acl.addSoapParameter(CwmpSoapFactory.createSoapParameter("string")).setValue(s);
				acl.setAttribute(XSI_TYPE, XSD_STRING);
			}
		}
	}

	public void addParameterAttributeStruct(SetParameterAttributeStruct struct){
		parameterAttributeStructs.add(struct);
	}

}
