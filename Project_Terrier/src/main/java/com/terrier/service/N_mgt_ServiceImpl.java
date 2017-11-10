package com.terrier.service;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.terrier.domain.Board_VO;
import com.terrier.domain.Criteria;
import com.terrier.domain.Reply_VO;
import com.terrier.persistence.N_mgt_DAO;

@Service 
public class N_mgt_ServiceImpl implements N_mgt_Service {

	@Inject
	N_mgt_DAO dao;
	
	@Override
	public void n_regist(Board_VO vo) throws Exception {
		dao.n_create(vo);//�ۛ�����.
		
	}

	@Override
	public Board_VO n_read(Integer bno) throws Exception {
		
		return dao.n_read(bno);
	}

	@Override
	public void n_modify(Board_VO vo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void n_remove(Integer bno) throws Exception {
		dao.n_delete(bno);
		
	}

	@Override
	public List<Board_VO> n_allList() throws Exception {
		// TODO Auto-generated method stub
		return dao.n_allList();
	}

	@Override
	public Date n_getTime() throws Exception {
		// TODO Auto-generated method stub
		return dao.getTime();
	}

	@Override
	public List<Board_VO> listPage(int page) throws Exception {//������
		// TODO Auto-generated method stub
		return dao.listPage(page);
	}

	@Override
	public List<Board_VO> listCriteria(Criteria cri) throws Exception {//����¡ó�� ����
		// TODO Auto-generated method stub
		return dao.listCriteria(cri);
	}

	@Override
	public int countPaging(Criteria cri) throws Exception {//�Խñ� �Ѱ��� Ȯ��.
		// TODO Auto-generated method stub
		return dao.countPaging(cri);
	}

	
	
	// ��� ����Ʈ ��ȸ
	@Override
	public List<Reply_VO> n_reply_list(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		return dao.n_reply_list(bno);
	}

	// ��� ���
	@Override
	public void n_reply_regist(Reply_VO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.n_reply_regist(vo);
	}

	// ����� ��� ����Ʈ ��ȸ
	@Override
	public List<Reply_VO> n_reply_re_list(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		return dao.n_reply_re_list(bno);
	}

	// ����� ��� ���
	@Override
	public void n_reply_re_regist(Reply_VO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.n_reply_re_regist(vo);
	}



}
