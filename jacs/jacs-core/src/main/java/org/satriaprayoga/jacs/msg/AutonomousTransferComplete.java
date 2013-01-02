package org.satriaprayoga.jacs.msg;

import org.satriaprayoga.jacs.Message;
import org.satriaprayoga.jacs.SoapBodyParameter;
import org.satriaprayoga.jacs.SoapParameter;

/**
 * 
 * AutonomousTransferComplete
 * @author GILANG SATRIA PRAYOGA
 */
public class AutonomousTransferComplete extends Message{
	
	private static final long serialVersionUID = -320408874433063306L;
	
	private String announceURL;
	private String transferURL;
	private boolean download;
	private String fileType;
	private int fileSize;
	private String targetFileName;
	private String startTime;
	private String completeTime;
	private String faultCode;
	private String faultString;
	
	public AutonomousTransferComplete() {
		super("AutonomousTransferComplete");
	}
	
	@Override
	protected void configureParse(SoapBodyParameter bodyParameter) {
		announceURL=bodyParameter.getChildElement("AnnounceURL").getValue();
		transferURL=bodyParameter.getChildElement("TransferURL").getValue();
		download=bodyParameter.getChildElement("IsDownload").getValue().equals("1");
		fileType=bodyParameter.getChildElement("FileSize").getValue();
		fileSize=Integer.parseInt(bodyParameter.getChildElement("FileSize").getValue());
		targetFileName=bodyParameter.getChildElement("TargetFileName").getValue();
		SoapParameter faultArg=bodyParameter.getChildElement("FaultStruct");
		if(faultArg!=null){
			faultCode=faultArg.getChildElement("FaultCode").getValue();
			faultString=faultArg.getChildElement("FaultString").getValue();
		}else{
			faultCode="0";
			faultString=null;
		}
		startTime=bodyParameter.getChildElement("StartTime").getValue();
		completeTime=bodyParameter.getChildElement("CompleteTime").getValue();
	}

	public String getAnnounceURL() {
		return announceURL;
	}

	public String getTransferURL() {
		return transferURL;
	}

	public boolean isDownload() {
		return download;
	}

	public String getFileType() {
		return fileType;
	}

	public int getFileSize() {
		return fileSize;
	}

	public String getTargetFileName() {
		return targetFileName;
	}

	public String getStartTime() {
		return startTime;
	}

	public String getCompleteTime() {
		return completeTime;
	}

	public String getFaultCode() {
		return faultCode;
	}

	public String getFaultString() {
		return faultString;
	}
	
	

}
