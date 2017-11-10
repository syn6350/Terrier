package com.terrier.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.terrier.domain.C_mgt_AppList_VO;
import com.terrier.domain.C_mgt_AppLog_VO;
import com.terrier.domain.C_mgt_Gps_VO;
import com.terrier.domain.C_mgt_controller_VO;
import com.terrier.domain.C_mgt_userinfo_VO;
import com.terrier.domain.Employee_VO;
import com.terrier.domain.Location_emp_num_VO;
import com.terrier.service.D_mgt_Service;
import com.terrier.service.GpsToAddress;

@Controller
@RequestMapping("terrier/*")
public class Device_Controller {
	@Inject
	D_mgt_Service d_mgt_service;
	
	@Inject
	GpsToAddress gps;
	
	@RequestMapping(value="device_management/d_mgt",method=RequestMethod.GET)
	public String d_mgtGET(Model model) throws Exception 
	{
		model.addAttribute("list",d_mgt_service.emp_list());
		return "terrier/device_management/d_mgt";
	}
	
	@RequestMapping(value="device_management/d_mgt_search",method=RequestMethod.GET)
	public String d_mgt_search(Employee_VO vo,Model model) throws Exception//�˻� ��ư �Ӽ�
	{
		//vo���� ���õ� ������ ��� ���ε��ɰ���.
		model.addAttribute("vo",vo);
		List<Employee_VO> list; 
		list=d_mgt_service.emp_search_list(vo);
		model.addAttribute("list",list);
		return "terrier/device_management/d_mgt";
	}
	
	@RequestMapping(value="device_management/c_mgt",method=RequestMethod.GET)
	public void c_mgtGET(@RequestParam("e_num") String e_num,Model model)throws Exception//ON,OFF��ư �������� [�˾�â]����� 1����
	{
		model.addAttribute("curr_location",gps.getGps_Adress(e_num,0)); // ����,�浵,�ּ�
		model.addAttribute("pre_location",gps.getGps_Adress(e_num,1));
		model.addAttribute("e_num",e_num);
		List<C_mgt_AppLog_VO> applog=d_mgt_service.applog(e_num);
		model.addAttribute("applog",applog);//���ø����̼� �α� ���� �Ѱ��ֱ�
		List<C_mgt_AppList_VO> applist=d_mgt_service.applist(e_num);
		model.addAttribute("applist",applist);//���ø����̼� ���� �Ѱ��ֱ�.
		C_mgt_userinfo_VO user =d_mgt_service.info(e_num);
		model.addAttribute("info",user);//����� ���� �Ѱ��ֱ�.
		C_mgt_controller_VO con=d_mgt_service.controller(e_num);
		model.addAttribute("con",con);//���� ���� �Ѱ��ֱ�
	}
}
