package com.propofol.www.user.portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.propofol.www.user.portfolio.domain.MyPortfolioSearch;
import com.propofol.www.user.portfolio.service.MyPortfolioService;
import com.propofol.www.user.portfolio.vo.ExperienceVO;
import com.propofol.www.user.portfolio.vo.MyPortfolioVO;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class PortfolioController {
	
	@Autowired(required=false)
	private MyPortfolioService mp_service;
	
	/**
	 * �� ��Ʈ������ ���� ȭ�� ���� ������
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/portfolio/myPortfolio.do", method={GET, POST})
	public String moveMyPortfolio(HttpSession session) {
		String user_id = (String) session.getAttribute("user_id");
		
		// temp value
		user_id = "young";
		
		return "forward:/portfolio/chkLogin.do?user_id=" + user_id;
	} // moveMyPortfolio
	
	/**
	 * Session���� �α��� ���θ� Ȯ���Ͽ�, ���� writeState�� �Ѱ��ش�.
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/portfolio/chkLogin.do", method={GET, POST})
	public String chkLogin(@RequestParam(name="user_id") String user_id) {
		int loginCnt = 0;
		
		String url = "";
		
		loginCnt = mp_service.chkLogin(user_id);
		
		// �α��� ���¿� ���� �б�
		if (loginCnt == 0) {
			// user_id�� null�̸� loginForm���� �̵�
			url = "loginForm.do";
		} // end if
		
		if (loginCnt == 1) {
			// user_id�� null�� �ƴϸ� writeState�� �̵�
			url = "forward:/portfolio/writeState.do";
		} // end else
		
		return url;
	} // chkLogin
	
	/**
	 * ��Ʈ������ ��� ���� Ȯ��
	 * @param user_id
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/portfolio/writeState.do", method={GET, POST})
	public String writeState(@RequestParam(name="user_id") String user_id, HttpSession session) {
		int result = 0;
		
		String session_id = (String) session.getAttribute("user_id");
		String url = "";
		
		System.out.println("session_id = " + session_id + " / user_id = " + user_id);
		
		if (user_id.equals(session_id)) {
			// portfolio ���̺��� user_id�� �����ϸ� result�� 1�̰�, ������ 0
			// user_id ���� ������ ���� 1 �Ǵ� 0�� ��ȯ
			result = mp_service.chkWriteState(user_id);
		} // end if
		
		// temp value
		result = 1;
		
		// �α��� ���¿� ���� �б�
		if (result == 0) {
			// user_id�� null�̸� loginForm���� �̵�
			url = "loginForm.do";
		} // end if
		
		if (result == 1) {
			// user_id�� null�� �ƴϸ� showMyPortfolio�� �̵�
			url = "forward:/portfolio/showMyPortfolio.do";
		} // end if
		
		return url;
	} // writeState
	
	/**
	 * ��Ʈ������ ��ȸ ����
	 * @param user_id
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/portfolio/showMyPortfolio.do", method={GET, POST})
	public String showMyPortfolio(@RequestParam(name="user_id") String user_id, HttpSession session, Model model) {
		String session_id = (String) session.getAttribute("user_id");
		
		if (user_id.equals(session_id)) {
			// ��Ʈ������ ��ȸ (������, ����)
			MyPortfolioSearch mp_search = mp_service.searchMyPortfolio(user_id);
			
			model.addAttribute("mp_search", mp_search);
			model.addAttribute("isExist", true);
		} // end if
		
		System.out.println("----- showMyPortfolio�� ���� : " + user_id);
		
		// temp line
		MyPortfolioSearch mp_search = mp_service.searchMyPortfolio(user_id);
		model.addAttribute("mp_search", mp_search);
		model.addAttribute("isExist", true);
		
		return "portfolio/myPortfolio";
	} // moveMyPortfolio
	
	@RequestMapping(value="/portfolio/myPortfolioAdd.do", method=POST)
	public String addMyPortfolio(MyPortfolioVO mp_vo, HttpSession session) {
		String session_id = (String) session.getAttribute("user_id");
		
		// ��Ʈ������ �߰�
		
		
		return "redirect:/portfolio/myPortfolio.do";
	} // addMyPortfolio
	
	/**
	 * ��Ʈ������ ����
	 * multipart/form-data�� parameter�� VO�� ���� �� ����.
	 * @param mp_vo
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/portfolio/myPortfolioModify.do", method=POST)
	public String modifyMyPortfolio(HttpServletRequest request, HttpSession session, Model model) {
		int result = 0;
		
		String user_id = (String) session.getAttribute("user_id");
		String moveURL = "redirect:/error/error.html";
		
		request.setAttribute("user_id", user_id);
		
		try {
			result = mp_service.modifyMyPortfolio(request);
			
			if (result == 1) {
				moveURL = "forward:myPortfolio.do";
				
				// ������� �۾� ���� (19-04-26 18:08)
				model.addAttribute("msg", user_id + "���� ��Ʈ�������� ���������� �����Ǿ����ϴ�!");
			} // end if
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} // end catch
		
		return moveURL;
	} // modifyMyPortfolio
	
	@RequestMapping(value="/portfolio/myPortfolioRemove.do", method=GET)
	public String removeMyPortfolio(HttpSession session) {
		String session_id = (String) session.getAttribute("user_id");
		
		// ��Ʈ������ ����
		
		
		return "redirect:/portfolio/myPortfolio.do";
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
	public String experienceForm(@RequestParam(name="exp_cd", defaultValue="Edu", required=false) String exp_cd, HttpSession session, Model model) {
		// session�� ����� ���̵� �޾Ƽ� ���� ���迡 ��ϵ� ������ ��ȸ
		String user_id = (String) session.getAttribute("user_id");
		
		System.out.println("----- exp_cd val=" + exp_cd);
		
		// ���� ���� ���� ��ȸ
		if ("Prj".equals(exp_cd)) {
			// ������Ʈ ���� ���� ���� ��
		} // end if
		
		if ("Edu".equals(exp_cd)) {
			// �������� ���� ���� ���� ��
		} // end if
		
		model.addAttribute("exp_cd", exp_cd);
		
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
