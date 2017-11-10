package com.terrier.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.terrier.domain.Board_VO;
import com.terrier.domain.Criteria;
import com.terrier.domain.PageMaker;
import com.terrier.domain.Reply_VO;
import com.terrier.domain.User_VO;
import com.terrier.interceptor.Session_Interceptor;
import com.terrier.service.N_mgt_Service;

@Controller
@RequestMapping("terrier/*")
public class Notice_Controller {
	@Inject
	N_mgt_Service n_mgt_service;
	
	@RequestMapping(value="notice_management/n_mgt",method=RequestMethod.GET)
	public void n_mgt2GET(@ModelAttribute("cri")Criteria cri,Model model)throws Exception
	{
		model.addAttribute("list", n_mgt_service.listCriteria(cri));
		
		PageMaker pageMaker=new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(n_mgt_service.countPaging(cri));
		model.addAttribute("pageMaker",pageMaker);
		
		System.out.println("�Խ��� ����..");
		Date time=n_mgt_service.n_getTime();
		
		System.out.println("����" + time.toString());
		
		model.addAttribute("time",time);
		//����¡ó�� �Խ��� ����Ʈ ��������
	}
		
	@RequestMapping(value="notice_management/n_create",method=RequestMethod.GET)//�ۼ� ó��������
	public void n_createGET(HttpServletRequest request,Model model)
	{
		HttpSession session=request.getSession();
		User_VO user_vo=(User_VO) session.getAttribute("user_info");
				
		Board_VO board_vo =new Board_VO();
		board_vo.setWriter(user_vo.getId());//���� ���̵� ����
		model.addAttribute("writer",board_vo.getWriter());//�Խ��� �ۼ��� ������ �ٿ���		
	}
	@RequestMapping(value="notice_management/n_create",method=RequestMethod.POST)//�ۼ� �Ϸ�������
	public String n_createPOST(Board_VO vo,RedirectAttributes rttr)throws Exception
	{
		System.out.println(vo.toString());
		n_mgt_service.n_regist(vo);
		
		//System.out.println(file.getOriginalFilename() + "  ,  " + file.getSize());
		
		rttr.addFlashAttribute("msg","OK");
		return "redirect:n_mgt";
	}
	
	@RequestMapping(value="notice_management/n_read",method=RequestMethod.GET)//������
	public void n_readGET(@RequestParam("bno")int bno,@RequestParam("page")int page,@RequestParam("perPageNum")int perPageNum,
			Model model)throws Exception
	{
		Board_VO vo=n_mgt_service.n_read(bno);
		List<Reply_VO> re_vo=n_mgt_service.n_reply_list(bno);
		List<Reply_VO> re_re_vo=null;
		
		if(re_vo.size() != 0)
			re_re_vo = n_mgt_service.n_reply_re_list(bno);
		
		model.addAttribute("page",page);
		model.addAttribute("perPageNum",perPageNum);
		model.addAttribute("vo",vo);
		model.addAttribute("re_vo",re_vo);
		model.addAttribute("re_re_vo",re_re_vo);
	}
	
	//test
	@RequestMapping(value="notice_management/n_read_test",method=RequestMethod.GET)//������
	public void n_readGET_test(@RequestParam("bno")int bno,@RequestParam("page")int page,@RequestParam("perPageNum")int perPageNum,
			Model model)throws Exception
	{
		Board_VO vo=n_mgt_service.n_read(bno);
		model.addAttribute("page",page);
		model.addAttribute("perPageNum",perPageNum);
		model.addAttribute("vo",vo);
	}
	
	@RequestMapping(value="notice_management/n_remove",method=RequestMethod.POST)//�����Ҷ�
	public String n_removePOST(@ModelAttribute("cri")Criteria cri, @RequestParam("bno")int bno,Model model,
			HttpServletRequest request,@RequestParam("writer")String writer,
			RedirectAttributes rttr)throws Exception
	{
		HttpSession session=request.getSession();
		User_VO vo=(User_VO)session.getAttribute("user_info");
		
		//�α��� ����ڿ� �Խñ� �ۼ��� ���Ͽ� ���� ���� ����
		if(vo.getId().equals(writer))
		{
			rttr.addFlashAttribute("r_msg","OK");
			n_mgt_service.n_remove(bno);
			return "redirect:n_mgt";
		}
		else
		{
			rttr.addFlashAttribute("r_msg","NO");
			return "redirect:n_mgt";
		}
	}
	@RequestMapping(value="notice_management/n_modify",method=RequestMethod.GET)//�����Ҷ�
	public void modifyGET(HttpServletRequest request,Model model,
			@RequestParam("writer")String writer, @RequestParam("bno")int bno)throws Exception
	{
		HttpSession session=request.getSession();
		User_VO vo=(User_VO)session.getAttribute("user_info");
		
		if(vo.getId().equals(writer))
		{
			//������������
//			Board_VO b_vo=n_mgt_service.n_read(bno);
//			b_vo.setContent(content);
//			b_vo.setTitle(title);
//			n_mgt_service.n_regist(b_vo);
//			�� ������ post���� �� ����
			
			//modify_from �������� ������ �ۼ��ϰ�����.
			//�ٽ� n_modify.post�� ���� �����̴�.
		}
		else
		{
			//�������Ѿ���
		}
	}
	@RequestMapping(value="notice_management/n_modify",method=RequestMethod.POST)//������ ����
	public void modifyPOST(Model model)
	{
		
	}
	
	
}
