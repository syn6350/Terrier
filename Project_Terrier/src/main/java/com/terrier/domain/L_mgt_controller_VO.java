package com.terrier.domain;

public class L_mgt_controller_VO {
	private String alarm;
	private String gps;
	
	public String getAlarm() {
		return alarm;
	}
	public void setAlarm(String alarm) {
		this.alarm = alarm;
	}
	public String getGps() {
		return gps;
	}
	public void setGps(String gps) {
		this.gps = gps;
	}
	@Override
	public String toString() {
		return "L_mgt_controller [alarm=" + alarm + ", gps=" + gps + "]";
	}
	
}
