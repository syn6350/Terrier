package com.terrier.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.terrier.domain.Criteria;
import com.terrier.domain.PageMaker;
import com.terrier.domain.R_mgt_search_VO;
import com.terrier.service.R_mgt_Service;

@Controller
@RequestMapping("terrier/*")
public class Request_Controller {
	@Inject
	R_mgt_Service r_mgt_service;
	
	// ��û ��� ����Ʈ
	@RequestMapping(value="request_management/w_list",method=RequestMethod.GET)
	public void w_list(@ModelAttribute("cri")Criteria cri,Model model)throws Exception {
		model.addAttribute("list", r_mgt_service.listCriteria(cri,"wait"));
		
		PageMaker pageMaker=new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(r_mgt_service.countPaging(cri,"wait"));
		model.addAttribute("pageMaker",pageMaker);
	}
	
	// ��û ��� ����Ʈ �˻���  
	@RequestMapping(value="request_management/w_list_search",method=RequestMethod.GET)
	public String w_list_search(@ModelAttribute("cri")Criteria cri, R_mgt_search_VO vo, Model model)throws Exception {
		model.addAttribute("vo", vo);
		
		model.addAttribute("list", r_mgt_service.listCriteria(cri,vo,"wait"));
		PageMaker pageMaker=new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(r_mgt_service.countPaging(cri,vo,"wait"));
		model.addAttribute("pageMaker",pageMaker);
		
		
		
		return "terrier/request_management/w_list";
	}
	
	// ��û ��� ����
	@RequestMapping(value="request_management/w_read",method=RequestMethod.GET)
	public void w_read(int bno, Model model)throws Exception {
		model.addAttribute("vo",r_mgt_service.read_request(bno));
		model.addAttribute("bno",bno);
	}
	
	// ��û �Ϸ� ����Ʈ
	@RequestMapping(value="request_management/c_list",method=RequestMethod.GET)
	public void c_list(@ModelAttribute("cri")Criteria cri,Model model)throws Exception {
		model.addAttribute("list", r_mgt_service.listCriteria(cri,"commit")); //�ݴ�� �����ϰ� ��
		
		PageMaker pageMaker=new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(r_mgt_service.countPaging(cri,"commit"));
		model.addAttribute("pageMaker",pageMaker);
	}
	
	// ��û �Ϸ� ����Ʈ �˻���  
	@RequestMapping(value="request_management/c_list_search",method=RequestMethod.GET)
	public String c_list_search(@ModelAttribute("cri")Criteria cri, R_mgt_search_VO vo, Model model)throws Exception {
		model.addAttribute("vo", vo);
		
		model.addAttribute("list", r_mgt_service.listCriteria(cri,vo,"commit"));
		PageMaker pageMaker=new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(r_mgt_service.countPaging(cri,vo,"commit"));
		model.addAttribute("pageMaker",pageMaker);
		
		
		
		return "terrier/request_management/c_list";
	}
	
	// ��û �Ϸ� ����
	@RequestMapping(value="request_management/c_read",method=RequestMethod.GET)
	public void c_read(int bno, Model model)throws Exception {
		model.addAttribute("vo",r_mgt_service.read_request(bno));
		model.addAttribute("bno",bno);
	}
}
