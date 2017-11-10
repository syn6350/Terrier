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


//MDM���������� �������� �޼����� ������ ���� ����Controller
//MDM���������� TITLE��BODY�� ������ �����ָ� �����Ͽ� ����Ǿ��ִ� d_mgt�� onMessage�� ������ �ǽð����� ����
@RequestMapping("/mdmservice/*")
@Controller
public class MdmService_Controller {
	
	@Inject
	D_mgt_socketHandler d_mgt_handler; /*d_mgt������*/
	
	@Inject
	C_mgt_socketHandler c_mgt_handler; /*c_mgt ������*/
	
	@Inject
	G_mgt_Service g_mgt_service;//�׷����� �αױ��
	
	@RequestMapping("/device_onoff")
	public void device_onoff(@RequestParam("title") String title, @RequestParam("body") String body, Model model)
	{
		System.out.println(body);
		d_mgt_handler.sendMessage(body);
	}
	@RequestMapping("/controller_onoff")//����ں� ���� �����ȣ,�ٲ��Ÿ��Ʋ,on,off 3���� ������ �޾ƾ���.
	public void controller_onoff(@RequestParam("body")String body,Model model)
	{	//���-�����ȣ:wifi:on
		//mdmservice/controller_onoff?body=2013011178:wifi:on
		System.out.println(body);
		c_mgt_handler.sendMessage(body);
	}
	@RequestMapping(value="/g_mgt_log",method=RequestMethod.POST)//�׷������ �αװ����� ���뵵��..
	public ResponseEntity<String> g_mgt_log(@RequestBody G_mgt_log_VO log_vo)throws Exception
	{
		ResponseEntity<String> entity=null;
		g_mgt_service.group_log(log_vo);//�αױ�� DB�� �����ϱ�			
		entity =new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
		return entity;
	}
	
/*	@RequestMapping("Controller_onoff")
	public void controller_onoff(@RequestParam("test")String test,Model model)
	{
		System.out.println("onoff�����Խ��ϴ�.");
	}*/
	


}
