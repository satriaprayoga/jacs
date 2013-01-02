/**
 * jacs-core
 * org.satriaprayoga.jacs
 */
package org.satriaprayoga.jacs;

import java.io.Serializable;
import java.util.Calendar;

import org.satriaprayoga.jacs.cwmp.CwmpSoapBody;
import org.satriaprayoga.jacs.cwmp.CwmpSoapFactory;
import org.satriaprayoga.jacs.cwmp.CwmpSoapHeader;
import org.satriaprayoga.jacs.cwmp.SimpleCwmpSoapFactory;
import org.satriaprayoga.jacs.soap.SoapUtil;

/**
 * Message
 * @author GILANG SATRIA PRAYOGA
 */
public abstract class Message implements Serializable{
	
	private static final long serialVersionUID = -8942618528759406935L;
	
	public static final String CWMP = "cwmp";
	public static final String PARAMETER_KEY="ParameterKey";
	public static final String COMMAND_KEY="CommandKey";
	public static final String XSI_TYPE="xsi:type";
	public static final String XSD_STRING="xsd:string";
	public static final String XSD_UNSIGNEDINT="xsd:unsignedInt";
	public static final String XSD_INT="xsd:int";
	public static final String XSD_BOOLEAN="xsd:boolean";
	public static final String XSD_DATETIME="xsd:dateTime";
	public static final String XSD_BASE64="xsd:base64";
	public static final String SOAP_ARRAY_TYPE="SOAP-ENC:arrayType";
	public static final String FAULT_CODE="FaultCode";
	public static final String FAULT_STRING="FaultString";
	
	private SoapBodyParameter bodyParameter;
	private SoapHeaderParameter headerParameter;
	private SoapEnvelopeParameter envelopeParameter;
	
	protected String uri="urn:dslforum-org:cwmp-1-2";
	protected String name;
	private String id;
	
	public Message() {
		this.name=getClass().getSimpleName();
		initParameter(this.name);
	}
	
	public Message(String name){
		this.name=name;
		initParameter(name);
	}
	
	private final void initParameter(String name){
		bodyParameter=new CwmpSoapBody(name);
		headerParameter=new CwmpSoapHeader();
		envelopeParameter=new SoapEnvelopeParameter();
	}
	
	public void configBuild(){
		CwmpSoapFactory cwmpSoapFactory=SimpleCwmpSoapFactory.getInstance();
		configureEnvelope(envelopeParameter);
		configureHeader(headerParameter, cwmpSoapFactory);
		configureBody(bodyParameter, cwmpSoapFactory);
	}
	
	public void configParse(){
		configureParse(bodyParameter);
	}
	
	protected void configureEnvelope(SoapEnvelopeParameter envelope){
		envelope.addNamespace(SoapUtil.SOAP_ENC_PREFIX, SoapUtil.SOAP_ENC_URN);
		envelope.addNamespace(SoapUtil.XSD_PREFIX, SoapUtil.XSD_URN);
		envelope.addNamespace(SoapUtil.XSI_PREFIX, SoapUtil.XSD_URN);
		envelope.addNamespace(SoapUtil.CWMP_PREFIX, SoapUtil.CWMP_URN);
	}
	
	protected void configureHeader(SoapHeaderParameter parameter,CwmpSoapFactory cwmpSoapFactory){
		SoapParameter soapParameter=parameter.addSoapParameter(
				cwmpSoapFactory.createSoapParameter("ID", SoapUtil.CWMP_URN, SoapUtil.CWMP_PREFIX));
		soapParameter.setAttribute("SOAP-ENV:mustUnderstand", parameter.isMustUnderstand()?"1":"0");
		soapParameter.setValue(getId());
		
		SoapParameter holdarg=parameter.addSoapParameter(
				cwmpSoapFactory.createSoapParameter("HoldRequest", SoapUtil.CWMP_URN, SoapUtil.CWMP_PREFIX));
		holdarg.setAttribute("SOAP-ENV:mustUnderstand", parameter.isMustUnderstand()?"1":"0");	
		holdarg.setValue(parameter.isHoldRequest()?"1":"0");
		
		if(parameter.getSessionTimeOut()!=-1){
			SoapParameter stoarg=parameter.addSoapParameter(
					cwmpSoapFactory.createSoapParameter("SessionTimeout", SoapUtil.CWMP_URN, SoapUtil.CWMP_PREFIX));
			stoarg.setAttribute("SOAP-ENV:mustUnderstand",parameter.isMustUnderstand()?"1":"0");
			stoarg.setValue(String.valueOf(parameter.getSessionTimeOut()));
		}
	}
	
	protected void configureBody(SoapBodyParameter bodyParameter,CwmpSoapFactory cwmpSoapFactory){
		throw new UnsupportedOperationException(getName()+" is unsupported for build operation");
	}
	
	protected void configureParse(SoapBodyParameter bodyParameter){
		throw new UnsupportedOperationException(getName()+" is unsupported for parse operation");
	}
	
	public SoapEnvelopeParameter getEnvelopeParameter() {
		return envelopeParameter;
	}
	
	public SoapHeaderParameter getHeaderParameter() {
		return headerParameter;
	}
	public SoapBodyParameter getBodyParameter() {
		return bodyParameter;
	}
	
	public boolean hasFault(){
		return false;
	}
	
	public String getId() {
		if (id == null) {
			id = "ID:intrnl.unset.id."+((name!=null) ? name : "") +(Calendar.getInstance().getTimeInMillis()+3600*1000)+"."+hashCode();
		} 
		return id;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBodyParameter(SoapBodyParameter bodyParameter) {
		this.bodyParameter = bodyParameter;
	}

	public void setHeaderParameter(SoapHeaderParameter headerParameter) {
		this.headerParameter = headerParameter;
	}

	public void setEnvelopeParameter(SoapEnvelopeParameter envelopeParameter) {
		this.envelopeParameter = envelopeParameter;
	}

	public void setId(String id) {
		this.id = id;
	}

}
