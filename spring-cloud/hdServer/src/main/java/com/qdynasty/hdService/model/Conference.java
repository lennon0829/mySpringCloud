/**
 * 
 */
package com.qdynasty.hdService.model;

/**
 * @author fei.qin
 *
 */
public class Conference {

	private String id;

	private String billingCode;

	private String name;

	private String hostCode;

	private String guestCode;

	private String bridgeName;

	private String beginTime;

	private String endTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Conference [id=");
		builder.append(id);
		builder.append(", billingCode=");
		builder.append(billingCode);
		builder.append(", name=");
		builder.append(name);
		builder.append(", hostCode=");
		builder.append(hostCode);
		builder.append(", guestCode=");
		builder.append(guestCode);
		builder.append(", bridgeName=");
		builder.append(bridgeName);
		builder.append(", beginTime=");
		builder.append(beginTime);
		builder.append(", endTime=");
		builder.append(endTime);
		builder.append("]");
		return builder.toString();
	}

}
