package com.terrier.service;

import java.util.List;

import com.terrier.domain.Criteria;
import com.terrier.domain.R_mgt_list_VO;
import com.terrier.domain.R_mgt_read_VO;
import com.terrier.domain.R_mgt_search_VO;

public interface R_mgt_Service {
	public List<R_mgt_list_VO> listCriteria(Criteria cri, String w_c) throws Exception;
	public int countPaging(Criteria cri, String w_c)throws Exception;
	
	public List<R_mgt_list_VO> listCriteria(Criteria cri, R_mgt_search_VO vo, String w_c) throws Exception;
	public int countPaging(Criteria cri, R_mgt_search_VO vo, String w_c)throws Exception;//검색 게시글 카운트
	
	public R_mgt_read_VO read_request(int bno)throws Exception;
	
	public void request_grant(int bno)throws Exception;
	public void request_deny(int bno)throws Exception;
}
