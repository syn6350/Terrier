package com.terrier.controller;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.terrier.domain.C_mgt_Gps_VO;
import com.terrier.domain.Employee_VO;
import com.terrier.domain.Location_emp_num_VO;
import com.terrier.service.D_mgt_Service;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class D_mgtTest {
	
	@Inject
	D_mgt_Service service;
	
	@Test
	public void test() throws Exception {
		List<Employee_VO> vo;
		vo = service.emp_list();
		
		Iterator<Employee_VO> it =vo.iterator();
		
		while(it.hasNext()) {
			Employee_VO test1=it.next();
			System.out.println(test1.toString());
		}
	}
	
	@Test
	public void test2() throws Exception {
		String data = "face,51\r\n" + 
				",16011042";
		String send_data = "";
		
		String d1[] = data.split(",");
		send_data += d1[2] + "-";
		send_data += d1[0] + "-";
		send_data += d1[1].replaceAll("\\D", "");;
		
		
		
		System.out.println(send_data);
	}
}
