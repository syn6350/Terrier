package com.terrier.domain;

public class Control_count_VO {
	private int wifi;
  	private int bluetooth;
  	private int tethering;
  	private int camera;
  	private int voiceRecord;
	public int getWifi() {
		return wifi;
	}
	public void setWifi(int wifi) {
		this.wifi = wifi;
	}
	public int getBluetooth() {
		return bluetooth;
	}
	public void setBluetooth(int bluetooth) {
		this.bluetooth = bluetooth;
	}
	public int getTethering() {
		return tethering;
	}
	public void setTethering(int tethering) {
		this.tethering = tethering;
	}
	public int getCamera() {
		return camera;
	}
	public void setCamera(int camera) {
		this.camera = camera;
	}
	public int getVoiceRecord() {
		return voiceRecord;
	}
	public void setVoiceRecord(int voiceRecord) {
		this.voiceRecord = voiceRecord;
	}
}
