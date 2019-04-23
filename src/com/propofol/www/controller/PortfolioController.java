package com.propofol.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.propofol.www.domain.MyPortfolioSearch;
import com.propofol.www.service.MyPortfolioService;
import com.propofol.www.vo.ExperienceVO;
import com.propofol.www.vo.MyPortfolioVO;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import javax.servlet.http.HttpSession;

@Controller
public class PortfolioController {
	
	@RequestMapping(value="/portfolio/myPortfolio.do", method=GET)
	public String moveMyPortfolio(HttpSession session) {
		String user_id = (String) session.getAttribute("user_id");
		
		user_id = "park";
		
		return "forward:/portfolio/chkLogin.do?user_id=" + user_id;
	} // moveMyPortfolio
	
	/**
	 * Session���� �α��� ���θ� Ȯ���Ͽ�, ���� writeState�� �Ѱ��ش�.
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/portfolio/chkLogin.do", method=GET)
	public String chkLogin(@RequestParam("user_id") String user_id) {
		int loginCnt = 0;
		
		String url = "";
		
		MyPortfolioService mp_service = new MyPortfolioService();
		
		loginCnt = mp_service.chkLogin(user_id);
		
		// �α��� ���¿� ���� �б�
		if (loginCnt == 0) {
			// user_id�� null�̸� loginForm���� �̵�
			url = "loginForm.do";
		} // end if
		
		if (loginCnt == 1) {
			// user_id�� null�� �ƴϸ� writeState�� �̵�
//			url = "forward:/portfolio/writeState.do?user_id=" + user_id;
			url = "forward:/portfolio/writeState.do?";
		} // end else
		
		return url;
	} // chkLogin
	
	@RequestMapping(value="/portfolio/writeState.do", method=GET)
	public String writeState(@RequestParam("user_id") String user_id, HttpSession session) {
		int result = 0;
		
		String session_id = (String) session.getAttribute("user_id");
		String url = "";
		
		System.out.println("session_id = " + session_id);
		System.out.println("user_id = " + user_id);
		
		if (user_id.equals(session_id)) {
			// portfolio ���̺��� user_id�� �����ϸ� result�� 1�̰�, ������ 0
			// DB ��ȸ ���� (Service)
			MyPortfolioService mp_service = new MyPortfolioService();
			
			// user_id ���� ������ ���� 1 �Ǵ� 0�� ��ȯ
//			result = mp_service.chkWriteState(user_id);
		} // end if
		
		result = 1;
		
		// �α��� ���¿� ���� �б�
		if (result == 0) {
			// user_id�� null�̸� loginForm���� �̵�
			url = "loginForm.do";
		} // end if
		
		if (result == 1) {
			// user_id�� null�� �ƴϸ� showMyPortfolio�� �̵�
			url = "forward:/portfolio/showMyPortfolio.do?";
		} // end else
		
		System.out.println("----- writeState������ user_id : " + user_id);
		
		return url;
	} // writeState
	
	@RequestMapping(value="/portfolio/showMyPortfolio.do", method=GET)
	public String showMyPortfolio(@RequestParam("user_id") String user_id, HttpSession session, Model model) {
		String session_id = (String) session.getAttribute("user_id");
		
//		if (user_id.equals(session_id)) {
//			MyPortfolioService mp_service = new MyPortfolioService();
//			
//			// ��Ʈ������ ��ȸ (������, ����)
//			MyPortfolioSearch mp_search = mp_service.searchMyPortfolio(user_id);
//			
//			model.addAttribute("mp_search", mp_search);
//		} // end if
		
		System.out.println("----- showMyPortfolio�� ���� : " + user_id);
		
		return "portfolio/myPortfolio";
	} // moveMyPortfolio
	
	@RequestMapping(value="/portfolio/myPortfolioAdd.do", method=GET)
	public String addMyPortfolio(MyPortfolioVO mp_vo, HttpSession session) {
		String session_id = (String) session.getAttribute("user_id");
		
		// ��Ʈ������ �߰�
		
		
		return "portfolio/showMyPortfolio.do?user_id" + session_id;
	} // addMyPortfolio
	
	@RequestMapping(value="/portfolio/myPortfolioModify.do", method=GET)
	public String modifyMyPortfolio(MyPortfolioVO mp_vo, HttpSession session) {
		String session_id = (String) session.getAttribute("user_id");
		
		// ��Ʈ������ ����
		
		
		return "portfolio/showMyPortfolio.do?user_id" + session_id;
	} // modifyMyPortfolio
	
	@RequestMapping(value="/portfolio/myPortfolioRemove.do", method=GET)
	public String removeMyPortfolio(HttpSession session) {
		String session_id = (String) session.getAttribute("user_id");
		
		// ��Ʈ������ ����
		
		
		return "portfolio/showMyPortfolio.do?user_id" + session_id;
	} // removeMyPortfolio
	
	// -------------------- ��Ʈ������ ���� ���� ó�� ���� -------------------- //
	// -------------------- ��Ʈ������ �ڱ�Ұ� ���� -------------------- //
	
	@RequestMapping(value="/portfolio/aboutMeForm.do", method=GET)
	public String aboutMeForm(HttpSession session) {
		
		
		return "portfolio/aboutMeForm";
	} // aboutMeForm
	
	// -------------------- ��Ʈ������ ��� ���� ���� -------------------- //
	
	@RequestMapping(value="/portfolio/techStacksForm.do", method=GET)
	public String techStacksForm(HttpSession session) {
		
		
		return "portfolio/techStacksForm";
	} // techStacksForm
	
	// -------------------- ��Ʈ������ ���� ���� ���� -------------------- //
	
	@RequestMapping(value="/portfolio/experienceForm.do", method=GET)
	public String experienceForm(HttpSession session) {
		// session�� ����� ���̵� �޾Ƽ� ���� ���迡 ��ϵ� ������ ��ȸ
		String user_id = (String) session.getAttribute("user_id");
		
		// ���� ���� ���� ��ȸ
		
		
		return "portfolio/experienceForm";
	} // experienceForm
	
	@RequestMapping(value="/portfolio/experienceAdd.do", method=GET)
	public String experienceAdd(ExperienceVO exp_vo, HttpSession session) {
		String user_id = (String) session.getAttribute("user_id");
		
		// ���� ���� �߰�
		
		
		return "portfolio/experienceForm";
	} // experienceAdd
	
	@RequestMapping(value="/portfolio/experienceModify.do", method=GET)
	public String experienceModify(ExperienceVO exp_vo, HttpSession session) {
		String user_id = (String) session.getAttribute("user_id");
		
		// ���� ���� ����
		
		
		return "portfolio/experienceForm";
	} // experienceModify
	
	// -------------------- ��Ʈ������ ����ó ���� -------------------- //
	
	@RequestMapping(value="/portfolio/tellMeForm.do", method=GET)
	public String tellMeForm(HttpSession session) {
		
		
		return "portfolio/tellMeForm";
	} // tellMeForm
	
	// -------------------- ��Ʈ������ �Խ��� ���� -------------------- //
	
	@RequestMapping(value="/portfolio/portfolioList.do", method=GET)
	public String movePortfolioList() {
		// ��Ʈ������ ������, ���� ��ȸ ���
		
		return "portfolio/portfolioList";
	} // movePortfolioList
	
} // class
