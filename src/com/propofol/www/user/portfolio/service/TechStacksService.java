package com.propofol.www.user.portfolio.service;

import com.propofol.www.user.dao.PortfolioDAO;
import com.propofol.www.user.portfolio.domain.TechStacksSearch;
import com.propofol.www.user.portfolio.vo.TechStacksVO;

public class TechStacksService {
	private PortfolioDAO p_dao;
	
	public TechStacksService() {
		p_dao = PortfolioDAO.getInstance();
		
	} // TechStacksService
	
	// -------------------- ��� ���� ���� -------------------- //
	
	/**
	 * ��� ���� ��ȸ
	 * @param user_id
	 * @return
	 */
	public TechStacksSearch searchTechStacks(String user_id) {
		TechStacksSearch ts_search = null;
		
		// DAO ����
		
		
		return ts_search;
	} // searchTechStacks
	
	/**
	 * ��� ���� �߰�
	 * @param am_vo
	 * @return
	 */
	public int addTechStacks(TechStacksVO am_vo) {
		int result = 0;
		
		// DAO ����
		
		
		return result;
	} // addTechStacks
	
	/**
	 * ��� ���� ����
	 * @param am_vo
	 * @return
	 */
	public int modifyTechStacks(TechStacksVO am_vo) {
		int result = 0;
		
		// DAO ����
		
		
		return result;
	} // modifyTechStacks
	
	/**
	 * ��� ���� �ʱ�ȭ (�ش� ���̵��� ���̺� �����ϴ� ������ ����)
	 * @param user_id
	 * @return
	 */
	public int resetTechStacks(String user_id) {
		int result = 0;
		
		// DAO ����
		
		
		return result;
	} // resetTechStacks
	
	// -------------------- ��� ���� ���� -------------------- //
	
} // class
