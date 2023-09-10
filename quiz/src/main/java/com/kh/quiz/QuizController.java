package com.kh.quiz;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class QuizController {
	
	@Autowired
	private QuizService quizService;
	
	@RequestMapping("/")
	public String toMainPage() {
		return "index";
	}
	
	@RequestMapping("quizSubmitted")
	public String answerSubmit(QuizDO quizDO, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		boolean correctCheck = true;
		
	    for (int i=1; i<=10; i++) { // 1부터 10까지 반복
	        String question = request.getParameter("question" + i);
	        String answer = request.getParameter("answer" + i);

	        quizDO.setQuestion(question);
	        quizDO.setAnswer(answer);

	        QuizDO result = quizService.submitAnswer(quizDO);
	        
			if(result == null) {
				correctCheck = false;
				break;
			}
		}
		
		if(correctCheck == true) {
			session.setAttribute("answer", "Correct answer");
			return "index";
		}else {
			model.addAttribute("msg","Wrong answer");
			return "error";
		}
	}
}
