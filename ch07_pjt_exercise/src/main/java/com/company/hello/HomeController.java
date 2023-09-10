package com.company.hello;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller // Controller 애너테이션을 이용해서 클래스가 Controller 빈 객체로 사용될 수 있도록 함
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET) // RequestMapping 애너테이션을 이용해서 home 메서드를 '/'로 URL 매핑
	public String home(Locale locale, Model model /* home() 메서드 실행 후 뷰에 전달되는 데이터 객체 */) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date); 
		
		model.addAttribute("serverTime", formattedDate ); // Model 객체에 'serverTime' 이름으로 데이터를 담음
		
		return "home"; // View에 필요한 정보를 home 값으로 반환함, 반환된 'home'은 '/WEB-INF/views/home.jsp'를 찾는데 이용됨
	}
	
}
