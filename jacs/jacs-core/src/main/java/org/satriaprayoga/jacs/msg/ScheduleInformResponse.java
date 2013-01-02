/**
 * jacs-core
 * org.satriaprayoga.jacs.msg
 */
package org.satriaprayoga.jacs.msg;

import org.satriaprayoga.jacs.Message;
import org.satriaprayoga.jacs.SoapBodyParameter;
import org.satriaprayoga.jacs.cwmp.CwmpSoapFactory;

/**
 * ScheduleInformResponse
 * @author GILANG SATRIA PRAYOGA
 */
public class ScheduleInformResponse extends Message{
	private static final long serialVersionUID = 8628143637534164738L;
	
	public ScheduleInformResponse() {
		super("ScheduleInformResponse");
	}
	
	@Override
	protected void configureBody(SoapBodyParameter bodyParameter,
			CwmpSoapFactory cwmpSoapFactory) {
	}
	
	@Override
	protected void configureParse(SoapBodyParameter bodyParameter) {
	}

}
