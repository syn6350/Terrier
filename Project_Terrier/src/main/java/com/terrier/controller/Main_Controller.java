package com.terrier.controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("terrier/*")
public class Main_Controller 
{
	@RequestMapping("logout")//main->�α׾ƿ� ��������
	public String logout(HttpSession session,RedirectAttributes rttr)
	{
		session.invalidate();
		rttr.addFlashAttribute("msg","logout");
		return "redirect:/user/login";
	}

	@RequestMapping("main")//�α��� ->main
	public void main(Model model)
	{
		System.out.println("���� ������ ����");
	}

}
