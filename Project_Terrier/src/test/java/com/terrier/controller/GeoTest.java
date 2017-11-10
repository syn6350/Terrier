package com.terrier.controller;


import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.terrier.service.GpsToAddress;
import com.terrier.websocket.C_mgt_socketHandler;



@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations ={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class GeoTest {
	
	@Inject
	C_mgt_socketHandler ss;
	//GpsToAddress gps;
	
	@Test
	public void test() throws Exception {
		
		/*double latitude = 37.4745119;
		double longitude = 127.0331253;

		gps.setLatitude(latitude);
		gps.setLongitude(longitude);
		gps.gps_to_address();
		
		System.out.println(gps.getAddress());*/
	}
}
