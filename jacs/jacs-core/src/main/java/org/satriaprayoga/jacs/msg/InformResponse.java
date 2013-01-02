/**
 * jacs-core
 * org.satriaprayoga.jacs.msg
 */
package org.satriaprayoga.jacs.msg;

import org.satriaprayoga.jacs.Message;
import org.satriaprayoga.jacs.SoapBodyParameter;
import org.satriaprayoga.jacs.cwmp.CwmpSoapFactory;

/**
 * InformResponse
 * @author GILANG SATRIA PRAYOGA
 */
public class InformResponse extends Message{

	private static final long serialVersionUID = -5734040680391693595L;
	
	private int maxEnvelopes;
	
	public InformResponse() {
		super("InformResponse");
	}
	
	public void setMaxEnvelopes(int maxEnvelopes) {
		this.maxEnvelopes = maxEnvelopes;
	}
	
	@Override
	protected void configureBody(SoapBodyParameter bodyParameter,
			CwmpSoapFactory cwmpSoapFactory) {
		bodyParameter.addSoapParameter(cwmpSoapFactory.createSoapParameter("MaxEnvelopes")).setValue(String.valueOf(maxEnvelopes));
	}

}
