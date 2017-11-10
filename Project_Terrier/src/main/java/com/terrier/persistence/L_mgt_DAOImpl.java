package com.terrier.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.terrier.domain.Employee_VO;
import com.terrier.domain.L_mgt_controller_VO;
import com.terrier.domain.L_mgt_lf_log_VO;

@Repository
public class L_mgt_DAOImpl implements L_mgt_DAO {

	private static String namespace = "l_mgt_Mapper";
	@Inject
	SqlSession sqlSession;
	
	@Override
	public L_mgt_controller_VO info(String e_num) throws Exception {
		return sqlSession.selectOne(namespace + ".l_controller",e_num);
	}

	@Override
	public List<Employee_VO> emp_list() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".l_emp_list");
	}

	@Override
	public List<Employee_VO> emp_search_list(Employee_VO vo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".l_emp_search_list",vo);
	}

	@Override
	public Employee_VO emp_dynamic(String emp_num) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".l_emp_dynamic",emp_num);
	}

	@Override
	public String l_lf_date(String emp_num) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".l_lf_date",emp_num);
	}

	@Override
	public List<L_mgt_lf_log_VO> l_lf_log(String l_lf_date, String employee_num) throws Exception {
		// TODO Auto-generated method stub
		Map<String,String> vo = new HashMap<String,String>();
		vo.put("l_lf_date", l_lf_date);
		vo.put("employee_num", employee_num);
		
		return sqlSession.selectList(namespace+".l_lf_log", vo);
	}

	@Override
	public void l_unlock(String employee_num) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace+".l_unlock_log",employee_num);
		sqlSession.update(namespace+".l_unlock_conf",employee_num);
	}

	@Override
	public String l_camera_auth(String employee_num) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".l_camera_auth",employee_num);
	}
}
