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
import org.satriaprayoga.jacs.structure.ParameterInfoStruct;

/**
 * GetParameterNamesResponse
 * @author GILANG SATRIA PRAYOGA
 */
public class GetParameterNamesResponse extends Message{
	
	private static final long serialVersionUID = -433284792940908829L;
	
	private List<ParameterInfoStruct> parameterInfoStructs;
	
	public GetParameterNamesResponse() {
		super("GetParameterNamesResponse");
		parameterInfoStructs=new ArrayList<ParameterInfoStruct>();
	}
	
	@Override
	protected void configureParse(SoapBodyParameter bodyParameter) {
		SoapParameter param=bodyParameter.getChildElement("ParameterList");
		Iterator<SoapParameter> iterator=param.childIterator();
		while(iterator.hasNext()){
			SoapParameter pis=iterator.next();
			String name=pis.getChildElement("Name").getValue();
			boolean writable=false;
			if(pis.getChildElement("Writable").getValue().trim().equals("1")){
				writable=true;
			}
			ParameterInfoStruct struct=new ParameterInfoStruct(name, writable);
			parameterInfoStructs.add(struct);
		}
	}
	
	public List<ParameterInfoStruct> getParameterInfoStructs() {
		return parameterInfoStructs;
	}

}
