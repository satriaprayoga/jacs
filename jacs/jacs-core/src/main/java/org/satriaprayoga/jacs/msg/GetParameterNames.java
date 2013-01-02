/**
 * jacs-core
 * org.satriaprayoga.jacs.msg
 */
package org.satriaprayoga.jacs.msg;

import org.satriaprayoga.jacs.Message;
import org.satriaprayoga.jacs.SoapBodyParameter;
import org.satriaprayoga.jacs.cwmp.CwmpSoapFactory;

/**
 * GetParameterNames
 * @author GILANG SATRIA PRAYOGA
 */
public class GetParameterNames extends Message{
	private static final long serialVersionUID = -574665710875126279L;
	
	private String parameterPath=".";
	private boolean nextLevel;

	public GetParameterNames(String parameterPath,boolean nextLevel) {
		super("GetParameterNames");
		this.parameterPath=parameterPath;
		this.nextLevel=nextLevel;
	}
	
	@Override
	protected void configureBody(SoapBodyParameter bodyParameter,
			CwmpSoapFactory cwmpSoapFactory) {
		bodyParameter.addSoapParameter(cwmpSoapFactory.createSoapParameter("ParameterPath").setValue(parameterPath));
		bodyParameter.addSoapParameter(cwmpSoapFactory.createSoapParameter("NextLevel").setValue(nextLevel?"1":"0"));
	}

}
