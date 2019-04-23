package com.propofol.www.service;

import com.propofol.www.dao.PortfolioDAO;
import com.propofol.www.domain.AboutMeSearch;
import com.propofol.www.vo.AboutMeVO;

public class AboutMeService {
	private PortfolioDAO p_dao;
	
	public AboutMeService() {
		p_dao = PortfolioDAO.getInstance();
		
	} // AboutMeService
	
	// -------------------- �ڱ�Ұ� ���� -------------------- //
	
	/**
	 * �ڱ�Ұ� ��ȸ
	 * @param user_id
	 * @return
	 */
	public AboutMeSearch searchAboutMe(String user_id) {
		AboutMeSearch am_search = null;
		
		// DAO ����
		
		
		return am_search;
	} // searchAboutMe
	
	/**
	 * �ڱ�Ұ� �߰�
	 * @param am_vo
	 * @return
	 */
	public int addAboutMe(AboutMeVO am_vo) {
		int result = 0;
		
		// DAO ����
		
		
		return result;
	} // addAboutMe
	
	/**
	 * �ڱ�Ұ� ����
	 * @param am_vo
	 * @return
	 */
	public int modifyAboutMe(AboutMeVO am_vo) {
		int result = 0;
		
		// DAO ����
		
		
		return result;
	} // modifyAboutMe
	
	/**
	 * �ڱ�Ұ� �ʱ�ȭ (�ش� ���̵��� ���̺� �����ϴ� ������ ����)
	 * @param user_id
	 * @return
	 */
	public int resetAboutMe(String user_id) {
		int result = 0;
		
		// DAO ����
		
		
		return result;
	} // resetAboutMe
	
	// -------------------- �ڱ�Ұ� ���� -------------------- //
	
} // class
