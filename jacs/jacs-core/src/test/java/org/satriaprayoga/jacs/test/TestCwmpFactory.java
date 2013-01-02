/**
 * jacs-core
 * org.satriaprayoga.jacs.test
 */
package org.satriaprayoga.jacs.test;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import org.junit.Test;
import org.satriaprayoga.jacs.CwmpMessageException;
import org.satriaprayoga.jacs.cwmp.CwmpSoapFactory;
import org.satriaprayoga.jacs.cwmp.SimpleCwmpSoapFactory;
import org.satriaprayoga.jacs.msg.Fault;
import org.satriaprayoga.jacs.soap.CwmpSoapBuilder;
import org.satriaprayoga.jacs.soap.SoapBuilder;

/**
 * TestCwmpFactory
 * @author GILANG SATRIA PRAYOGA
 */
public class TestCwmpFactory {

	@Test
	public void testFactoryInstance(){
		CwmpSoapFactory cwmpSoapFactory=SimpleCwmpSoapFactory.getInstance();
		assertTrue(cwmpSoapFactory!=null);
	}
	
	@Test
	public void testFault() throws CwmpMessageException, SOAPException, IOException{
		Fault fault=new Fault("11", "Fault 1");
		SoapBuilder builder=new CwmpSoapBuilder();
		SOAPMessage message=builder.build(fault);
		message.writeTo(System.out);
	}
}
