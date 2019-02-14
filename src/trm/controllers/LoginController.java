package trm.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import trm.dao.employee.Employee;
import trm.dao.employee.EmployeeCRUDService;

@Controller
public class LoginController {
	@RequestMapping(value="/")
	public String rooRedirect(ModelMap model) {
		
		return "redirect:/loginform";
	}
	
	@RequestMapping(value="loginform")
	public String loginForm(HttpServletRequest request, ModelMap model) {
		request.getSession().invalidate();
		request.getSession().setAttribute("user", null);
		return "loginform";
	}
	
	@RequestMapping(value="login")
	public String login(HttpServletRequest request, ModelMap model) {
		
		request.getSession().invalidate();
		
		EmployeeCRUDService empCrud;
		Employee emp;
		int id = Integer.parseInt(request.getParameter("id"));
		
		try {
			empCrud = new EmployeeCRUDService();
			emp = empCrud.getEmployeeById(id);
		} catch (Exception e) {
			return "redirect:/loginform";
		}
		
		emp = empCrud.getEmployeeById(id);
		String role = emp.getJob_title();
		
		request.getSession().setAttribute("user", emp);
		request.getSession().setAttribute("username", emp.getFirst_name() + " " + emp.getLast_name());
		switch (role) {
			case "Project Manager":
				return "redirect:/pmdashboard";
			case "SPOC":
				return "redirect:/viewspocdashboard";
			case "Executive":
				return "redirect:/execdashboard";

			default:
				return "";
		
		}
	}

	@RequestMapping(value="backtodashboard")
	public String backToDashboard(HttpServletRequest request)
	{
		if (request.getSession(false) == null || request.getSession().getAttribute("user") == null)
			return "redirect:/loginform";
		
		Employee emp = (Employee)request.getSession().getAttribute("user");
		
		switch (emp.getJob_title()) {
		case "Project Manager":
			return "redirect:/pmdashboard";
		case "SPOC":
			return "redirect:/viewspocdashboard";
		case "Executive":
			return "redirect:/execdashboard";
		}
		
		return "error";
	}
	
	@RequestMapping(value="logout")
	public String logout(HttpServletRequest request, ModelMap model) {
		
		request.getSession().invalidate();
		
		return "redirect:/loginform";
	}
}
