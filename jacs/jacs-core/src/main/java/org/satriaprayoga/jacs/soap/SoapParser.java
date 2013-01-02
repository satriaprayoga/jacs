/**
 * jacs-core
 * org.satriaprayoga.jacs.soap
 */
package org.satriaprayoga.jacs.soap;

import javax.xml.soap.SOAPMessage;

import org.satriaprayoga.jacs.Message;

/**
 * SoapParser
 * @author GILANG SATRIA PRAYOGA
 */
public interface SoapParser {

	public Message parse(SOAPMessage soapMessage) throws SoapMessageParserException;
}
