package webSrc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.apache.log4j.Logger;

@Controller
public class SimpleController {

	public SimpleController() {
		// TODO Auto-generated constructor stub
	}
	private static final Logger logger = Logger.getLogger(SimpleController.class);
	@RequestMapping("/helloworld")
	public ModelAndView hello() {
		String helloWorldMessage = "Cheers";
		if(logger.isDebugEnabled()){
			logger.debug("helloworld is executed");
		}
		return new ModelAndView("hello", "message", helloWorldMessage);
	}

}
