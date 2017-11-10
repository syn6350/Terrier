package com.terrier.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.terrier.domain.Criteria;
import com.terrier.domain.R_mgt_list_VO;
import com.terrier.domain.R_mgt_read_VO;
import com.terrier.domain.R_mgt_search_VO;
import com.terrier.persistence.R_mgt_DAO;

@Service 
public class R_mgt_ServiceImpl implements R_mgt_Service {

	@Inject
	R_mgt_DAO dao;

	@Override
	public List<R_mgt_list_VO> listCriteria(Criteria cri, String w_c) throws Exception {
		// TODO Auto-generated method stub
		return dao.listCriteria(cri, w_c);
	}

	@Override
	public int countPaging(Criteria cri, String w_c) throws Exception {
		// TODO Auto-generated method stub
		return dao.countPaging(cri, w_c);
	}

	@Override
	public List<R_mgt_list_VO> listCriteria(Criteria cri, R_mgt_search_VO vo, String w_c) throws Exception {
		// TODO Auto-generated method stub
		return dao.listCriteria(cri, vo, w_c);
	}

	@Override
	public int countPaging(Criteria cri, R_mgt_search_VO vo, String w_c) throws Exception {
		// TODO Auto-generated method stub
		return dao.countPaging(cri, vo, w_c);
	}

	@Override
	public R_mgt_read_VO read_request(int bno) throws Exception {
		// TODO Auto-generated method stub
		return dao.read_request(bno);
	}

	@Override
	public void request_grant(int bno) throws Exception {
		// TODO Auto-generated method stub
		dao.request_grant(bno);
	}

	@Override
	public void request_deny(int bno) throws Exception {
		// TODO Auto-generated method stub
		dao.request_deny(bno);
	}
}
