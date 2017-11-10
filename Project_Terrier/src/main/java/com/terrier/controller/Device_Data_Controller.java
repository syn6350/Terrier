package com.terrier.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.terrier.domain.C_mgt_controller_VO;
import com.terrier.service.D_mgt_Service;

@RestController
@RequestMapping("terrier/*")
public class Device_Data_Controller {
	@Inject
	D_mgt_Service d_mgt_service;
	
	@RequestMapping(value="device_management/controll_view",method=RequestMethod.GET)
	public ResponseEntity<C_mgt_controller_VO> controll_view(@RequestParam("e_num") String e_num)
	{
		ResponseEntity<C_mgt_controller_VO> response = null;
		try {
			C_mgt_controller_VO vo = d_mgt_service.controller(e_num);
			response = new ResponseEntity<C_mgt_controller_VO>(vo,HttpStatus.OK);
		}
		catch(Exception e) {
			response = new ResponseEntity<C_mgt_controller_VO>(HttpStatus.BAD_REQUEST);
		}
	    return response;
	}
}
