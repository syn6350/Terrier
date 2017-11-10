package com.terrier.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.terrier.domain.Employee_VO;
import com.terrier.domain.G_Owner_VO;
import com.terrier.domain.G_mgt_log_VO;
import com.terrier.domain.GroupList_VO;
import com.terrier.domain.User_VO;
import com.terrier.service.G_mgt_Service;

//�׷���� view��Ʈ�� ����
@Controller
@RequestMapping("terrier/*")
public class Group_Controller {
	@Inject
	G_mgt_Service g_mgt_service;
	
	@RequestMapping(value="group_management/g_mgt",method=RequestMethod.GET) //�׷����-�׷���� 
	public void g_mgtGET(Model model,HttpSession session) throws Exception
	{
		User_VO user_vo = (User_VO)session.getAttribute("user_info");//�����ѻ���� ID�� ����id�� ����ɰ�.
		String id = user_vo.getId();
		List<GroupList_VO> grouplist_vo;
		grouplist_vo = g_mgt_service.group_list(id);
		model.addAttribute("list", grouplist_vo);
		
		List<G_mgt_log_VO> log=g_mgt_service.group_log_list(id);//���ʾ��̵��༭ �αױ�����
		model.addAttribute("log",log);
	}
	
	@RequestMapping(value="group_management/emp_list",method=RequestMethod.GET)//�׷����->�ش� �׷�Ŭ���� ����Ʈ �������ϴ� ���
	public void emp_list(G_Owner_VO vo,Model model) throws Exception
	{
		System.out.println("emp_list�������δ�..");
		System.out.println(vo);
		model.addAttribute("list",g_mgt_service.emp_list(vo));
	}
	
	
	
	@RequestMapping(value="group_management/g_Create",method=RequestMethod.GET)
	public void g_Create(Model model,HttpSession session) throws Exception
	{
		User_VO user_vo = (User_VO)session.getAttribute("user_info");
		String id = user_vo.getId();
		List<GroupList_VO> grouplist_vo;
		grouplist_vo = g_mgt_service.group_list(id);
		model.addAttribute("list", grouplist_vo);
	}
	
	@RequestMapping("group_management/all_emp")
	public String group_all_emp(G_Owner_VO vo,Model model) throws Exception//�׷����->�׷����->�׷쿡 �ش�����ʴ� ����鸸 ����Ʈ�����ֱ�
	{
		System.out.println("test123");
		model.addAttribute("all_list",g_mgt_service.all_emp_list(vo));
		return "terrier/group_management/g_EmpList_All";
	}
	
	@RequestMapping("group_management/all_emp_empty")
	public String group_all_emp_empty(G_Owner_VO vo,Model model) throws Exception//�׷쿡 ���Ե����ʴ� �ο��̱�
	{
		List<Employee_VO> list;
		list = g_mgt_service.all_emp_list(vo);
		model.addAttribute("all_list",list);
		return "terrier/group_management/g_EmpList_A_empty"; //g_Create.jsp->$("#all_emp")�� ����jsp�� ����
	}
	
	@RequestMapping("group_management/in_group_emp")
	public String group_in_group_emp(G_Owner_VO vo,Model model) throws Exception//�׷쿡 ���ԵǾ��ִ� �ο��̱�
	{
		List<Employee_VO> list;
		list = g_mgt_service.emp_list(vo);
		model.addAttribute("group_list",list);
		return "terrier/group_management/g_EmpList_InGroup";//g_Create.jsp->$("#in_group_emp")�� ����jsp�� ����
	}
	
	@RequestMapping("group_management/in_group_emp_empty")
	public String group_in_group_emp_empty() throws Exception
	{
		return "terrier/group_management/g_EmpList_G_empty";
	}
	
}
