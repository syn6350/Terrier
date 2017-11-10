package com.terrier.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.terrier.service.R_mgt_Service;

@RestController
@RequestMapping("terrier/*")
public class Request_Data_Controller {
	@Inject
	R_mgt_Service r_mgt_service;
	
	@RequestMapping(value="request_management/grant",method=RequestMethod.POST)
	public ResponseEntity<String> grant(@RequestParam("bno") int bno) throws Exception
	{
		ResponseEntity<String> response = null;
		
		r_mgt_service.request_grant(bno);
		
		try {
			response = new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
		}
		catch(Exception e) {
			response = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	    return response;
	}
	
	@RequestMapping(value="request_management/deny",method=RequestMethod.POST)
	public ResponseEntity<String> deny(@RequestParam("bno") int bno) throws Exception
	{
		ResponseEntity<String> response = null;
		
		r_mgt_service.request_deny(bno);
		
		try {
			response = new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
		}
		catch(Exception e) {
			response = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	    return response;
	}

}
