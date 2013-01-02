/**
 * jacs-core
 * org.satriaprayoga.jacs.msg
 */
package org.satriaprayoga.jacs.msg;

import java.util.ArrayList;
import java.util.List;

import org.satriaprayoga.jacs.Message;
import org.satriaprayoga.jacs.SoapBodyParameter;
import org.satriaprayoga.jacs.SoapParameter;
import org.satriaprayoga.jacs.cwmp.CwmpSoapFactory;

/**
 * GetParameterAttributes
 * @author GILANG SATRIA PRAYOGA
 */
public class GetParameterAttributes extends Message{
	private static final long serialVersionUID = -8967273117629327770L;
	
	private List<String> parameterNames;
	
	public GetParameterAttributes() {
		super("GetParameterAttributes");
		parameterNames=new ArrayList<String>();
	}
	
	@Override
	protected void configureBody(SoapBodyParameter bodyParameter,
			CwmpSoapFactory cwmpSoapFactory) {
		SoapParameter param=bodyParameter.addSoapParameter(cwmpSoapFactory.createSoapParameter("ParameterNames"));
		param.setAttribute(SOAP_ARRAY_TYPE, "xsd:string["+parameterNames.size()+"]");
		for(String s:parameterNames){
			param.addSoapParameter(cwmpSoapFactory.createSoapParameter("string").setValue(s));
			
		}
	}
	
	public List<String> getParameterNames() {
		return parameterNames;
	}
	
	public void addParameterName(String param){
		parameterNames.add(param);
	}

}
