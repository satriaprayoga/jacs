/**
 * jacs-core
 * org.satriaprayoga.jacs.msg
 */
package org.satriaprayoga.jacs.msg;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.satriaprayoga.jacs.Message;
import org.satriaprayoga.jacs.SoapBodyParameter;
import org.satriaprayoga.jacs.SoapParameter;
import org.satriaprayoga.jacs.structure.OptionStruct;

/**
 * GetOptionsResponse
 * @author GILANG SATRIA PRAYOGA
 */
public class GetOptionsResponse extends Message{
	private static final long serialVersionUID = 2906822876750835032L;
	
	private List<OptionStruct> optionList;
	
	public GetOptionsResponse() {
		super("GetOptionsResponse");
		optionList=new ArrayList<OptionStruct>();
	}
	
	@Override
	protected void configureParse(SoapBodyParameter bodyParameter) {
		SoapParameter msgParam=bodyParameter.getChildElement("OptionList");
		Iterator<SoapParameter> iter=msgParam.childIterator();
		while(iter.hasNext()){
			SoapParameter arg=iter.next();
			OptionStruct struct=new OptionStruct();
			struct.setOptionName(arg.getChildElement("OptionName").getValue());
			struct.setVoucherSN(arg.getChildElement("VoucherSN").getValue());
			struct.setState(Integer.parseInt(arg.getChildElement("State").getValue()));
			struct.setMode(Integer.parseInt(arg.getChildElement("Mode").getValue()));
			struct.setStartDate(arg.getChildElement("StartDate").getValue());
			struct.setExpirationDate(arg.getChildElement("ExpirationDate").getValue());
			struct.setTransferable(Boolean.parseBoolean(arg.getChildElement("IsTransferable").getValue()));
			optionList.add(struct);
		}
	}
	
	public List<OptionStruct> getOptionList() {
		return optionList;
	}

}
