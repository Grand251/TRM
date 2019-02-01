package trm.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	@RequestMapping(value="/")
	public String loginFrom(ModelMap model) {
		
		return "loginform";
	}
	
	@RequestMapping(value="login")
	public String login(HttpServletRequest request, ModelMap model) {
		
		String role = request.getParameter("jobTitle");
		switch (role) {
			case "PM":
				return "redirect:/pmdashboard";
			case "SPOC":
				return "redirect:/spocdashboard";
			default:
				return "";
		
		}
		
	}
	
}
