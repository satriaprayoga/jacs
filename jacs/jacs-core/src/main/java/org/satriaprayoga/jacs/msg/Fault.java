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
import org.satriaprayoga.jacs.cwmp.CwmpSoapBody;
import org.satriaprayoga.jacs.cwmp.CwmpSoapFactory;
import org.satriaprayoga.jacs.soap.SoapUtil;
import org.satriaprayoga.jacs.structure.SetParameterValuesFault;

/**
 * Fault
 * @author GILANG SATRIA PRAYOGA
 */
public class Fault extends Message{
	private static final long serialVersionUID = -5871530392325008697L;
	
	public static final String FCODE_REQUEST_DENIED = "9001";
	public static final String FCODE_INTERNAL = "9002";
	public static final String FCODE_INVALID_ARGS = "9003";
	public static final String FCODE_RESOURCE_EXCEEDED = "9004";
	public static final String FCODE_INVALID_PARAMETER_NAME = "9005";
	public static final String FCODE_INVALID_PARAMETER_TYPE = "9006";
	public static final String FCODE_INVALID_PARAMETER_VALUE = "9007";
	public static final String FCODE_PARAMETER_READONLY = "9008";
	public static final String FCODE_NOTIFICATION_REJECTED = "9009";
	public static final String FCODE_DOWNLOAD_FAILURE = "9010";
	public static final String FCODE_UPLOAD_FAILURE = "9011";
	public static final String FCODE_FILE_TRANSFER_AUTHENTICATION_FAILURE = "9012";
	public static final String FCODE_PROTOCOL_NOT_SUPPORTED = "9013";
	public static final String FCODE_DLF_MULTICAST = "9014";
	public static final String FCODE_DLF_NO_CONTACT = "9015";
	public static final String FCODE_DLF_FILE_ACCESS = "9016";
	public static final String FCODE_DLF_UNABLE_TO_COMPLETE = "9017";
	public static final String FCODE_DLF_FILE_CORRUPTED = "9018";
	public static final String FCODE_DLF_FILE_AUTHENTICATION = "9019";
	public static final String FCODE_ACS_METHOD_NOT_SUPPORTED = "8000";
	public static final String FCODE_ACS_REQUEST_DENIED = "8001";
	public static final String FCODE_ACS_INTERNAL_ERROR = "8002";
	public static final String FCODE_ACS_INVALID_ARGS = "8003";
	public static final String FCODE_ACS_RESOURCE_EXCEEDED = "8004";
	public static final String FCODE_ACS_RETRY = "8005";

	private String faultCode;
	private String faultString;
	
	private List<SetParameterValuesFault> parameterValuesFaults=new ArrayList<SetParameterValuesFault>();
	
	public Fault(String faultCode,String faultString) {
		super();
		this.faultCode=faultCode;
		this.faultString=faultString;
		setBodyParameter(new CwmpSoapBody(getName(), SoapUtil.CWMP_URN, SoapUtil.CWMP_PREFIX));
	}
	

	@Override
	protected void configureBody(SoapBodyParameter bodyParameter,CwmpSoapFactory cwmpSoapFactory) {
		SoapParameter faultCodeParam=bodyParameter.addSoapParameter(cwmpSoapFactory.createSoapParameter("FaultCode"));
		faultCodeParam.setValue(faultCode);
		SoapParameter faultStringParam=bodyParameter.addSoapParameter(cwmpSoapFactory.createSoapParameter("FaultString"));
		faultStringParam.setValue(faultString);
		for(SetParameterValuesFault spvf:parameterValuesFaults){
			SoapParameter faultParam=bodyParameter.addSoapParameter(cwmpSoapFactory.createSoapParameter("SetParameterValuesFault"));
			faultParam.addSoapParameter(cwmpSoapFactory.createSoapParameter("ParameterName").setValue(spvf.getParameterName()));
			faultParam.addSoapParameter(cwmpSoapFactory.createSoapParameter("FaultCode").setValue(spvf.getFaultCode()));
			faultParam.addSoapParameter(cwmpSoapFactory.createSoapParameter("FaultString").setValue(spvf.getFaultString()));
		}
	}

	@Override
	protected void configureParse(SoapBodyParameter bodyParameter) {
		throw new UnsupportedOperationException("parse unsupported for message type: "+getName());
	}
	
	public void addParameterFault(String parameterName,String faultCode,String faultString){
		SetParameterValuesFault fault=new SetParameterValuesFault(parameterName, faultCode, faultString);
		parameterValuesFaults.add(fault);
	}

	public String getFaultCode() {
		return faultCode;
	}

	public String getFaultString() {
		return faultString;
	}

}
