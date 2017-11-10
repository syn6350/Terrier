package com.terrier.controller;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"}) //DB소스내용 경로잡아주기
public class MyBatisTest {

	@Inject 
	private SqlSessionFactory sqlFactory;
	
	@Test
	public void testFactory(){
		//SqlSessionFactory가있는지 확인
		System.out.println(sqlFactory);
		
	}
	
	@Test
	public void testSession()throws Exception{
		//SqlSesscionFtory가 연결되는지 확인
		try(SqlSession session = sqlFactory.openSession()){
			
			System.out.println(session);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}


