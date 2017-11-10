package com.terrier.controller;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
	locations ={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"}) //DB소스내용 경로잡아주기
public class DataSourceTest {

	@Inject
	private DataSource ds;
	
	@Test
	public void testConection()throws Exception{
		
		try(Connection con = ds.getConnection()){
			
			System.out.println("커낵션연결성공!!"+con);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}


