package com.terrier.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.terrier.domain.G_Owner_VO;
import com.terrier.domain.Group_VO;
import com.terrier.domain.User_VO;
import com.terrier.service.G_mgt_Service;

//�׷���� Data��Ʈ������
@RestController
@RequestMapping("terrier/*")
public class Group_Data_Controller {
	@Inject
	G_mgt_Service g_mgt_service;
	
	@RequestMapping("group_management/group_Check")
	public String group_Duplicate_check(@RequestParam String group_name,HttpSession session) throws Exception
	{
		User_VO user_vo = (User_VO)session.getAttribute("user_info");
		String id = user_vo.getId();		
		G_Owner_VO vo = new G_Owner_VO();
		vo.setGroup_name(group_name);
		vo.setId(id);		
		return String.valueOf(g_mgt_service.group_check(vo));
	}
	@RequestMapping("group_management/group_Delete")
	public void	group_Delete(@RequestParam String group_name,HttpSession session) throws Exception
	{
		User_VO user_vo = (User_VO)session.getAttribute("user_info");
		String id = user_vo.getId();
		
		G_Owner_VO vo = new G_Owner_VO();
		vo.setGroup_name(group_name);
		vo.setId(id);
		
		g_mgt_service.group_delete(vo);
	}	
	@RequestMapping(value="group_management/g_Update",method=RequestMethod.POST)//g_Create���� �迭�� ���� ����
	public void g_CreatListPOST(@RequestParam(value="g_emp_list[]")String[] emp,@RequestParam(value="g_name")String g_name,HttpServletRequest request,Model model)throws Exception
	{	
		List<Group_VO> group =new ArrayList<Group_VO>();
        int size=emp.length;//�׷��˾����� ������ �����
        HttpSession session=request.getSession();
        User_VO vo=(User_VO) session.getAttribute("user_info");

        for(int i=0;i<size;i++)
        {
        	Group_VO gvo=new Group_VO();
        	gvo.setEmployee_num(emp[i]);//�����ȣ
        	gvo.setGroup_name(g_name);//�׷��
        	gvo.setGroup_owner(vo.getId());//���ʾ��̵�
        	group.add(gvo);
        }     
        G_Owner_VO owner_vo = new G_Owner_VO();
        owner_vo.setGroup_name(g_name);
        owner_vo.setId(vo.getId());		
		g_mgt_service.group_delete(owner_vo);	
        g_mgt_service.group_update(group);
        
	}
	
}
