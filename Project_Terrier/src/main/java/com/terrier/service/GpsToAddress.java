package com.terrier.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;

import javax.inject.Inject;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.stereotype.Service;

import com.terrier.domain.C_mgt_Gps_VO;
import com.terrier.domain.Location_emp_num_VO;

@Service
public class GpsToAddress {
	double latitude; //����
	double longitude; //�浵
	String regionAddress; //�ѱ� �ּ�
	
	@Inject
	D_mgt_Service d_mgt_service;

	public void gps_to_address(double latitude, double longitude) throws Exception { //���� ������
		this.latitude = latitude;
		this.longitude = longitude;
		this.regionAddress = getRegionAddress(getJSONData(getApiAddress()));
	}

	private String getApiAddress() {
		String apiURL = "http://maps.googleapis.com/maps/api/geocode/json?latlng="
				+ latitude + "," + longitude + "&language=ko";
		return apiURL;
	}

	private String getJSONData(String apiURL) throws Exception {
		String jsonString = new String();
		String buf;
		URL url = new URL(apiURL);
		URLConnection conn = url.openConnection();
		BufferedReader br = new BufferedReader(new InputStreamReader(
				conn.getInputStream(), "UTF-8"));
		while ((buf = br.readLine()) != null) {
			jsonString += buf;
		}
		return jsonString;
	}

	private String getRegionAddress(String jsonString) {
		JSONObject jObj = (JSONObject) JSONValue.parse(jsonString);
		JSONArray jArray = (JSONArray) jObj.get("results");
		jObj = (JSONObject) jArray.get(0);
		return (String) jObj.get("formatted_address");
	}

	public String getAddress() {
		return regionAddress;
	}
	
	public C_mgt_Gps_VO getGps_Adress(String e_num, int rank) throws Exception
	{
		// ������ġ�� ������ġ ����,�浵 get
		Location_emp_num_VO location_param = new Location_emp_num_VO(e_num,rank); // limit rank,1
		C_mgt_Gps_VO location_info = d_mgt_service.gps(location_param);
		
		// ����,�浵�� �ѱ� �ּҷ� ��ȯ
		if(location_info != null)
		{
			if(location_info.getLatitude() != 0 && location_info.getLongitude() != 0)
			{
				gps_to_address(location_info.getLatitude(),location_info.getLongitude());
				location_info.setAddress(getAddress());
			}
			else
				location_info.setAddress("��� ����");
		}
		else
		{
			location_info = new C_mgt_Gps_VO();
		}
		
		return location_info;
	}
}