/**
 * jacs-core
 * org.satriaprayoga.jacs.msg
 */
package org.satriaprayoga.jacs.msg;

import org.satriaprayoga.jacs.Message;
import org.satriaprayoga.jacs.SoapBodyParameter;
import org.satriaprayoga.jacs.cwmp.CwmpSoapFactory;

/**
 * FactoryReset
 * @author GILANG SATRIA PRAYOGA
 */
public class FactoryReset extends Message{
	private static final long serialVersionUID = 6550887942159461801L;
	
	public FactoryReset() {
		super("FactoryReset");
	}
	
	@Override
	protected void configureBody(SoapBodyParameter bodyParameter,
			CwmpSoapFactory cwmpSoapFactory) {
	}
	
	@Override
	protected void configureParse(SoapBodyParameter bodyParameter) {
	}

}
