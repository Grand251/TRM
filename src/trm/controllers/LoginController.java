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
	public String loginFrom(ModelMap model) {
		
		return "loginform";
	}
	
	@RequestMapping(value="login")
	public String login(HttpServletRequest request, ModelMap model) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		EmployeeCRUDService empCrud = new EmployeeCRUDService();
		if (empCrud == null)
			return "redirect:/loginform";
		
		Employee emp = empCrud.getEmployeeById(id);
		String role = emp.getJob_title();
		
		request.getSession().setAttribute("user", emp);
		switch (role) {
			case "Project Manager":
				return "redirect:/pmdashboard";
			case "SPOC":
				return "redirect:/spocdashboard";
			default:
				return "";
		
		}
		
	}
	
}
