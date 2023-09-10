package com.company.hello.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
    @RequestMapping("/signUp")
    public String signUp() { 
        return "sign_up";
    }

    @RequestMapping("/signIn")
    public String signIn()  {
        return "sign_in";
    }
    
    @RequestMapping("/signUpConfirm")
    public String signUpConfirm(/*RequestParam으로 전달하는 방법도 체크 */ MemberVO memberVO)  {
    	System.out.println("[MemberController] signUpConfirm()");
    	
    	System.out.println("m_id: " + memberVO.getM_id());
    	System.out.println("m_pw: " + memberVO.getM_pw());
    	System.out.println("m_mail: " + memberVO.getM_mail());
    	System.out.println("m_phone: " + memberVO.getM_phone());
    	
    	memberService.signUpConfirm(memberVO);
    	return "sign_up_ok";
    }
    
    @Autowired
    MemberService memberService;
    
    @RequestMapping("/signInConfirm")
    public String signInConfirm(MemberVO memberVO) {
    	System.out.println("[MemberController] signInConfirm()");
    	
    	MemberVO signInedMember = memberService.signInConfirm(memberVO);
    	
    	if (signInedMember != null) 
    		return "sign_in_ok";
		else
			return "sign_in_ng";
    }

}
