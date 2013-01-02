package org.satriaprayoga.jacs.msg;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.satriaprayoga.jacs.Message;
import org.satriaprayoga.jacs.SoapBodyParameter;
import org.satriaprayoga.jacs.SoapParameter;
import org.satriaprayoga.jacs.structure.ParameterAttributeStruct;

/**
 * 
 * GetParameterAttributesResponse
 * @author GILANG SATRIA PRAYOGA
 */
public class GetParameterAttributesResponse extends Message {

	private static final long serialVersionUID = 8245748164632676733L;
	
	private List<ParameterAttributeStruct> parameterAttributeStructs;
	
	public GetParameterAttributesResponse() {
		super("GetParameterAttributeResponse");
		parameterAttributeStructs=new ArrayList<ParameterAttributeStruct>();
	}
	
	@Override
	protected void configureParse(SoapBodyParameter bodyParameter) {
		SoapParameter param=bodyParameter.getChildElement("ParameterList");
		Iterator<SoapParameter> iterator=param.childIterator();
		while(iterator.hasNext()){
			SoapParameter sp=iterator.next();
			String name=sp.getChildElement("Name").getValue();
			int notification=Integer.parseInt(sp.getChildElement("Notification").getValue());
			ParameterAttributeStruct struct=new ParameterAttributeStruct();
			struct.setName(name);
			struct.setNotification(notification);
			SoapParameter acl=sp.getChildElement("AccessList");
			Iterator<SoapParameter> iterator2=acl.childIterator();
			while(iterator2.hasNext()){
				String sacl=iterator2.next().getValue();
				struct.addAccessList(sacl);
			}
			parameterAttributeStructs.add(struct);
		}
	}
	
	
	public List<ParameterAttributeStruct> getParameterAttributeStructs() {
		return parameterAttributeStructs;
	}

}
