/**
 * 
 */
package com.qdynasty.hdService.model;

/**
 * @author qinfei
 *
 */
public class HistoryEvent {
	
	private String conferenceId;
	
	private String eventTime;
	
	private String phone;
	
	private String partyName;
	
	private String connectstate;
	
	public String getEventTime() {
		return eventTime;
	}

	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}

	public String getConferenceId() {
		return conferenceId;
	}

	public void setConferenceId(String conferenceId) {
		this.conferenceId = conferenceId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	public String getConnectstate() {
		return connectstate;
	}

	public void setConnectstate(String connectstate) {
		this.connectstate = connectstate;
	}
}
