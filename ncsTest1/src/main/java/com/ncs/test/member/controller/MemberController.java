package com.ncs.test.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ncs.test.member.model.service.MemberService;
import com.ncs.test.member.model.vo.Member;


@Controller
public class MemberController {

    @RequestMapping("/")
    public String logIn() { 
        return "index";
    }
    
    @Autowired
    MemberService memberService;
    
    @RequestMapping("login")
    public String memberLogin(Member member, Model model, HttpServletRequest request ) {
    	HttpSession session = request.getSession();
    	Member logInedMember = memberService.logInConfirm(member);
    	
    	if (logInedMember != null) {
    		session.setAttribute("loginMember", logInedMember);
    		return "index";
    	} else {
    		model.addAttribute("msg","로그인 실패");
    		return "errorPage";	
    	}
    }
}
