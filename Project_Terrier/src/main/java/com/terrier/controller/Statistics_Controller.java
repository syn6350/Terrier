package com.terrier.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.terrier.domain.Control_count_VO;
import com.terrier.domain.Dep_ctl_on_count_VO;
import com.terrier.service.S_mgt_Service;

@Controller
@RequestMapping("terrier/*")
public class Statistics_Controller {

	@Inject
	S_mgt_Service s_mgt_service;
	
	@RequestMapping("statistics_management/test")
	public void test()
	{
		
	}
	
	@RequestMapping("statistics_management/google_test")
	public void google_test()
	{
		
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	// 제어 통계
	@RequestMapping(value="statistics_management/control",method=RequestMethod.GET)
	public void control(Model model)
	{
		Control_count_VO c_count_on = s_mgt_service.control_count("on");
		Control_count_VO c_count_off = s_mgt_service.control_count("off");
		
		Dep_ctl_on_count_VO dep_ctl_vo = s_mgt_service.dep_ctl_on_count();
		System.out.println(dep_ctl_vo);
		
		model.addAttribute("c_count_on", c_count_on);
		model.addAttribute("c_count_off", c_count_off);
		model.addAttribute("dep_ctl_vo",dep_ctl_vo);
	}
	
	// 제어 통계의 load용 div
	@RequestMapping(value="statistics_management/control_dep_ctl",method=RequestMethod.GET)
	public void control_dep_ctl(@RequestParam("department") String department, Model model)
	{
		Control_count_VO d_count_on = s_mgt_service.dep_ctl_status(department, "on");
		Control_count_VO d_count_off = s_mgt_service.dep_ctl_status(department, "off");
		
		model.addAttribute("department", department);
		model.addAttribute("d_count_on", d_count_on);
		model.addAttribute("d_count_off", d_count_off);
	}
	
	// 출퇴근 통계
	@RequestMapping(value="statistics_management/commute_mgt",method=RequestMethod.GET)
	public void commute_mgt()
	{
		
	}
}
