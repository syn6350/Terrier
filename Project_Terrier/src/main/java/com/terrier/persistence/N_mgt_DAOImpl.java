package com.terrier.persistence;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.terrier.domain.Board_VO;
import com.terrier.domain.Criteria;
import com.terrier.domain.Reply_VO;

@Repository
public class N_mgt_DAOImpl implements N_mgt_DAO {

	private static String namespace="n_mgt_Mapper";
	@Inject
	SqlSession sqlSession;
	
	@Override
	public void n_create(Board_VO vo) throws Exception {//�Խñ� �ۼ�
		sqlSession.insert(namespace+".board_create",vo);
	}

	@Override
	public Board_VO n_read(Integer bno) throws Exception {
		sqlSession.update(namespace+".board_readcnt",bno);
		return sqlSession.selectOne(namespace+".board_read",bno);
	}

	@Override
	public void n_update(Board_VO vo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void n_delete(Integer bno) throws Exception {
		sqlSession.delete(namespace+".board_delete",bno);
	}

	@Override
	public List<Board_VO> n_allList() throws Exception {//��ü ����Ʈ��������.
		// TODO Auto-generated method stub
		
		return sqlSession.selectList(namespace+".all_list");
		
	}

	@Override
	public Date getTime() throws Exception {//new������ ��å
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".getTime");
	}

	@Override
	public List<Board_VO> listPage(int page) throws Exception {//����¡ ����
		if(page<=0)
		{
			page=1;
		}
		page=(page-1)*10;
		//����¡  �˰���..
		return sqlSession.selectList(namespace+".listPage",page);
	}

	@Override
	public List<Board_VO> listCriteria(Criteria cri) throws Exception {//������ ����
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".listCri",cri);
	}

	@Override
	public int countPaging(Criteria cri) throws Exception {//��ü�Խñ�
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".countPaging",cri);
	}

	
	
	
	
	// ��� ����
	@Override
	public List<Reply_VO> n_reply_list(Integer bno) throws Exception {
		return sqlSession.selectList(namespace+".reply_list",bno);
	}

	// ��� ���
	@Override
	public void n_reply_regist(Reply_VO vo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(namespace+".add_replycnt",vo.getParen_bo_no());
		sqlSession.insert(namespace+".reply_regist",vo);
	}

	// ����� ��� ����
	@Override
	public List<Reply_VO> n_reply_re_list(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".reply_reply",bno);
	}

	// ����� ��� ���
	@Override
	public void n_reply_re_regist(Reply_VO vo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace+".reply_reply_regist",vo);
	}

	

}
