/**
 * jacs-core
 * org.satriaprayoga.jacs.msg
 */
package org.satriaprayoga.jacs.msg;

import org.satriaprayoga.jacs.Message;
import org.satriaprayoga.jacs.SoapBodyParameter;
import org.satriaprayoga.jacs.cwmp.CwmpSoapFactory;

/**
 * Download
 * @author GILANG SATRIA PRAYOGA
 */
public class Download extends Message{
	
	private static final long serialVersionUID = -3474303188808344542L;
	
	public String commandKey = "";
	public String fileType = "";
	public String url = "";
	public String userName = "";
	public String password = "";
	public long fileSize = 0;
	public String targetFileName = "";
	public int delaySeconds = 0;
	public String successUrl = "";
	public String failureUrl = "";

	public static final String FT_FIRMWARE = "1 Firmware Upgrade Image";
	public static final String FT_WEBCONTENT = "2 Web Content";
	public static final String FT_CONFIG = "3 Vendor Configuration File";

	public Download() {
		super("Download");
	}
	
	@Override
	protected void configureBody(SoapBodyParameter bodyParameter,
			CwmpSoapFactory cwmpSoapFactory) {
		bodyParameter.addSoapParameter(cwmpSoapFactory.createSoapParameter("CommandKey")).setValue(commandKey);
		bodyParameter.addSoapParameter(cwmpSoapFactory.createSoapParameter("FileType")).setValue(fileType);
		bodyParameter.addSoapParameter(cwmpSoapFactory.createSoapParameter("URL")).setValue(url);
		bodyParameter.addSoapParameter(cwmpSoapFactory.createSoapParameter("Username")).setValue(userName);
		bodyParameter.addSoapParameter(cwmpSoapFactory.createSoapParameter("Password")).setValue(password);
		bodyParameter.addSoapParameter(cwmpSoapFactory.createSoapParameter("FileSize")).setValue(String.valueOf(fileSize));
		bodyParameter.addSoapParameter(cwmpSoapFactory.createSoapParameter("TargetFileName")).setValue(targetFileName);
		bodyParameter.addSoapParameter(cwmpSoapFactory.createSoapParameter("DelaySeconds")).setValue(String.valueOf(delaySeconds));
		bodyParameter.addSoapParameter(cwmpSoapFactory.createSoapParameter("SuccessURL")).setValue(successUrl);
		bodyParameter.addSoapParameter(cwmpSoapFactory.createSoapParameter("FailureURL")).setValue(failureUrl);
	}
	
	public String getCommandKey() {
		return commandKey;
	}

	public void setCommandKey(String commandKey) {
		this.commandKey = commandKey;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public String getTargetFileName() {
		return targetFileName;
	}

	public void setTargetFileName(String targetFileName) {
		this.targetFileName = targetFileName;
	}

	public int getDelaySeconds() {
		return delaySeconds;
	}

	public void setDelaySeconds(int delaySeconds) {
		this.delaySeconds = delaySeconds;
	}

	public String getSuccessUrl() {
		return successUrl;
	}

	public void setSuccessUrl(String successUrl) {
		this.successUrl = successUrl;
	}

	public String getFailureUrl() {
		return failureUrl;
	}

	public void setFailureUrl(String failureUrl) {
		this.failureUrl = failureUrl;
	}
	

}
