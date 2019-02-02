package trm.dao.controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import trm.dao.employee.Employee;
import trm.dao.employee.EmployeeCRUDService;
import trm.dao.trainingschedule.TrainingSchedule;
import trm.dao.trainingschedule.TrainingScheduleCRUDService;



@Controller
public class TRMController {
	
	//Home page
	@RequestMapping (value = "/")
	public String menu() {
		return "showmenu";
	}
	
	//Employee
	@RequestMapping (value = "showall")
	public String allEmployee(ModelMap map) {
		List<Employee> employees = new EmployeeCRUDService().getAllEmployee();
		map.addAttribute("employees", employees);
		return "allEmployee";
	}
	
	@RequestMapping(value = "deleteEmployee/{employee_id}")
	public String deleteEmployee(@PathVariable("employee_id") int employee_id, ModelMap map) {
		int ret = new EmployeeCRUDService().deleteEmployee(employee_id);
		if(ret > 0) return "redirect:/showall";
		else return "error";
	}
	
	@RequestMapping(value = "editEmployee/{employee_id}")
	public String editEmployee(@PathVariable("employee_id") int employee_id, ModelMap map) {
		Employee employee = new EmployeeCRUDService().getEmployeeById(employee_id);
		map.addAttribute("command", employee);
		return "editForm";
	}
	
	@RequestMapping(value = "saveUpdateData")
	public String editEmployee(@ModelAttribute("employee") Employee employee) {
		int ret = new EmployeeCRUDService().updateEmployee(
				employee.getEmployee_id(),
				employee.getLast_name(),
				employee.getFirst_name(),
				employee.getUser_name(),
				employee.getPassword(),
				employee.getPhone_number(),
				employee.getEmail(),
				employee.getStreet(),
				employee.getCity (),
				employee.getState(),
				employee.getCountry(),
				employee.getJob_title(),
				employee.getVertical(),
				employee.getProject(),
				employee.getPid());
		if(ret > 0) return "redirect:/showall";
		else return "error";
	}
	
	
	@RequestMapping(value = "insertForm")
	public String insertEmployeeObject(ModelMap map) {
		Employee employee = new Employee();
		map.addAttribute("command", employee);
		return "newEmployee";	
	}
	
	@RequestMapping(value = "insertemployee")
	public String insertEmployee(@ModelAttribute("employee") Employee employee) {
		int ret = new EmployeeCRUDService().insertCustomer(employee);
		if(ret > 0) return "redirect:/showall";
		else return "error";
	}
	
	@RequestMapping(value = "allRequests/{employee_id}")
	public String allRequestsFor(@PathVariable("employee_id") int employee_id, ModelMap map) {
		Employee employee = new Employee();
		map.addAttribute("command", employee);
		return "newEmployee";	
	}
	
	//Training Schedule
	@RequestMapping (value = "showalltrainingschedule")
	public String allTrainingSchedule(ModelMap map) {
		List<TrainingSchedule> schedules = new TrainingScheduleCRUDService().getAllTrainingSchedule();
		map.addAttribute("schedules", schedules);
		return "allTrainingSchedule";
	}
	
	@RequestMapping(value = "deletetrainingschedule/{training_schedule_id}")
	public String deleteTrainingSchedule(@PathVariable("training_schedule_id") String training_schedule_id, ModelMap map) {
		int ret = new TrainingScheduleCRUDService().deleteTrainingSchedule(training_schedule_id);
		if(ret > 0) return "redirect:/showalltrainingschedule";
		else return "error";
	}
	
	@RequestMapping(value = "edittrainingschedule/{training_schedule_id}")
	public String editTrainingSchedule(@PathVariable("training_schedule_id") String training_schedule_id, ModelMap map) {
		TrainingSchedule schedule = new TrainingScheduleCRUDService().getTrainingScheduleById(training_schedule_id);
		map.addAttribute("command", schedule);
		return "editScheduleForm";
	}
	
	@RequestMapping(value = "saveUpdateSchedule")
	public String editTrainingSchedule(@ModelAttribute("editTrainingSchedule") TrainingSchedule schedule) {
		int ret = new  TrainingScheduleCRUDService().updateTrainingSchedule(
				schedule.getTraining_schedule_id(),
				schedule.getTraining_city(),
				schedule.getTraining_state(),
				schedule.getTraining_country(),
				schedule.getTraining_zipcode(),
				schedule.getTraining_time_zone(),
				schedule.getTraining_location(),
				schedule.getTraining_room_number(),
				schedule.getTraining_start_date(),
				schedule.getTraining_end_date());
		if(ret > 0) return "redirect:/showalltrainingschedule";
		else return "error";
	}
	
	@RequestMapping(value = "gotoscheduleform")
	public String insertScheduleObject(ModelMap map) {
		TrainingSchedule schedule = new TrainingSchedule();
		map.addAttribute("command", schedule);
		return "newScheduleForm";	
	}
	
	@RequestMapping(value = "insertschedule")
	public String insertEmployee(@ModelAttribute("schedule") TrainingSchedule schedule) {
		int ret = new TrainingScheduleCRUDService().insertTrainingSchedule(schedule);
		if(ret > 0) return "redirect:/showalltrainingschedule";
		else return "error";
	}
}
