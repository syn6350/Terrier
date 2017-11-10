package com.terrier.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.terrier.domain.Employee_VO;
import com.terrier.domain.G_Owner_VO;
import com.terrier.domain.G_mgt_log_VO;
import com.terrier.domain.GroupList_VO;
import com.terrier.domain.Group_VO;

@Repository
public class G_mgt_DAOImpl implements G_mgt_DAO {

	private static String namespace="g_mgt_Mapper";
	
	@Inject
	SqlSession sqlSession;
	
	@Override
	public List<GroupList_VO> group_list(String id) throws Exception {
		return sqlSession.selectList(namespace+".group_list",id);
	}
	
	@Override
	public List<Employee_VO> emp_list(G_Owner_VO vo) throws Exception {
		return sqlSession.selectList(namespace+".emp_list",vo);
	}
	
	@Override
	public List<Employee_VO> all_emp_list(G_Owner_VO vo) throws Exception {
		return sqlSession.selectList(namespace+".all_emp_list",vo);
	}
	
	@Override
	public int group_check(G_Owner_VO vo) throws Exception {
		return sqlSession.selectOne(namespace+".group_check",vo);
	}

	@Override
	public void group_delete(G_Owner_VO vo) throws Exception {
		sqlSession.delete(namespace+".group_delete",vo);
		return;
	}

	@Override
	public void group_update(List<Group_VO> vo) throws Exception {
		sqlSession.insert(namespace+".group_update",vo);
		return;
	}

	@Override
	public void group_log(G_mgt_log_VO vo) throws Exception {//로그생성
		sqlSession.insert(namespace+".group_log",vo);
		return;
	}

	@Override
	public List<G_mgt_log_VO> group_log_list(String owner) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".group_log_list",owner);
	}
	

}
