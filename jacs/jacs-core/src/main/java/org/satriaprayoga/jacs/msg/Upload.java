/**
 * 
 */
package org.satriaprayoga.jacs.msg;

import org.satriaprayoga.jacs.Message;
import org.satriaprayoga.jacs.SoapBodyParameter;
import org.satriaprayoga.jacs.cwmp.CwmpSoapFactory;

/**
 * @author satriaprayoga
 *
 */
public class Upload extends Message {
	private static final long serialVersionUID = 8610882003673215156L;
	
	public static final String FT_CONFIG = "1 Vendor Configuration File";
    public static final String FT_LOG = "2 Vendor Log File";

	private String commandKey;
	private String fileType;
	private String url;
	private String username;
	private String password;
	private int delaySeconds;

	public Upload() {
		super("Upload");
	}

	@Override
	protected void configureBody(SoapBodyParameter bodyPart,
			CwmpSoapFactory argumentFactory) {
		bodyPart.addSoapParameter(argumentFactory.createSoapParameter("CommandKey")).setValue(commandKey);
		bodyPart.addSoapParameter(argumentFactory.createSoapParameter("FileType")).setValue(fileType);
		bodyPart.addSoapParameter(argumentFactory.createSoapParameter("URL")).setValue(url);
		bodyPart.addSoapParameter(argumentFactory.createSoapParameter("Username")).setValue(username);
		bodyPart.addSoapParameter(argumentFactory.createSoapParameter("Password")).setValue(password);
		bodyPart.addSoapParameter(argumentFactory.createSoapParameter("DelaySeconds")).setValue(String.valueOf(delaySeconds));
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getDelaySeconds() {
		return delaySeconds;
	}

	public void setDelaySeconds(int delaySeconds) {
		this.delaySeconds = delaySeconds;
	}
	
	

}
