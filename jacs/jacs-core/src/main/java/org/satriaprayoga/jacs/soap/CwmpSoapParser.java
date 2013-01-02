/**
 * jacs-core
 * org.satriaprayoga.jacs.soap
 */
package org.satriaprayoga.jacs.soap;

import java.util.Iterator;
import java.util.NoSuchElementException;

import javax.xml.namespace.QName;
import javax.xml.soap.Detail;
import javax.xml.soap.DetailEntry;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFault;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;

import org.satriaprayoga.jacs.Message;
import org.satriaprayoga.jacs.SoapBodyParameter;
import org.satriaprayoga.jacs.SoapEnvelopeParameter;
import org.satriaprayoga.jacs.SoapHeaderParameter;
import org.satriaprayoga.jacs.SoapParameter;
import org.satriaprayoga.jacs.cwmp.CwmpSoapFactory;
import org.satriaprayoga.jacs.cwmp.SimpleCwmpSoapFactory;
import org.satriaprayoga.jacs.msg.Fault;
import org.w3c.dom.Node;

/**
 * CwmpSoapParser
 * @author GILANG SATRIA PRAYOGA
 */
public class CwmpSoapParser implements SoapParser{

	@Override
	public Message parse(SOAPMessage soapMessage)
			throws SoapMessageParserException {
		Message message=null;
		try{
			if(soapMessage.getSOAPBody().hasFault()){
				return parseFault(soapMessage);
			}
			
			String name=SoapUtil.getRequestName(soapMessage);
			if(name==null){
				throw new NoSuchElementException("name not found");
			}
			message=(Message) Class.forName("org.satriaprayoga.jacs.msg."+name).newInstance();
			parseMessageEnvelope(soapMessage, message);
			parseMessageHeader(soapMessage, message);
			parseMessageBody(soapMessage, message);
			message.configParse();
		}catch(SOAPException se){
			
		}catch(Exception e){
			
		}
		return message;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected Fault parseFault(SOAPMessage soapMessage){
		Fault fault=null;
		String faultCode;
		String faultString;
		Detail detail;
		try{
			SOAPFault soapFault=soapMessage.getSOAPBody().getFault();
			detail=soapFault.getDetail();
			if(detail==null)
			{
				faultCode=SoapUtil.getRequestElementValue(soapFault, "faultcode");
				faultString=SoapUtil.getRequestElementValue(soapFault, "faultstring");
				fault=new Fault(faultCode, faultString);
			}else{
				Iterator<DetailEntry> iterator=detail.getDetailEntries();
				if(iterator.hasNext()){
					SOAPElement element=SoapUtil.getRequestChildElement(detail, "Fault");
					SOAPElement fc=SoapUtil.getRequestChildElement(element, "FaultCode");
					faultCode=fc.getValue();
					SOAPElement fs=SoapUtil.getRequestChildElement(element, "FaultString");
					faultString=fs.getValue();
					fault=new Fault(faultCode, faultString);
					Iterator paramFaults=element.getChildElements(new QName("SetParameterValuesFault"));
					while(paramFaults.hasNext()){
						SOAPElement pfe=(SOAPElement)paramFaults.next();
						fault.addParameterFault(SoapUtil.getRequestElementValue(pfe, "ParameterName"), 
								SoapUtil.getRequestElementValue(pfe, "FaultCode"), 
								SoapUtil.getRequestElementValue(pfe, "FaultString"));
					}
				}
			}
			
		}catch(Exception e){
			
		}
		return fault;
	}
	
	@SuppressWarnings("unchecked")
	protected SoapEnvelopeParameter parseMessageEnvelope(SOAPMessage soapMessage,Message message)throws SOAPException{
		SoapEnvelopeParameter envelope=message.getEnvelopeParameter();
		SOAPEnvelope soapEnvelope=soapMessage.getSOAPPart().getEnvelope();
		Iterator<String> iterator=soapEnvelope.getNamespacePrefixes();
		while(iterator.hasNext()){
			String prefix=iterator.next();
			String uri=soapEnvelope.getNamespaceURI(prefix);
			if(uri!=null && !(uri.trim().isEmpty())){
				envelope.addNamespace(prefix, uri);
				if(uri.startsWith("urn:dslforum-org:cwmp-")){
					message.setUri(uri);
				}
			}
		}
		return envelope;
	}
	
	protected SoapHeaderParameter parseMessageHeader(SOAPMessage soapMessage,Message message)throws SOAPException{
		SoapHeaderParameter header=message.getHeaderParameter();
		SOAPHeader soapHeader=soapMessage.getSOAPHeader();
		if(soapHeader!=null){
			String id=SoapUtil.getHeaderElementValue(soapHeader, "ID", SoapUtil.CWMP_PREFIX, message.getUri());
			if(id!=null){
				message.setId(id);
			}
			String hold=SoapUtil.getHeaderElementValue(soapHeader, "HoldRequest", SoapUtil.CWMP_PREFIX, message.getUri());
			if(hold!=null){
				header.setHoldRequest(hold.equals("1")?true:false);
			}
			String sessionTimeOut=SoapUtil.getHeaderElementValue(soapHeader, "SessionTimeout", SoapUtil.CWMP_PREFIX, SoapUtil.CWMP_URN);
			if(sessionTimeOut!=null)
				header.setSessionTimeOut(Long.parseLong(sessionTimeOut));
		}
		return header;
	}
	
	protected SoapBodyParameter parseMessageBody(SOAPMessage soapMessage,Message message)throws SOAPException{
		SoapBodyParameter messageBody=message.getBodyParameter();
		
		SOAPBodyElement bodyElement=SoapUtil.getRequest(soapMessage);
		//String requestName=bodyElement.getLocalName();
	//	Node elementNode=bodyElement.getFirstChild();
		getContent(bodyElement.getChildElements(), messageBody);
		return messageBody;
	}
	
	@SuppressWarnings("rawtypes")
	private void getContent(Iterator iterator,SoapParameter body){
		CwmpSoapFactory factory=SimpleCwmpSoapFactory.getInstance();
		while (iterator.hasNext()) {
			Node node = (Node) iterator.next();
			SOAPElement element = null;
			//Text text = null;
			SoapParameter argument=null;
			if (node instanceof SOAPElement) {
				element = (SOAPElement)node;
				QName name = element.getElementQName();
				argument=body.addSoapParameter(factory.createSoapParameter(name.toString()));
				Iterator attrs = element.getAllAttributesAsQNames();
				while (attrs.hasNext()){
					QName attrName = (QName)attrs.next();
					argument.setAttribute(attrName.toString(), element.getAttributeValue(attrName));
				}
				String content = element.getValue();
				if(content!=null){
					argument.setValue(content);
				}
				Iterator iter2 = element.getChildElements();
				getContent(iter2,argument);
				
			}
		
		}
	}


}
