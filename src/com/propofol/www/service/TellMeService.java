package com.propofol.www.service;

import com.propofol.www.dao.PortfolioDAO;
import com.propofol.www.domain.TellMeSearch;
import com.propofol.www.vo.TellMeVO;

public class TellMeService {
	private PortfolioDAO p_dao;
	
	public TellMeService() {
		p_dao = PortfolioDAO.getInstance();
		
	} // TellMeService
	
	// -------------------- ����ó ���� -------------------- //
	
	/**
	 * ����ó ��ȸ
	 * @param user_id
	 * @return
	 */
	public TellMeSearch searchTellMe(String user_id) {
		TellMeSearch tm_search = null;
		
		// DAO ����
		
		
		return tm_search;
	} // searchTellMe
	
	/**
	 * ����ó �߰�
	 * @param am_vo
	 * @return
	 */
	public int addTellMe(TellMeVO am_vo) {
		int result = 0;
		
		// DAO ����
		
		
		return result;
	} // addTellMe
	
	/**
	 * ����ó ����
	 * @param am_vo
	 * @return
	 */
	public int modifyTellMe(TellMeVO am_vo) {
		int result = 0;
		
		// DAO ����
		
		
		return result;
	} // modifyTellMe
	
	/**
	 * ����ó �ʱ�ȭ (�ش� ���̵��� ���̺� �����ϴ� ������ ����)
	 * @param user_id
	 * @return
	 */
	public int resetTellMe(String user_id) {
		int result = 0;
		
		// DAO ����
		
		
		return result;
	} // resetTellMe
	
	// -------------------- ����ó ���� -------------------- //
	
} // class
