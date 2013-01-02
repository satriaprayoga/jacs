package org.satriaprayoga.jacs.mock;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Time {
	
	@XmlElement
	private String time;
	@XmlElement
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
}
