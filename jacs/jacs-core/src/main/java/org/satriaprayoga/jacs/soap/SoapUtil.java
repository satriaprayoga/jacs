/**
 * jacs-core
 * org.satriaprayoga.jacs.soap
 */
package org.satriaprayoga.jacs.soap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.xml.soap.Name;
import javax.xml.soap.Node;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.soap.SOAPMessage;

/**
 * SoapUtil
 * @author GILANG SATRIA PRAYOGA
 */
public final class SoapUtil {
	
	public static String SOAP_ENV_PREFIX="SOAP-ENV";
	public static String SOAP_ENV_URN="http://schemas.xmlsoap.org/soap/envelope/";
	public static String SOAP_ENC_PREFIX="SOAP-ENC";
	public static String SOAP_ENC_URN="http://schemas.xmlsoap.org/soap/encoding/";
	public static String XSD_PREFIX="xsd";
	public static String XSD_URN="http://www.w3.org/2001/XMLSchema";
	public static String XSI_PREFIX="xsi";
	public static String XSI_URN="http://www.w3.org/2001/XMLSchema-instance";
	public static String CWMP_PREFIX="cwmp";
	public static String CWMP_URN="urn:dslforum-org:cwmp-1-2";
	
	private SoapUtil() {
	}
	
	public static SOAPBodyElement getRequest(SOAPMessage message)throws SOAPException{
		SOAPBodyElement bodyElement=null;
		@SuppressWarnings("unchecked")
		Iterator<SOAPElement> iterator=message.getSOAPBody().getChildElements();
		while(iterator.hasNext()){
			SOAPElement element=iterator.next();
			if(element.getNodeType()==Node.ELEMENT_NODE){
				bodyElement=(SOAPBodyElement)element;
			}
		}
		return bodyElement;
	}
	
	public static String getRequestName(SOAPMessage message)throws SOAPException{
		if(message.getSOAPBody().hasFault())
			return "Fault";
		return getRequest(message).getLocalName();
	}
	
	public static SOAPElement getRequestChildElement(SOAPElement request,String name) throws SOAPException{
		SOAPElement element=null;
		@SuppressWarnings("unchecked")
		Iterator<SOAPElement> iterator=request.getChildElements();
		while(iterator.hasNext()){
			SOAPElement e=iterator.next();
			String elementName=e.getLocalName();
			if(elementName!=null && elementName.equals(name)){
				element=e;
			}
		}
		return element;
	}
	
	@SuppressWarnings("unchecked")
	public static Iterator<SOAPElement> getRequestChildElements(SOAPElement request,String name)throws SOAPException{
		SOAPFactory soapFactory=SOAPFactory.newInstance();
		return request.getChildElements(soapFactory.createName(name));
	}
	
	public static SOAPElement getRequestChildElement(SOAPElement request,String name,String prefix,String uri)throws SOAPException{
		SOAPFactory soapFactory=SOAPFactory.newInstance();
		return (SOAPElement) request.getChildElements(soapFactory.createName(name, prefix, uri)).next();
	}
	
	public static SOAPElement getRequestChildElement(SOAPElement request, Name name) throws SOAPException {
		return (SOAPElement)request.getChildElements(name).next();
	}
	
	public static String getRequestElementValue(SOAPElement request,String name)throws SOAPException{
		return getRequestChildElement(request, name).getValue();
	}

	public static String getRequestElementValue(SOAPElement request, String name, String reference) throws SOAPException {
		String v = getRequestChildElement(request,name).getValue();
		return (v != null) ? v : reference;
	}

	public static String getRequestElementValue(SOAPElement request,Name name)throws SOAPException{
		return getRequestChildElement(request, name).getValue();
	}

	public static int getArrayCount (SOAPElement element) throws SOAPException{
		SOAPFactory soapFactory=SOAPFactory.newInstance();
		Name nameArray = soapFactory.createName("arrayType","soap-enc","http://schemas.xmlsoap.org/soap/encoding/");
		String attr = element.getAttributeValue(nameArray);
		if (attr == null) {
			return 0;
		}
		attr = attr.replaceAll(" ", "");
		int i = attr.indexOf('[');
		String c = attr.substring(i+1, attr.length() -1);
		
		return Integer.parseInt(c);
	}
	
	/**
	 * Get a CWMP Specific request element ("ParameterList")
	 * @param body
	 * @return
	 * @throws SOAPException
	 */
	public static Map<String, String> getParameterList(SOAPElement body)throws SOAPException{
		return getParameterList(body, "ParameterValueStruct", "Value");
	}

	protected static Map<String, String> getParameterList(SOAPElement body, String structName, String valueName)throws SOAPException{
		SOAPFactory soapFactory=SOAPFactory.newInstance();
		@SuppressWarnings("unchecked")
		Iterator<SOAPElement> elements = getRequestChildElement(body, "ParameterList").getChildElements(
				soapFactory.createName(structName));
		Name nameKey = soapFactory.createName("Name");
		Name nameValue = soapFactory.createName(valueName);
		Map<String, String> map=new HashMap<String, String>();
		while (elements.hasNext()) {
			SOAPElement param = (SOAPElement)elements.next();
			String key=getRequestElementValue(param, nameKey);
			String value=getRequestElementValue(param, nameValue);
			if (value==null) value = "";
			map.put(key, value);
		}
		return map;
	}


	/**
	 * Get {@link SOAPHeaderElement} of SOAP Message inside its {@link SOAPHeader} part
	 * @param header
	 * @param name
	 * @param prefix
	 * @param uri
	 * @return
	 * @throws SOAPException
	 */
	public static SOAPHeaderElement getHeaderElement(SOAPHeader header, String name,String prefix,String uri)throws SOAPException{
		SOAPFactory soapFactory=SOAPFactory.newInstance();
		@SuppressWarnings("unchecked")
		Iterator<SOAPElement> iterator= header.getChildElements(soapFactory.createName(name, prefix, uri));
		if(iterator==null || !iterator.hasNext())
			return null;
		return (SOAPHeaderElement) iterator.next();
	}
	
	public static String getHeaderElementValue(SOAPHeader header, String name,String prefix,String uri)throws SOAPException{
		SOAPHeaderElement element=getHeaderElement(header, name, prefix, uri);
		if(element==null)
			return null;
		return getHeaderElement(header, name, prefix, uri).getValue();
	}

}
