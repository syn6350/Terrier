package com.terrier.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.terrier.domain.Control_count_VO;
import com.terrier.domain.Dep_ctl_status_VO;

@Repository
public class S_mgt_DAOImpl implements S_mgt_DAO {

	private static String namespace="S_mgt_Mapper";
	@Inject
	SqlSession sqlSession;
	
	@Override
	public Control_count_VO control_count(String status) {
		return sqlSession.selectOne(namespace+".control_status_count",status);
	}

	@Override
	public int dep_ctl_on_count(String department) {
		return sqlSession.selectOne(namespace+".department_control_on",department);
	}

	@Override
	public Control_count_VO dep_ctl_status(Dep_ctl_status_VO vo) {
		return sqlSession.selectOne(namespace+".department_control_status",vo);
	}

}
