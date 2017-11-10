package com.terrier.service;

import java.util.Date;
import java.util.List;

import com.terrier.domain.Board_VO;
import com.terrier.domain.Criteria;
import com.terrier.domain.Reply_VO;

public interface N_mgt_Service {

	public void n_regist(Board_VO vo)throws Exception;//����create
	public Board_VO n_read(Integer bno)throws Exception;//�б�read
	public void n_modify(Board_VO vo)throws Exception;//����update
	public void n_remove(Integer bno)throws Exception;//����delete
	public List<Board_VO> n_allList()throws Exception;//��ü����ƮallList
	public Date n_getTime()throws Exception;//���� ��¥ ���
	
	public List<Board_VO>listPage(int page)throws Exception;//����¡ó��-1�������� 10���� ǥ��
	public List<Board_VO>listCriteria(Criteria cri) throws Exception;//�ϴ�����¡- �� �Խñۿ����� �ϴ�����¡����
	public int countPaging(Criteria cri)throws Exception;//�� �Խñ� ī��Ʈ
	
	//��� ó��
	public List<Reply_VO> n_reply_list(Integer bno)throws Exception;// ��� ����
	public void n_reply_regist(Reply_VO vo)throws Exception; // ��� ���
	public List<Reply_VO> n_reply_re_list(Integer bno)throws Exception; // ����� ��� ����
	public void n_reply_re_regist(Reply_VO vo)throws Exception; // ����� ��� ���
}
