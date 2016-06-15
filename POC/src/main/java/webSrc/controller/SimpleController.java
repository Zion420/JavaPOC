package webSrc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SimpleController {

	public SimpleController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping("/helloworld")
	public ModelAndView hello() {
		String helloWorldMessage = "Cheers";
		return new ModelAndView("hello", "message", helloWorldMessage);
	}

}
