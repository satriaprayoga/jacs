package org.satriaprayoga.jacs.structure;
/**
 * 
 * OptionStruct
 * @author GILANG SATRIA PRAYOGA
 */
public class OptionStruct {
	
	private String optionName;
	private String voucherSN;
	private int state;
	private int mode;
	private String startDate;
	private String expirationDate;
	private boolean  transferable;
	public String getOptionName() {
		return optionName;
	}
	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}
	public String getVoucherSN() {
		return voucherSN;
	}
	public void setVoucherSN(String voucherSN) {
		this.voucherSN = voucherSN;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getMode() {
		return mode;
	}
	public void setMode(int mode) {
		this.mode = mode;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	public boolean isTransferable() {
		return transferable;
	}
	public void setTransferable(boolean transferable) {
		this.transferable = transferable;
	}
	
	

}
