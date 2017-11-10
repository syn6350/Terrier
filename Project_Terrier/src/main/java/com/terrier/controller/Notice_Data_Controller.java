package com.terrier.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.terrier.domain.Reply_VO;
import com.terrier.domain.User_VO;
import com.terrier.service.N_mgt_Service;

@RestController
@RequestMapping("terrier/*")
public class Notice_Data_Controller {
	
	@Inject
	N_mgt_Service n_mgt_service;
	
	@RequestMapping(value="notice_management/reply",method=RequestMethod.GET)
	public ResponseEntity<String> n_mgt_reply(@RequestParam("bno") int bno, @RequestParam("content") String content,HttpSession session) throws Exception
	{
		ResponseEntity<String> response = null;
		User_VO vo = (User_VO)session.getAttribute("user_info"); 
		
		n_mgt_service.n_reply_regist(new Reply_VO(bno,vo.getId(),content));
		
		try {
			response = new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
		}
		catch(Exception e) {
			response = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	    return response;
	}
	
	@RequestMapping(value="notice_management/reply_reply",method=RequestMethod.GET)
	public ResponseEntity<String> n_mgt_reply_reply(@RequestParam("bno") int bno, @RequestParam("rno") int rno, @RequestParam("content") String content,HttpSession session) throws Exception
	{
		ResponseEntity<String> response = null;
		User_VO vo = (User_VO)session.getAttribute("user_info"); 
		
		n_mgt_service.n_reply_re_regist(new Reply_VO(bno,rno,vo.getId(),content));
		
		try {
			response = new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
		}
		catch(Exception e) {
			response = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	    return response;
	}
}
