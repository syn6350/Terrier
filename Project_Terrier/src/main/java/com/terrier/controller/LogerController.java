package com.terrier.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("test/*")
public class LogerController {
	
	@RequestMapping("test")
	public void loger()
	{
		System.out.print("·Î±×....");
	}
}
