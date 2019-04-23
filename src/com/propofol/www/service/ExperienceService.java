package com.propofol.www.service;

import com.propofol.www.dao.PortfolioDAO;
import com.propofol.www.domain.ExperienceSearch;
import com.propofol.www.vo.ExperienceVO;

public class ExperienceService {
	private PortfolioDAO p_dao;
	
	public ExperienceService() {
		p_dao = PortfolioDAO.getInstance();
		
	} // ExperienceService
	
	// -------------------- ���� ���� ���� -------------------- //
	
	/**
	 * ���� ���� ��ȸ
	 * @param user_id
	 * @return
	 */
	public ExperienceSearch searchExperience(String user_id) {
		ExperienceSearch exp_search = null;
		
		// DAO ����
		
		
		return exp_search;
	} // searchExperience
	
	/**
	 * ���� ���� �߰�
	 * @param am_vo
	 * @return
	 */
	public int addExperience(ExperienceVO am_vo) {
		int result = 0;
		
		// DAO ����
		
		
		return result;
	} // addExperience
	
	/**
	 * ���� ���� ����
	 * @param am_vo
	 * @return
	 */
	public int modifyExperience(ExperienceVO am_vo) {
		int result = 0;
		
		// DAO ����
		
		
		return result;
	} // modifyExperience
	
	/**
	 * ���� ���� �ʱ�ȭ (�ش� ���̵��� ���̺� �����ϴ� ������ ����)
	 * @param user_id
	 * @return
	 */
	public int resetExperience(String user_id) {
		int result = 0;
		
		// DAO ����
		
		
		return result;
	} // resetExperience
	
	// -------------------- ���� ���� ���� -------------------- //
	
} // class
