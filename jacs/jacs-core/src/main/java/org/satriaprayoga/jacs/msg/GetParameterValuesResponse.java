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
import org.satriaprayoga.jacs.structure.ParameterValueStruct;

/**
 * GetParameterValuesResponse
 * @author GILANG SATRIA PRAYOGA
 */
public class GetParameterValuesResponse extends Message {
	private static final long serialVersionUID = 7361719121145539409L;
	
	private List<ParameterValueStruct> parameterValueStructs;
	
	public GetParameterValuesResponse() {
		super("GetParameterValuesResponse");
		parameterValueStructs=new ArrayList<ParameterValueStruct>();
	}
	
	@Override
	protected void configureParse(SoapBodyParameter bodyParameter) {
		SoapParameter argument=bodyParameter.getChildElement("ParameterList");
		Iterator<SoapParameter> iterator=argument.childIterator();
		while(iterator.hasNext()){
			SoapParameter paramStruct=iterator.next();
			SoapParameter name=paramStruct.getChildElement("Name");
			SoapParameter value=paramStruct.getChildElement("value");
			
			ParameterValueStruct struct=new ParameterValueStruct(name.getValue(), (value==null?"":value.getValue()));
			parameterValueStructs.add(struct);
		}
	}
	
	public List<ParameterValueStruct> getParameterValueStructs() {
		return parameterValueStructs;
	}


}
