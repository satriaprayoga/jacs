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
import org.satriaprayoga.jacs.cwmp.CwmpSoapFactory;

/**
 * GetParameterValues
 * @author GILANG SATRIA PRAYOGA
 */
public class GetParameterValues extends Message{
	private static final long serialVersionUID = -7857568297138506751L;
	
	private List<String> parameterNames;

	public GetParameterValues() {
		super("GetParameterValues");
		parameterNames=new ArrayList<String>();
	}
	
	@Override
	protected void configureBody(SoapBodyParameter bodyParameter,
			CwmpSoapFactory cwmpSoapFactory) {
		SoapParameter paramArg=bodyParameter.addSoapParameter(cwmpSoapFactory.createSoapParameter("ParameterNames"));
		paramArg.setAttribute(SOAP_ARRAY_TYPE, "xsd:string["+parameterNames.size()+"]");
		for(String s:parameterNames){
			SoapParameter param=paramArg.addSoapParameter(cwmpSoapFactory.createSoapParameter("string"));
			param.setValue(s);
		}
	}
	
	@Override
	protected void configureParse(SoapBodyParameter bodyParameter) {
		SoapParameter param=bodyParameter.getChildElement("ParameterNames");
		Iterator<SoapParameter> iterator=param.childIterator();
		parameterNames=new ArrayList<String>();
		while(iterator.hasNext()){
			SoapParameter p=iterator.next();
			parameterNames.add(p.getValue());
		}
	}
	
	public List<String> getParameterNames() {
		return parameterNames;
	}
	
	public void addParameterNames(String parameterName){
		parameterNames.add(parameterName);
	}

}
