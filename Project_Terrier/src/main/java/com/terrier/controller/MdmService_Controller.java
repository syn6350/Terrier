package com.terrier.controller;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.terrier.domain.G_mgt_log_VO;
import com.terrier.service.G_mgt_Service;
import com.terrier.websocket.C_mgt_socketHandler;
import com.terrier.websocket.D_mgt_socketHandler;


//MDM서버측에서 웹서버로 메세지를 보낼떄 쓰는 용의Controller
//MDM서버측에서 TITLE과BODY를 내용을 보내주면 웹소켓에 연결되어있는 d_mgt로 onMessage로 내용이 실시간으로 전달
@RequestMapping("/mdmservice/*")
@Controller
public class MdmService_Controller {
	
	@Inject
	D_mgt_socketHandler d_mgt_handler; /*d_mgt웹소켓*/
	
	@Inject
	C_mgt_socketHandler c_mgt_handler; /*c_mgt 웹소켓*/
	
	@Inject
	G_mgt_Service g_mgt_service;//그룹제어 로그기록
	
	@RequestMapping("/device_onoff")
	public void device_onoff(@RequestParam("title") String title, @RequestParam("body") String body, Model model)
	{
		System.out.println(body);
		d_mgt_handler.sendMessage(body);
	}
	@RequestMapping("/controller_onoff")//사용자별 제어 사원번호,바뀌는타이틀,on,off 3가지 정보를 받아야함.
	public void controller_onoff(@RequestParam("body")String body,Model model)
	{	//양식-사원번호:wifi:on
		//mdmservice/controller_onoff?body=2013011178:wifi:on
		System.out.println(body);
		c_mgt_handler.sendMessage(body);
	}
	@RequestMapping(value="/g_mgt_log",method=RequestMethod.POST)//그룹제어에서 로그관리로 쓸용도임..
	public ResponseEntity<String> g_mgt_log(@RequestBody G_mgt_log_VO log_vo)throws Exception
	{
		ResponseEntity<String> entity=null;
		g_mgt_service.group_log(log_vo);//로그기록 DB에 저장하기			
		entity =new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
		return entity;
	}
	
/*	@RequestMapping("Controller_onoff")
	public void controller_onoff(@RequestParam("test")String test,Model model)
	{
		System.out.println("onoff까지왔습니다.");
	}*/
	


}
