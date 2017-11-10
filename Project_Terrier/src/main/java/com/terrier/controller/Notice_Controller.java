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
		
		System.out.println("게시판 접근..");
		Date time=n_mgt_service.n_getTime();
		
		System.out.println("제발" + time.toString());
		
		model.addAttribute("time",time);
		//페이징처리 게시판 리스트 가져오기
	}
		
	@RequestMapping(value="notice_management/n_create",method=RequestMethod.GET)//작성 처음들어갔을떄
	public void n_createGET(HttpServletRequest request,Model model)
	{
		HttpSession session=request.getSession();
		User_VO user_vo=(User_VO) session.getAttribute("user_info");
				
		Board_VO board_vo =new Board_VO();
		board_vo.setWriter(user_vo.getId());//세션 아이디값 저장
		model.addAttribute("writer",board_vo.getWriter());//게시판 작성자 고정값 줄예정		
	}
	@RequestMapping(value="notice_management/n_create",method=RequestMethod.POST)//작성 완료했을때
	public String n_createPOST(Board_VO vo,RedirectAttributes rttr)throws Exception
	{
		System.out.println(vo.toString());
		n_mgt_service.n_regist(vo);
		
		//System.out.println(file.getOriginalFilename() + "  ,  " + file.getSize());
		
		rttr.addFlashAttribute("msg","OK");
		return "redirect:n_mgt";
	}
	
	@RequestMapping(value="notice_management/n_read",method=RequestMethod.GET)//읽을떄
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
	@RequestMapping(value="notice_management/n_read_test",method=RequestMethod.GET)//읽을떄
	public void n_readGET_test(@RequestParam("bno")int bno,@RequestParam("page")int page,@RequestParam("perPageNum")int perPageNum,
			Model model)throws Exception
	{
		Board_VO vo=n_mgt_service.n_read(bno);
		model.addAttribute("page",page);
		model.addAttribute("perPageNum",perPageNum);
		model.addAttribute("vo",vo);
	}
	
	@RequestMapping(value="notice_management/n_remove",method=RequestMethod.POST)//삭제할때
	public String n_removePOST(@ModelAttribute("cri")Criteria cri, @RequestParam("bno")int bno,Model model,
			HttpServletRequest request,@RequestParam("writer")String writer,
			RedirectAttributes rttr)throws Exception
	{
		HttpSession session=request.getSession();
		User_VO vo=(User_VO)session.getAttribute("user_info");
		
		//로그인 사용자와 게시글 작성자 비교하여 삭제 여부 진행
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
	@RequestMapping(value="notice_management/n_modify",method=RequestMethod.GET)//수정할때
	public void modifyGET(HttpServletRequest request,Model model,
			@RequestParam("writer")String writer, @RequestParam("bno")int bno)throws Exception
	{
		HttpSession session=request.getSession();
		User_VO vo=(User_VO)session.getAttribute("user_info");
		
		if(vo.getId().equals(writer))
		{
			//수정권한있음
//			Board_VO b_vo=n_mgt_service.n_read(bno);
//			b_vo.setContent(content);
//			b_vo.setTitle(title);
//			n_mgt_service.n_regist(b_vo);
//			이 로직은 post에서 쓸 예정
			
			//modify_from 페이지에 보내서 작성하게한후.
			//다시 n_modify.post로 보낼 예정이다.
		}
		else
		{
			//수정권한없음
		}
	}
	@RequestMapping(value="notice_management/n_modify",method=RequestMethod.POST)//실질적 수정
	public void modifyPOST(Model model)
	{
		
	}
	
	
}
