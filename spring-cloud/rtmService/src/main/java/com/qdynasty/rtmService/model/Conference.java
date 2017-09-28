/**
 * 
 */
package com.qdynasty.rtmService.model;

/**
 * @author fei.qin
 *
 */
public class Conference {

	private String billingCode;

	private String name;

	private String hostCode;

	private String guestCode;

	private String bridgeName;

	private String beginTime;

	private String endTime;

	public String getBillingCode() {
		return billingCode;
	}

	public void setBillingCode(String billingCode) {
		this.billingCode = billingCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHostCode() {
		return hostCode;
	}

	public void setHostCode(String hostCode) {
		this.hostCode = hostCode;
	}

	public String getGuestCode() {
		return guestCode;
	}

	public void setGuestCode(String guestCode) {
		this.guestCode = guestCode;
	}

	public String getBridgeName() {
		return bridgeName;
	}

	public void setBridgeName(String bridgeName) {
		this.bridgeName = bridgeName;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
}
