package com.terrier.domain;

public class C_mgt_controller_VO 
{
  	private String wifi;
  	private String bluetooth;
  	private String tethering;
  	private String camera;
  	private String voiceRecord;
  	
	public String getWifi() {
		return wifi;
	}
	public void setWifi(String wifi) {
		this.wifi = wifi;
	}
	public String getBluetooth() {
		return bluetooth;
	}
	public void setBluetooth(String bluetooth) {
		this.bluetooth = bluetooth;
	}
	public String getTethering() {
		return tethering;
	}
	public void setTethering(String tethering) {
		this.tethering = tethering;
	}
	public String getCamera() {
		return camera;
	}
	public void setCamera(String camera) {
		this.camera = camera;
	}
	public String getVoiceRecord() {
		return voiceRecord;
	}
	public void setVoiceRecord(String voiceRecord) {
		this.voiceRecord = voiceRecord;
	}
	
	@Override
	public String toString() {
		return "C_mgt_controller [wifi=" + wifi + ", bluetooth=" + bluetooth + ", tethering=" + tethering + ", camera="
				+ camera + ", voiceRecord=" + voiceRecord + "]";
	}
  	

}
