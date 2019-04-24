package com.propofol.www.user.portfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.propofol.www.user.dao.PortfolioDAO;
import com.propofol.www.user.portfolio.domain.MyPortfolioSearch;
import com.propofol.www.user.portfolio.vo.MyPortfolioVO;

@Component
public class MyPortfolioService {
	
	@Autowired(required=false)
	private PortfolioDAO p_dao;
	
	public MyPortfolioService() {
		p_dao = PortfolioDAO.getInstance();
		
	} // MyPortfolioService
	
	// -------------------- ��Ʈ������ ���� ���� -------------------- //
	
	/**
	 * ���̵� null���� üũ (DB ��ȸ X)
	 * @param user_id
	 * @return
	 */
	public int chkLogin(String user_id) {
		int result = 0;
		
		if (user_id != null && !user_id.isEmpty()) {
			result = 1;
		} // end if
		
		return result;
	} // chkLogin
	
	/**
	 * ��Ʈ������ ��� ���� Ȯ�� (���̵� �����ϴ���)
	 * @param user_id
	 * @return
	 */
	public int chkWriteState(String user_id) {
		int result = 0;
		
		// ��Ʈ������ ���̺� ��ȸ ���
		result = p_dao.selectWriteState(user_id);
		
		return result;
	} // chkWriteState
	
	// -------------------- ��Ʈ������ ���� ���� -------------------- //
	
	/**
	 * ��Ʈ������ ��ȸ
	 * @param user_id
	 * @return
	 */
	public MyPortfolioSearch searchMyPortfolio(String user_id) {
		MyPortfolioSearch mp_search = null;
		
		// DAO ����
		mp_search = p_dao.selectMyPortfolio(user_id);
		
		return mp_search;
	} // searchMyPortfolio
	
	/**
	 * ��Ʈ������ �߰�
	 * @param mp_vo
	 * @return
	 */
	public int addMyPortfolio(MyPortfolioVO mp_vo) {
		int result = 0;
		
		// DAO ����
		
		
		return result;
	} // addMyPortfolio
	
	/**
	 * ��Ʈ������ ����
	 * @param mp_vo
	 * @return
	 */
	public int modifyMyPortfolio(MyPortfolioVO mp_vo) {
		int result = 0;
		
		// DAO ����
		
		
		return result;
	} // modifyMyPortfolio
	
	/**
	 * ��Ʈ������ ����
	 * @param user_id
	 * @return
	 */
	public int removeMyPortfolio(String user_id) {
		int result = 0;
		
		// DAO ����
		
		return result;
	} // removeMyPortfolio
	
} // class
