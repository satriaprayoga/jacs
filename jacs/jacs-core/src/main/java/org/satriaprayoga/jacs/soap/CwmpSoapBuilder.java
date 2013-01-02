/**
 * jacs-core
 * org.satriaprayoga.jacs.soap
 */
package org.satriaprayoga.jacs.soap;

import java.util.Iterator;
import java.util.Map;

import javax.xml.soap.Detail;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPFault;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.soap.SOAPMessage;

import org.satriaprayoga.jacs.CwmpMessageException;
import org.satriaprayoga.jacs.Message;
import org.satriaprayoga.jacs.SoapBodyParameter;
import org.satriaprayoga.jacs.SoapEnvelopeParameter;
import org.satriaprayoga.jacs.SoapHeaderParameter;
import org.satriaprayoga.jacs.SoapParameter;
import org.satriaprayoga.jacs.msg.Fault;

/**
 * CwmpSoapBuilder
 * @author GILANG SATRIA PRAYOGA
 */
public class CwmpSoapBuilder implements SoapBuilder{
	
	private static final String DEFAULT_FAULT_STRING="CWMP Fault";
	private static final String DEFAULT_FAULT_CODE="ACS Server";

	@Override
	public SOAPMessage build(Message message) throws CwmpMessageException {
		SOAPMessage soapMessage=null;
		try {
			MessageFactory messageFactory=MessageFactory.newInstance();
			SOAPFactory soapFactory=SOAPFactory.newInstance();
			soapMessage=messageFactory.createMessage();
			message.configBuild();
			
			buildSoapEnvelope(soapMessage.getSOAPPart().getEnvelope(), message.getEnvelopeParameter());
			buildSoapHeader(soapMessage.getSOAPHeader(), message.getHeaderParameter(), soapFactory);
			if((message.getBodyParameter().hasFault()) && (message instanceof Fault)){
				buildSoapFault(soapMessage.getSOAPBody().addFault(), message.getBodyParameter(), soapFactory);
			}else{
				buildSoapBody(soapMessage.getSOAPBody(), message.getBodyParameter(), soapFactory);
			}
		} catch (SOAPException e) {
			e.printStackTrace();
		}
		return soapMessage;
	}
	
	protected final void buildSoapEnvelope(SOAPEnvelope envelope,SoapEnvelopeParameter parameter) throws SOAPException{
		Map<String, String> nsMap=parameter.getNamespaceMap();
		Iterator<String> iter=nsMap.keySet().iterator();
		while(iter.hasNext()){
			String prefix=iter.next();
			envelope.addNamespaceDeclaration(prefix, parameter.getNamespaceValue(prefix));
		}
	}
	
	protected final void buildSoapHeader(SOAPHeader soapHeader,SoapHeaderParameter parameter,SOAPFactory soapFactory) throws SOAPException{
		Iterator<SoapParameter> iter=parameter.childIterator();
		while(iter.hasNext()){
			SoapParameter param=iter.next();
			SOAPHeaderElement headerElement=soapHeader.addHeaderElement(soapFactory.createName(param.getName(), 
					param.getPrefix(), param.getUri()));
			String attributeParam=param.getAttributeName();
			if(attributeParam!=null){
				headerElement.setAttribute(attributeParam, param.getAttributeValue(attributeParam));
			}
			String value=param.getValue();
			if(value!=null){
				headerElement.setValue(value);
			}
		}
	}
	
	protected final void buildSoapBody(SOAPBody soapBody,SoapBodyParameter parameter,SOAPFactory factory) throws SOAPException{
		SOAPBodyElement bodyElement=soapBody.addBodyElement(
				factory.createName(parameter.getName(), SoapUtil.CWMP_PREFIX, SoapUtil.CWMP_URN));
		Iterator<SoapParameter> iter=parameter.childIterator();
		while(iter.hasNext()){
			buildSoapElement(bodyElement, iter.next(), factory);
		}
	}
	
	protected final void buildSoapFault(SOAPFault soapFault,SoapParameter parameter,SOAPFactory factory) throws SOAPException{
		soapFault.setFaultCode(DEFAULT_FAULT_CODE);
		soapFault.setFaultString(DEFAULT_FAULT_STRING);
		Detail faultDetail=soapFault.addDetail();
		buildSoapElement(faultDetail, parameter, factory);
	}
	
	private final void buildSoapElement(SOAPElement element,SoapParameter parameter,SOAPFactory factory) throws SOAPException{
		SOAPElement el=null;
		if(parameter.getPrefix()!=null){
			el=element.addChildElement(factory.createName(parameter.getName(), 
					parameter.getPrefix(), parameter.getUri()));
		}else{
			el=element.addChildElement(parameter.getName());
		}
		String attributeName=parameter.getAttributeName();
		if(attributeName!=null){
			el.setAttribute(attributeName, parameter.getAttributeValue(attributeName));
		}
		if(parameter.getValue()!=null){
			el.setValue(parameter.getValue());
		}
		if(parameter.childIterator().hasNext()){
			Iterator<SoapParameter> iter=parameter.childIterator();
			while(iter.hasNext()){
				buildSoapElement(el, iter.next(), factory);
			}
		}
	}

}
