package com.terrier.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.terrier.domain.Employee_VO;
import com.terrier.domain.G_Owner_VO;
import com.terrier.domain.G_mgt_log_VO;
import com.terrier.domain.GroupList_VO;
import com.terrier.domain.Group_VO;
import com.terrier.persistence.G_mgt_DAO;

@Service
public class G_mgt_ServiceImpl implements G_mgt_Service {

	@Inject
	G_mgt_DAO dao;
	
	@Override
	public List<GroupList_VO> group_list(String id) throws Exception {
		// TODO Auto-generated method stub
		return dao.group_list(id);
	}
	
	@Override
	public List<Employee_VO> emp_list(G_Owner_VO vo) throws Exception {
		// TODO Auto-generated method stub
		return dao.emp_list(vo);
	}
	
	@Override
	public List<Employee_VO> all_emp_list(G_Owner_VO vo) throws Exception {
		// TODO Auto-generated method stub
		return dao.all_emp_list(vo);
	}
	
	@Override
	public int group_check(G_Owner_VO vo) throws Exception {
		// TODO Auto-generated method stub
		return dao.group_check(vo);
	}

	@Override
	public void group_delete(G_Owner_VO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.group_delete(vo);
	}

	@Override
	public void group_update(List<Group_VO> vo) throws Exception {
		// TODO Auto-generated method stub
		dao.group_update(vo);
	}

	@Override
	public void group_log(G_mgt_log_VO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.group_log(vo);
	}

	@Override
	public List<G_mgt_log_VO> group_log_list(String owner) throws Exception {
		// TODO Auto-generated method stub
		return dao.group_log_list(owner);
	}

}
