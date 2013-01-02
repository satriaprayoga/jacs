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
import org.satriaprayoga.jacs.structure.ParameterValueStruct;


/**
 * @author satriaprayoga
 *
 */
public class SetParameterValues extends Message{
	private static final long serialVersionUID = -5095995628910787559L;
	
	private List<ParameterValueStruct> parameterValueStructs;

	public SetParameterValues() {
		super("SetParameterValues");
		parameterValueStructs=new ArrayList<ParameterValueStruct>();
	}

	@Override
	protected void configureBody(SoapBodyParameter bodyPart,
			CwmpSoapFactory CwmpSoapFactory) {
		SoapParameter argument=bodyPart.addSoapParameter(CwmpSoapFactory.createSoapParameter("ParameterList"));
		argument.setAttribute(SOAP_ARRAY_TYPE, "cwmp:ParameterValueStruct["+parameterValueStructs.size()+"]");
		for(ParameterValueStruct pvs:parameterValueStructs){
			SoapParameter arg=argument.addSoapParameter(CwmpSoapFactory.createSoapParameter("ParameterValueStruct"));
			arg.addSoapParameter(CwmpSoapFactory.createSoapParameter("Name")).setValue(pvs.getName());
			arg.addSoapParameter(CwmpSoapFactory.createSoapParameter("Value")).setValue(pvs.getValue());
		}
		bodyPart.addSoapParameter(CwmpSoapFactory.createSoapParameter("ParameterKey")).setValue("key1");
		
	}
	
	public void addParameterValueStruct(ParameterValueStruct struct){
		parameterValueStructs.add(struct);
	}

}
