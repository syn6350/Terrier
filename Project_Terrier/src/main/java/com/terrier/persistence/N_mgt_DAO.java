package com.terrier.persistence;

import java.util.Date;
import java.util.List;

import com.terrier.domain.Board_VO;
import com.terrier.domain.Criteria;
import com.terrier.domain.Reply_VO;

public interface N_mgt_DAO {


	public void n_create(Board_VO vo)throws Exception;//쓰기create
	public Board_VO n_read(Integer bno)throws Exception;//읽기read
	public void n_update(Board_VO vo)throws Exception;//수정update
	public void n_delete(Integer bno)throws Exception;//삭제delete
	public List<Board_VO> n_allList()throws Exception;//전체리스트allList
	public Date getTime()throws Exception;//현재 시간 구해오기
	
	//페이징 처리
	public List<Board_VO>listPage(int page)throws Exception;//페이징처리-1페이지당 10개씩 표시
	public List<Board_VO>listCriteria(Criteria cri) throws Exception;//하단페이징- 총 게시글에따른 하단페이징분할
	public int countPaging(Criteria cri)throws Exception;//총 게시글 카운트
	
	//댓글 처리
	public List<Reply_VO> n_reply_list(Integer bno)throws Exception; // 댓글 보기
	public void n_reply_regist(Reply_VO vo)throws Exception; // 댓글 등록
	public List<Reply_VO> n_reply_re_list(Integer bno)throws Exception; // 댓글의 댓글 보기
	public void n_reply_re_regist(Reply_VO vo)throws Exception; // 댓글의 댓글 등록
}
