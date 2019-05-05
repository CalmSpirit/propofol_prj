package com.propofol.www.user.portfolio.service;

import java.util.ArrayList;
import java.util.List;

import com.propofol.www.user.dao.PortfolioDAO;
import com.propofol.www.user.portfolio.domain.PortfolioListSearch;
import com.propofol.www.user.portfolio.domain.PortfolioViewSearch;

public class PortfolioService {
	private PortfolioDAO p_dao;
	
	public PortfolioService() {
		p_dao = PortfolioDAO.getInstance();
		
	} // PortfolioService
	
	// -------------------- ��Ʈ������ �Խ��� ���� -------------------- //
	
	/**
	 * ��Ʈ������ �Խ��� ��ȸ (�񵿱��)
	 * @param user_id
	 * @return
	 */
	public List<PortfolioListSearch> searchPortfolioList(int index) {
		List<PortfolioListSearch> list = new ArrayList<PortfolioListSearch>();
		
		// DAO ����
		// ajax�� �޾ƿ����� json�� �ʿ��� �� ������?
		
		
		return list;
	} // searchPortfolioList
	
	public PortfolioViewSearch searchPortfolioView(String user_id) {
		PortfolioViewSearch pv_search = null;
		
		// DAO ����
		
		
		return pv_search;
	} // searchPortfolioView
	
	// -------------------- ��Ʈ������ �Խ��� ���� -------------------- //
	
} // class
