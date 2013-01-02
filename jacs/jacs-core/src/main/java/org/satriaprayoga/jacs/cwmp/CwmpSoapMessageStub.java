/**
 * jacs-core
 * org.satriaprayoga.jacs.cwmp
 */
package org.satriaprayoga.jacs.cwmp;

import java.util.ArrayList;
import java.util.Iterator;

import org.satriaprayoga.jacs.Attribute;
import org.satriaprayoga.jacs.SoapParameter;

/**
 * CWMPParameter
 * @author GILANG SATRIA PRAYOGA
 */
class CwmpSoapMessageStub implements SoapParameter{
	
	private String uri;
	private String prefix;
	private String name;
	private String value;
	
	private Attribute attribute;
	
	private final ArrayList<SoapParameter> childParameters=
			new ArrayList<SoapParameter>(); 
	
	public CwmpSoapMessageStub() {
		this(null,null,null);
	}
	
	public CwmpSoapMessageStub(String name){
		this(name,null,null);
	}
	
	public CwmpSoapMessageStub(String name,String uri,String prefix){
		this.name=name;
		this.uri=uri;
		this.prefix=prefix;
	}

	@Override
	public void setAttribute(String name, String value) {
		attribute=new Attribute(name, value);
	}

	@Override
	public SoapParameter setValue(String value) {
		this.value=value;
		return this;
	}

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public String getAttributeValue(String name) {
		return attribute.getName().equals(name)?attribute.getValue():null;
	}

	@Override
	public String getAttributeName() {
		if(attribute!=null){
			return attribute.getName();
		}else{
			return null;
		}
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getUri() {
		return uri;
	}

	@Override
	public String getPrefix() {
		return prefix;
	}

	@Override
	public SoapParameter addSoapParameter(SoapParameter argument) {
		if(!childParameters.contains(argument)){
			childParameters.add(argument);
		}
		return this;
	}

	@Override
	public SoapParameter getChildElement(String childName) {
		SoapParameter child=null;
		for(SoapParameter param:childParameters){
			if(param.getName().equals(childName)){
				child=param;
			}
		}
		return child;
	}

	@Override
	public Iterator<SoapParameter> childIterator() {
		return childParameters.iterator();
	}

	@Override
	public boolean hasChild() {
		return childParameters.isEmpty()==false;
	}

	@Override
	public int childSize() {
		return childParameters.size();
	}

}
