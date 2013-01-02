/**
 * jacs-core
 * org.satriaprayoga.jacs
 */
package org.satriaprayoga.jacs;

import java.util.HashMap;
import java.util.Map;

/**
 * SoapEnvelopeParameter
 * @author GILANG SATRIA PRAYOGA
 */
public class SoapEnvelopeParameter {

	private final Map<String, String> namespaceMap=new HashMap<String,String>();
	
	public void addNamespace(String name, String value) {
		namespaceMap.put(name, value);
	}

	public Map<String, String> getNamespaceMap() {
		return namespaceMap;
	}
	
	public String getNamespaceValue(String name) {
		return namespaceMap.get(name);
	}
}
