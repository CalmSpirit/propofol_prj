package com.propofol.www.user.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.propofol.www.user.portfolio.domain.MyPortfolioSearch;
import com.propofol.www.user.portfolio.vo.MyPortfolioVO;

@Component
public class PortfolioDAO {
	
	@Autowired(required=false)
	private MyBatisDAO mb_dao;
	
	private static PortfolioDAO p_dao;
	
	private PortfolioDAO() {
		mb_dao = MyBatisDAO.getInstance();
		
	} // PortfolioDAO
	
	public static PortfolioDAO getInstance() {
		if (p_dao == null) {
			p_dao = new PortfolioDAO();
		} // end if
		
		return p_dao;
	} // getInstance
	
	
	/**
	 * ��Ʈ������ ��� ���� ��ȸ
	 * @param user_id
	 * @return
	 */
	public int selectWriteState(String user_id) {
		int result = 0;
		
		SqlSession ss = mb_dao.getSessionFactory().openSession();
		
		result = ss.selectOne("writeState", user_id);
		
		ss.close();
		
		return result;
	} // selectWriteState
	
	/**
	 * �� ��Ʈ������ ��ȸ
	 * @param user_id
	 * @return
	 */
	public MyPortfolioSearch selectMyPortfolio(String user_id) {
		MyPortfolioSearch mp_search = null;
		
		SqlSession ss = mb_dao.getSessionFactory().openSession();
		
		mp_search = ss.selectOne("myPortfolio", user_id);
		
		ss.close();
		
		return mp_search;
	} // selectMyPortfolio
	
	/**
	 * �� ��Ʈ������ ���
	 * @param mp_vo
	 * @return
	 */
	public int insertMyPortfolio(MyPortfolioVO mp_vo) {
		int result = 0;
		
		SqlSession ss = mb_dao.getSessionFactory().openSession();
		
		result = ss.insert("insertMyPortfolio", mp_vo);
		
		ss.commit();
		
		ss.close();
		
		return result;
	} // insertMyPortfolio
	
	/**
	 * �� ��Ʈ������ ����
	 * @param mp_vo
	 * @return
	 */
	public int updateMyPortfolio(MyPortfolioVO mp_vo) {
		int result = 0;
		
		SqlSession ss = mb_dao.getSessionFactory().openSession();
		
		result = ss.update("updateMyPortfolio", mp_vo);
		
		ss.commit();
		
		ss.close();
		
		return result;
	} // updateMyPortfolio
	
	/**
	 * �� ��Ʈ������ ����
	 * @param user_id
	 * @return
	 */
	public int deleteMyPortfolio(String user_id) {
		int result = 0;
		
		SqlSession ss = mb_dao.getSessionFactory().openSession();
		
		result = ss.delete("deleteMyPortfolio", user_id);
		
		ss.commit();
		
		ss.close();
		
		return result;
	} // deleteMyPortfolio
	
//	/**
//	 * unit test
//	 * @param args
//	 */
//	public static void main(String[] args) {
////		int result = PortfolioDAO.getInstance().selectWriteState("young");
////		System.out.println(result);
//		
////		MyPortfolioSearch mp_search = PortfolioDAO.getInstance().selectMyPortfolio("young");
////		System.out.println(mp_search.getThumbnail_img() + " / " + mp_search.getTitle() + " / " + mp_search.getPermit_st());
//		
////		int result;
////		MyPortfolioVO mp_vo = new MyPortfolioVO("young", "hello.png", "���� �Ϸ�!", "Y");
////		PortfolioDAO p_dao = new PortfolioDAO();
////		result = p_dao.updateMyPortfolio(mp_vo);
////		result = PortfolioDAO.getInstance().updateMyPortfolio(mp_vo);
////		System.out.println("---- update result = " + result);
//		
////		PortfolioDAO p_dao = new PortfolioDAO();
////		MyPortfolioVO mp_vo = new MyPortfolioVO("jung", "king.png", "���� �������̾�.", "N");
////		int result = p_dao.insertMyPortfolio(mp_vo);
////		System.out.println("��� ���� �� 1 ��ȯ : " + result);
//		
////		PortfolioDAO p_dao = new PortfolioDAO();
////		String user_id = "jung";
////		int result = p_dao.deleteMyPortfolio(user_id);
////		System.out.println("��� ���� �� 1 ��ȯ : " + result);
//		
//	} // main
	
} // class
