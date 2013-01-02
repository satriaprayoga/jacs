package org.satriaprayoga.jacs.mock;

public interface TimeService {

	public String getTime(String name);
	
	public Time getTimeOfTheDayInXML(String name);

	public Time getTimeOfTheDayInJSON(String name);

}
