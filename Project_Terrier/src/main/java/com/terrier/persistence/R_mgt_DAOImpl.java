package com.terrier.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.terrier.domain.Criteria;
import com.terrier.domain.R_mgt_list_VO;
import com.terrier.domain.R_mgt_read_VO;
import com.terrier.domain.R_mgt_search_VO;

@Repository
public class R_mgt_DAOImpl implements R_mgt_DAO {

	private static String namespace="R_mgt_Mapper";
	@Inject
	SqlSession sqlSession;
	
	@Override
	public List<R_mgt_list_VO> listCriteria(Criteria cri, String w_c) throws Exception {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("cri", cri);
		map.put("w_c", w_c);
		
		return sqlSession.selectList(namespace+".r_list",map);
	}
	@Override
	public int countPaging(Criteria cri, String w_c) throws Exception {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("w_c", w_c);
		return sqlSession.selectOne(namespace+".countPaging",map);
	}
	@Override
	public List<R_mgt_list_VO> listCriteria(Criteria cri, R_mgt_search_VO vo, String w_c) throws Exception {
		// TODO Auto-generated method stub
		HashMap<String , Object> map = new HashMap<String , Object>();
		map.put("cri",cri);
		
		if(!vo.getTitle().equals(""))
			vo.setTitle("%"+vo.getTitle()+"%");
		if(!vo.getDate().equals(""))
			vo.setDate(vo.getDate()+"%");
		map.put("vo", vo);
		map.put("w_c", w_c);
		
		return sqlSession.selectList(namespace+".r_list_s",map);
	}
	@Override
	public int countPaging(Criteria cri, R_mgt_search_VO vo, String w_c) throws Exception {
		// TODO Auto-generated method stub
		HashMap<String , Object> map = new HashMap<String , Object>();
		
		if(!vo.getTitle().equals(""))
			vo.setTitle("%"+vo.getTitle()+"%");
		if(!vo.getDate().equals(""))
			vo.setDate(vo.getDate()+"%");
		
		map.put("vo", vo);
		map.put("w_c", w_c);
		
		return sqlSession.selectOne(namespace+".countPaging_s",map);
	}
	
	
	/////////////////////////////////////////////////////////////////////////////////////////
	
	
	@Override
	public R_mgt_read_VO read_request(int bno) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".r_read",bno);
	}
	@Override
	public void request_grant(int bno) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(namespace+".r_grant",bno);
	}
	@Override
	public void request_deny(int bno) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(namespace+".r_deny",bno);
	}
	
	

}
