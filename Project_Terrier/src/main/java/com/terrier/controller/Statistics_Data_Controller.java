package com.terrier.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("terrier/*")
public class Statistics_Data_Controller {

	private static String namespace="S_mgt_Mapper";
	@Inject
	SqlSession sqlSession;
	
	@RequestMapping(value="statistics_management/cummute_date",method=RequestMethod.GET)
	public ResponseEntity<String> control_dep_ctl(@RequestParam("date") String date) throws ParseException
	{
		ResponseEntity<String> response = null;
		
		List<String> value = sqlSession.selectList(namespace+".test_date",date);
		
		System.out.println("Ajax로 보낸 값 : " + date);
		System.out.println("디비에서 뽑은 값 : " + value);
		
		try {
			response = new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
		}
		catch(Exception e) {
			response = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	    return response;
	}
}
