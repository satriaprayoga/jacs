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
 * GetRPCMethodsResponse
 * @author GILANG SATRIA PRAYOGA
 */
public class GetRPCMethodsResponse extends Message{
	private static final long serialVersionUID = -5259772125432825613L;
	
	private List<String> methods;
	
	public GetRPCMethodsResponse() {
		super("GetRPCMethodsResponse");
		methods=new ArrayList<String>();
		methods.add("Inform");
		methods.add("GetRPCMethods");
		methods.add("TransferComplete");
	}
	
	@Override
	protected void configureBody(SoapBodyParameter bodyParameter,
			CwmpSoapFactory cwmpSoapFactory) {
		SoapParameter argument=bodyParameter.addSoapParameter(cwmpSoapFactory.createSoapParameter("MethodList"));
		argument.setAttribute(SOAP_ARRAY_TYPE, XSD_STRING+"["+methods.size()+"]");
		for(String s:methods){
			argument.addSoapParameter(cwmpSoapFactory.createSoapParameter("string")).setValue(s);
		}
	}
	
	@Override
	protected void configureParse(SoapBodyParameter bodyParameter) {
		SoapParameter argument=bodyParameter.getChildElement("MethodList");
		Iterator<SoapParameter> args=argument.childIterator();
		methods=new ArrayList<String>();
		while(args.hasNext()){
			SoapParameter a=args.next();
			methods.add(a.getValue());
		}
	}
	
	public List<String> getMethods() {
		return methods;
	}

}
