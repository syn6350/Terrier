package com.terrier.domain;

public class C_mgt_Gps_VO {
	double latitude = 0;
	double longitude = 0;
	String Address = "기록 없음";
	
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	@Override
	public String toString() {
		return "C_mgt_Gps_VO [latitude=" + latitude + ", longitude=" + longitude + ", Address=" + Address + "]";
	}
}
