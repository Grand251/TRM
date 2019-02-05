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
	public String loginForm(ModelMap model) {
		
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
		switch (role) {
			case "Project Manager":
				return "redirect:/pmdashboard";
			case "SPOC":
				return "redirect:/viewspocdashboard";
			default:
				return "";
		
		}
	}

	@RequestMapping(value="logout")
	public String logout(HttpServletRequest request, ModelMap model) {
		
		request.getSession().invalidate();
		
		return "redirect:/loginform";
	}
					
	
}
