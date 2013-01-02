/**
 * jacs-core
 * org.satriaprayoga.jacs.cwmp
 */
package org.satriaprayoga.jacs.cwmp;

import org.satriaprayoga.jacs.SoapHeaderParameter;

/**
 * CwmSoapHeader
 * @author GILANG SATRIA PRAYOGA
 */
public class CwmpSoapHeader extends CwmpSoapMessageStub implements SoapHeaderParameter{
	
	private boolean mustUnderstand=true;
	private boolean holdRequest=false;
	private long sessionTimeOut=-1;

	@Override
	public boolean isMustUnderstand() {
		return mustUnderstand;
	}

	@Override
	public void setMustUnderstand(boolean mustUnderstand) {
		this.mustUnderstand=mustUnderstand;
	}

	@Override
	public long getSessionTimeOut() {
		return sessionTimeOut;
	}

	@Override
	public void setSessionTimeOut(long sessionTimeOut) {
		this.sessionTimeOut=sessionTimeOut;
	}

	@Override
	public boolean isHoldRequest() {
		return holdRequest;
	}

	@Override
	public void setHoldRequest(boolean holdRequest) {
		this.holdRequest=holdRequest;
	}

}
