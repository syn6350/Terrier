package com.terrier.service;

import com.terrier.domain.User_VO;
import com.terrier.dto.User_DTO;


public interface User_Service 
{
	public User_VO login(User_DTO dto)throws Exception; // 로그인 서비스 
}
