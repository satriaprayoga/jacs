/**
 * jacs-core
 * org.satriaprayoga.jacs.soap
 */
package org.satriaprayoga.jacs.soap;

import javax.xml.soap.SOAPMessage;

import org.satriaprayoga.jacs.CwmpMessageException;
import org.satriaprayoga.jacs.Message;

/**
 * SoapBuilder
 * @author GILANG SATRIA PRAYOGA
 */
public interface SoapBuilder {

	public SOAPMessage build(Message message)throws CwmpMessageException;
}
