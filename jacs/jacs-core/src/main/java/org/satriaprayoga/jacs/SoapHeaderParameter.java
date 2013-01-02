/**
 * jacs-core
 * org.satriaprayoga.jacs
 */
package org.satriaprayoga.jacs;

/**
 * SoapHeaderParameter
 * @author GILANG SATRIA PRAYOGA
 */
public interface SoapHeaderParameter extends SoapParameter{

	public boolean isMustUnderstand();
	public void setMustUnderstand(boolean mustUnderstand);
	public long getSessionTimeOut();
	public void setSessionTimeOut(long sessionTimeOut);
	public boolean isHoldRequest();
	public void setHoldRequest(boolean holdRequest);
}
