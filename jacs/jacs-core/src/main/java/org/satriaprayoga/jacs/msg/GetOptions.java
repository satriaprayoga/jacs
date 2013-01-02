/**
 * jacs-core
 * org.satriaprayoga.jacs.msg
 */
package org.satriaprayoga.jacs.msg;

import org.satriaprayoga.jacs.Message;
import org.satriaprayoga.jacs.SoapBodyParameter;
import org.satriaprayoga.jacs.cwmp.CwmpSoapFactory;

/**
 * GetOptions
 * @author GILANG SATRIA PRAYOGA
 */
public class GetOptions extends Message{
	private static final long serialVersionUID = 124365676001026336L;
	
	private String optionName;
	
	public GetOptions() {
		super("GetOptions");
	}
	
	public GetOptions(String optionName){
		this();
		this.optionName=optionName;
	}
	
	@Override
	protected void configureBody(SoapBodyParameter bodyParameter,
			CwmpSoapFactory cwmpSoapFactory) {
		bodyParameter.addSoapParameter(cwmpSoapFactory.createSoapParameter("OptionName").setValue(optionName));
	}
	
	public String getOptionName() {
		return optionName;
	}

}
